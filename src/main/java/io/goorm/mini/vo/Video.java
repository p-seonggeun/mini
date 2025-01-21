package io.goorm.mini.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video {

    private Long videoSeq;
    private String video;

    private String videoThumnail;
    private String memberSeq;
    private String regDate;

    private int publishYn;
    private String deleteYn;

}
