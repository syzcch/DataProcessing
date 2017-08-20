package net.quantiful.dataprocess.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by rogersong on 18/08/17.
 */

@Builder
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentObj implements Serializable {
    String commentId;
    String statusId;
    String parentId;
    String commentMessage;
    String commentAuthor;
    String commentPublished;
    int commentLikes;
    String gender;
    String tierType;
    int polarity;
    int positive;
    int negative;
    int neutral;
}
