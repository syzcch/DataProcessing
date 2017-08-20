package net.quantiful.dataprocess.repository;

import net.quantiful.dataprocess.model.DataSetObj;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by rogersong on 19/08/17.
 */
@Repository
@Mapper
public interface DataSetMapper {
    @Insert("INSERT INTO dataset(status_id, " +
            " status_message, " +
            " link_name, " +
            " status_type, " +
            " status_link, " +
            " status_published, " +
            " num_reactions, " +
            " num_comments, " +
            " num_shares, " +
            " num_likes, " +
            " num_loves, " +
            " num_wows, " +
            " num_hahas, " +
            " num_sads, " +
            " num_angrys, " +
            " impact_score, " +
            " page_id, " +
            " source_type, " +
            " auckland, " +
            " council, " +
            " mayor, " +
            " goff, " +
            " councillor, " +
            " localBoard, " +
            " tier1) VALUES( " +
            "#{statusId}, " +
            "#{statusMessage}, " +
            "#{linkName}, " +
            "#{statusType}, " +
            "#{statusLink}, " +
            "#{statusPublished}, " +
            "#{numReactions}, " +
            "#{numComments}, " +
            "#{numShares}, " +
            "#{numLikes}, " +
            "#{numLoves}, " +
            "#{numWows}, " +
            "#{numHahas}," +
            "#{numSads}, " +
            "#{numAngrys}, " +
            "#{impactScore}, " +
            "#{pageId}, " +
            "#{sourceType}, " +
            "#{auckland}, " +
            "#{council}, " +
            "#{mayor}, " +
            "#{goff}, " +
            "#{councillor}, " +
            "#{localBoard}, " +
            "#{tier1})"
    )
    int insert(DataSetObj dataSetObj);
}

