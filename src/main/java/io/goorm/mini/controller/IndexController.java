package io.goorm.mini.controller;

import io.goorm.mini.common.util.PasswordUtil;
import io.goorm.mini.domain.Admin;
import io.goorm.mini.domain.Member;
import io.goorm.mini.service.MemberService;
import io.goorm.mini.service.VideoService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.env.Environment;

import java.util.Locale;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    private VideoService videoService;

    @Autowired
    public IndexController(VideoService videoService) {
        this.videoService = videoService;
    }

    //메인화면
    @GetMapping("")
    public String  index(Model model) {

        model.addAttribute("videos", videoService.findIndex());

        return "index";
    }

}
