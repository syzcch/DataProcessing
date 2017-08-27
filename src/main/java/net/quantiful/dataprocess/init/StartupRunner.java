package net.quantiful.dataprocess.init;

import net.quantiful.dataprocess.model.CommentObj;
import net.quantiful.dataprocess.model.DataSetObj;
import net.quantiful.dataprocess.repository.CommentMapper;
import net.quantiful.dataprocess.repository.DataSetMapper;
import net.quantiful.dataprocess.utils.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rogersong on 20/08/17.
 */

@Component
public class StartupRunner implements CommandLineRunner {

    //dataset.url = /Users/rogersong/Downloads/tier1FBPosts.csv      means post file
    @Value("${dataset.url}")
    private String dataSet;

    //comments.url = /Users/rogersong/Downloads/tier1FBPosts_facebook_comments.csv    means comments file
    @Value("${comments.url}")
    private String comment;

    @Value("${loaddata}")
    private String loadData;

    @Autowired
    DataSetMapper dataSetMapper;

    @Autowired
    CommentMapper commentMapper;

    //init it
    private void initDataSet() throws SQLException, ClassNotFoundException {
        // if it equals yes, then load data files and cleaning and processing then store them into db
        if(loadData.toLowerCase().equals("yes")){
            List<String[]> commentList = DataLoader.loadCSV(comment);
            List<String[]> dataSetList = DataLoader.loadCSV(dataSet);
            List<DataSetObj> dataSetObj = DataLoader.buildDataSet(dataSetList);
            System.out.println(dataSetObj.size());
            List<CommentObj> commentListObj = DataLoader.buildCommentList(commentList);

            System.out.println(commentListObj.size());

            for(int i = 0; i < dataSetObj.size(); i++){
                dataSetMapper.insert(dataSetObj.get(i));
            }

            for(int i = 0; i < commentListObj.size(); i++){
                try {
                    commentMapper.insert(commentListObj.get(i));
                } catch (Exception e){
                    continue;
                }

            }
        }

        TestHive.runit();
    }

    @Override
    public void run(String... args) throws Exception {
        initDataSet();
        Logger.getLogger(this.getClass().getName()).log(Level.ALL, ">>>>>>>>>>>>>>>start init job<<<<<<<<<<<<<");
    }

}


