package io.goorm.mini.controller;

import io.goorm.mini.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/")
    public String index(Model model) throws Exception {

        model.addAttribute("video", videoService.getVideosForIndex());

        return "index";
    }
}
