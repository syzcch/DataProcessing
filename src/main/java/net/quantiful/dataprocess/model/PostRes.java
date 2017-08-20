package net.quantiful.dataprocess.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Created by rogersong on 20/08/17.
 */
@Builder
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRes {
    String status_id;
    int num_likes;
    int num_dislikes;
    int num_comments;
    int num_male;
    int num_female;
    int num_unknown;
}
