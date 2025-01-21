package io.goorm.mini.service;

import io.goorm.mini.mapper.VideoMapper;
import io.goorm.mini.vo.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;

    public List<Video> getVideosForIndex() {
        return videoMapper.selectIndex();
    }
}
