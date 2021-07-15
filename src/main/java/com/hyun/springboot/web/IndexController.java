package com.hyun.springboot.web;

import com.hyun.springboot.config.auth.dto.SessionUser;
import com.hyun.springboot.service.posts.PostsService;
import com.hyun.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;


    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        System.out.println("user : " + user);
        if(user!=null){
            model.addAttribute("userName",user.getName());
            System.out.println("userName : " + model.getAttribute("userName"));
        }
        return "index";
    }

    @GetMapping("/vue")
    public String vue(){
        System.out.println(">>>>>>>>>>>>>>>>>call vue");

        return "vue/index";
    }

}
