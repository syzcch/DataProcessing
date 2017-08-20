# we call it fb for this proj
create database fb2;
use fb2;

drop table if exists dataset;
create table dataset(
    status_id varchar(255),
    status_message text,
    link_name varchar(255),
    status_type varchar(255),
    status_link varchar(500),
    status_published varchar(255),
    num_reactions int,
    num_comments int,
    num_shares int,
    num_likes int,
    num_loves int,
    num_wows int,
    num_hahas int,
    num_sads int,
    num_angrys int,
    impact_score int,
    page_id varchar(255),
    source_type varchar(255),
    auckland int,
    council int,
    mayor int,
    goff int,
    councillor int,
    localBoard int,
    tier1 int,
    PRIMARY KEY (`status_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists CommentSet;
create table CommentSet(
    comment_id varchar(255),
    status_id varchar(255),
    parent_id varchar(255),
    comment_message text,
    comment_author varchar(255),
    comment_published varchar(255),
    comment_likes int,
    gender varchar(10),
    tier_type varchar(255),
    polarity int,
    positive int,
    negative int,
    neutral int,
    PRIMARY KEY (`comment_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
