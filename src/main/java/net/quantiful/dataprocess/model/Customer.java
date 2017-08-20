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
public class Customer {
    String name;
    String gender;
    int likes;
}
