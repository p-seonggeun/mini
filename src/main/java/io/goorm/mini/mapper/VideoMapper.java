package io.goorm.mini.mapper;

import io.goorm.mini.domain.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {

    List<Video> selectIndex();

    List<Video> selectAll();

    Video selectById(@Param("videoSeq") Long seq);

    int insert(@Param("video") Video video);

    int update(@Param("video") Video video);

    int updatePublishYn(@Param("video") Video video);

    int updateDeleteYn(@Param("video") Video video);

    int delete(@Param("videoSeq") Long seq);

}
