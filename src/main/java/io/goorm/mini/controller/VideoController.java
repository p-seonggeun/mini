package io.goorm.mini.controller;

import io.goorm.mini.common.util.FileUploadUtil;
import io.goorm.mini.domain.Member;
import io.goorm.mini.domain.Video;
import io.goorm.mini.mapper.VideoMapper;
import io.goorm.mini.service.VideoService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class VideoController {

    VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    //리스트
    @GetMapping("/videos")
    public String list(Model model) {

        model.addAttribute("posts", videoService.findAll());
        model.addAttribute("title", "비디오-리스트" );

        return "video/list";
    }

    //뷰
    @GetMapping("/videos/{videoSeq}")
    public String  get(@PathVariable("videoSeq") Long videoSeq, Model model) {

        model.addAttribute("posts", videoService.find(videoSeq));
        model.addAttribute("title", "비디오-상세조회" );

        return "video/view";
    }

    //생성화면
    @GetMapping("/videos/create")
    public String  createForm(Model model, HttpSession session) {

        // 세션에서 로그인 정보 확인
        var member = session.getAttribute("member");

        if (member == null) {
            // 세션에 사용자 정보가 없으면 로그인 화면으로 리다이렉트
            return "redirect:/login";
        }

        // 로그인된 경우 생성 화면으로 이동
        model.addAttribute("title", "비디오-생성");

        return "video/create";
    }


    //생성
    @PostMapping("/videos")
    public String create(@ModelAttribute Video video,
                         @RequestParam("videoFile") MultipartFile videoFile,
                         @RequestParam("videoThumnailFile") MultipartFile videoThumbnailFile,
                         Model model) {

        // 업로드된 파일 처리 (서비스를 통해 위임)
        String videoPath = FileUploadUtil.uploadFile(videoFile, "vod");
        String thumbnailPath = FileUploadUtil.uploadFile(videoThumbnailFile, "thumbnail");

        // 업로드된 파일 경로를 엔티티에 설정
        video.setVideo(videoPath);
        video.setVideoThumnail(thumbnailPath);

        try {
            videoService.save(video);

            model.addAttribute("msg", "비디오가 성공적으로 등록 되었습니다.");

        } catch (Exception e) {
            model.addAttribute("msg", "비디오가 등록에 실패하였습니다.");
            return "redirect:/videos"; // 예외 발생시 회원가입 폼으로
        }
        
        return "redirect:/";
    }


    //수정화면
    @GetMapping("/videos/{videoSeq}/update")
    public String updateForm(@PathVariable("videoSeq") Long videoSeq, Model model) {

        model.addAttribute("posts", videoService.find(videoSeq));
        model.addAttribute("title", "비디오-수정" );

        return "video/update";
    }

    //수정
    @PostMapping("/videos/{videoSeq}")
    public String  update(@ModelAttribute Video video, Model model, RedirectAttributes redirectAttributes) {

        redirectAttributes.addAttribute("videoSeq", video.getVideoSeq());
        redirectAttributes.addFlashAttribute("msg", "수정에 성공하였습니다.");

        return "redirect:/videos/{videoSeq}";

        //return "redirect:/mgr/videos/" + video.getVideoSeq();
    }

}
