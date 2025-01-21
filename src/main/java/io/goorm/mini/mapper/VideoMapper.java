package io.goorm.mini.mapper;

import io.goorm.mini.vo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {

    List<Video> selectIndex();

    List<Video> selectAll();

    Video selectById(@Param("videoSeq") Long videoSeq);

    int insert(@Param("video") Video video);

    int update(@Param("video") Video video, @Param("videoSeq") Long videoSeq);

    int updatePublish(@Param("video") Video video, @Param("videoSeq") Long videoSeq);

    int updateDelete(@Param("video") Video video, @Param("videoSeq") Long videoSeq);

    int delete(@Param("videoSeq") Long videoSeq);

}
