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
public class CustomerRes {
    String name;
    int male;
    int female;
    int commentNum;
    int likes;
}
