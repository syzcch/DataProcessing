package net.quantiful.dataprocess.repository;

import net.quantiful.dataprocess.model.CommentObj;
import net.quantiful.dataprocess.model.Customer;
import net.quantiful.dataprocess.model.PostInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rogersong on 19/08/17.
 */
@Repository
@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO CommentSet(comment_id, " +
            " status_id, " +
            " parent_id, " +
            " comment_message, " +
            " comment_author, " +
            " comment_published, " +
            " comment_likes, " +
            " gender, " +
            " tier_type, " +
            " polarity, " +
            " positive, " +
            " negative, " +
            " neutral) VALUES( " +
            "#{commentId}, " +
            "#{statusId}, " +
            "#{parentId}, " +
            "#{commentMessage}, " +
            "#{commentAuthor}, " +
            "#{commentPublished}, " +
            "#{commentLikes}, " +
            "#{gender}, " +
            "#{tierType}, " +
            "#{polarity}, " +
            "#{positive}, " +
            "#{negative}, " +
            "#{neutral})"
    )
    int insert(CommentObj commentObj);

    @Select("SELECT comment_author as name, gender, comment_likes as likes FROM commentset WHERE comment_author = #{auName}")
    @Results({
            @Result(property = "name", column = "comment_author"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "likes", column = "comment_likes")
    })
    List<Customer> getCustomers(@Param("auName")String name);

    @Select("select dataset.status_id as status_id, dataset.num_likes as num_likes, dataset.num_loves as num_loves, dataset.num_sads as num_sads,dataset.num_angrys as num_angrys, commentset.gender, commentset.comment_author as comment_author, commentset.comment_likes as comment_likes from dataset, commentset where dataset.status_id = commentset.status_id and dataset.status_id = #{id}")
    @Results({
            @Result(property = "status_id", column = "status_id"),
            @Result(property = "num_likes", column = "num_likes"),
            @Result(property = "num_loves", column = "num_loves"),
            @Result(property = "num_sads", column = "num_sads"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "comment_author", column = "comment_author"),
            @Result(property = "comment_likes", column = "comment_likes")
    })
    List<PostInfo> getPostInfo(@Param("id")String id);

    @Select("select status_id from (select dataset.status_id as status_id , count(*) as A from dataset, commentset where dataset.status_id = commentset.status_id group by status_id order by A desc limit #{num}) x")
    List<String> getTopN(int num);
}
