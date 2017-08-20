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
public class PostInfo {
    String status_id;
    int num_likes;
    int num_loves;
    int num_sads;
    int num_angrys;
    String gender;
    String comment_author;
    int comment_likes;
}
