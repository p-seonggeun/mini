package io.goorm.mini.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {

    private Long memberSeq;
    private String memberId;
    private String memberPw;
    private String memberNick;

    private String memberProfile;

    private String memberInfo;

    private String useYn;
    private String regDate;
}
