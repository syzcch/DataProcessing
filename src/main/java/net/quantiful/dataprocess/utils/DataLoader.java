package net.quantiful.dataprocess.utils;

import au.com.bytecode.opencsv.CSVReader;
import net.quantiful.dataprocess.model.CommentObj;
import net.quantiful.dataprocess.model.DataSetObj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rogersong on 18/08/17.
 */
public class DataLoader {

    public static List<String[]> loadCSV(String fileName){
        File file = new File(fileName);
        FileReader fReader = null;
        List<String[]> list = null;
        try {
            fReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fReader);

            try {
                list = csvReader.readAll();
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (String[] rows : list) {
                System.out.println(Arrays.toString(rows));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<DataSetObj> buildDataSet(List<String[]> dataSetList){
        List<DataSetObj> res = new ArrayList<DataSetObj>();

        for(int i = 1; i < dataSetList.size(); i++){
            DataSetObj dataSetObj = new DataSetObj();
            try{
                dataSetObj.setStatusId(dataSetList.get(i)[0]);
                dataSetObj.setStatusMessage(dataSetList.get(i)[1]);
                dataSetObj.setLinkName(dataSetList.get(i)[2]);
                dataSetObj.setStatusType(dataSetList.get(i)[3]);
                dataSetObj.setStatusLink(dataSetList.get(i)[4]);
                dataSetObj.setStatusPublished(dataSetList.get(i)[5]);
                dataSetObj.setNumReactions(Integer.parseInt(dataSetList.get(i)[6]));
                dataSetObj.setNumComments(Integer.parseInt(dataSetList.get(i)[7]));
                dataSetObj.setNumShares(Integer.parseInt(dataSetList.get(i)[8]));
                dataSetObj.setNumLikes(Integer.parseInt(dataSetList.get(i)[9]));
                dataSetObj.setNumLoves(Integer.parseInt(dataSetList.get(i)[10]));
                dataSetObj.setNumWows(Integer.parseInt(dataSetList.get(i)[11]));
                dataSetObj.setNumHahas(Integer.parseInt(dataSetList.get(i)[12]));
                dataSetObj.setNumSads(Integer.parseInt(dataSetList.get(i)[13]));
                dataSetObj.setNumAngrys(Integer.parseInt(dataSetList.get(i)[14]));
                dataSetObj.setImpactScore(Integer.parseInt(dataSetList.get(i)[15]));
                dataSetObj.setPageId(dataSetList.get(i)[16]);
                dataSetObj.setSourceType(dataSetList.get(i)[17]);
                dataSetObj.setAuckland(Integer.parseInt(dataSetList.get(i)[18]));
                dataSetObj.setCouncil(Integer.parseInt(dataSetList.get(i)[19]));
                dataSetObj.setMayor(Integer.parseInt(dataSetList.get(i)[20]));
                dataSetObj.setGoff(Integer.parseInt(dataSetList.get(i)[21]));
                dataSetObj.setCouncillor(Integer.parseInt(dataSetList.get(i)[22]));
                dataSetObj.setLocalBoard(Integer.parseInt(dataSetList.get(i)[23]));
                dataSetObj.setTier1(Integer.parseInt(dataSetList.get(i)[24]));
            } catch (NumberFormatException e){
                System.out.println(e);
                continue;
            }

            res.add(dataSetObj);
        }
        return res;
    }

    public static List<CommentObj> buildCommentList(List<String[]> commentList){
        List<CommentObj> res = new ArrayList<CommentObj>();

        for(int i = 1; i < commentList.size(); i++){
            CommentObj commentObj = new CommentObj();
            try{
                commentObj.setCommentId(commentList.get(i)[0]);
                commentObj.setStatusId(commentList.get(i)[1]);
                commentObj.setParentId(commentList.get(i)[2]);
                commentObj.setCommentMessage(commentList.get(i)[3]);
//                System.out.println("@@@@   num : " + i + "  res : " + commentList.get(i)[4]);
                commentObj.setCommentAuthor(commentList.get(i)[4]);
                commentObj.setCommentPublished(commentList.get(i)[5]);
                commentObj.setCommentLikes(Integer.parseInt(commentList.get(i)[6]));
                commentObj.setGender(commentList.get(i)[7]);
                commentObj.setTierType(commentList.get(i)[8]);
                commentObj.setPolarity(Integer.parseInt(commentList.get(i)[9]));
                commentObj.setPositive(Integer.parseInt(commentList.get(i)[10]));
                commentObj.setNegative(Integer.parseInt(commentList.get(i)[11]));
                commentObj.setNeutral(Integer.parseInt(commentList.get(i)[12]));
            } catch (NumberFormatException e) {
                System.out.println(e);
                continue;
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e);
                continue;
            }

            res.add(commentObj);
        }
        return res;
    }
}
