package io.goorm.mini.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Admin {

    private Long adminSeq;
    private String adminId;
    private String adminPw;
    private String adminName;
    private String useYn;

    private String regSeq;
    private String regDate;
}
