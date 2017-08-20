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
public class DataSetObj implements Serializable {
    String statusId;
    String statusMessage;
    String linkName;
    String statusType;
    String statusLink;
    String statusPublished;
    int numReactions;
    int numComments;
    int numShares;
    int numLikes;
    int numLoves;
    int numWows;
    int numHahas;
    int numSads;
    int numAngrys;
    int impactScore;
    String pageId;
    String sourceType;
    int auckland;
    int council;
    int mayor;
    int goff;
    int councillor;
    int localBoard;
    int tier1;
}
