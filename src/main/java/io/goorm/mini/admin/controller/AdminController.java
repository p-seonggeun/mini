package io.goorm.mini.admin.controller;

import io.goorm.mini.mapper.AdminMapper;
import io.goorm.mini.domain.Admin;
import io.goorm.mini.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/mgr")
public class AdminController {

    AdminMapper adminMapper;

    @Autowired
    public AdminController(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    //리스트
    @GetMapping("/admins")
    public String list(Model model) {

        model.addAttribute("posts", adminMapper.selectAll());

        return "mgr/admin/list";
    }

    //뷰
    @GetMapping("/admins/{adminSeq}")
    public String  get(@PathVariable Long adminSeq, Model model) {

        //model.addAttribute("posts", boardService.getBoards());

        return "mgr/admin/view";
    }

    //생성화면
    @GetMapping("/admins/create")
    public String  createForm(Model model) {

        //model.addAttribute("posts", boardService.getBoards());

        return "mgr/admin/create";
    }


    //생성
    @PostMapping("/admins")
    public String create(@ModelAttribute Admin admin, Model model) {

        return "redirect:/mgr/admins";
    }


    //수정화면
    @GetMapping("/admins/{adminSeq}/update")
    public String updateForm(@PathVariable Long adminSeq, Model model) {

        //model.addAttribute("posts", boardService.getBoards());

        return "mgr/admin/update";
    }

    //수정
    @PostMapping("/admins/{adminSeq}")
    public String  update(@ModelAttribute Admin admin, Model model, RedirectAttributes redirectAttributes) {

        redirectAttributes.addAttribute("adminSeq", admin.getAdminSeq());
        redirectAttributes.addFlashAttribute("msg", "수정에 성공하였습니다.");

        return "redirect:/mgr/admins/{adminSeq}";

        //return "redirect:/mgr/admins/" + admin.getAdminSeq();
    }

}
