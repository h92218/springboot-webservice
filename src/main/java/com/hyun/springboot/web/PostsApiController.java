package com.hyun.springboot.web;

import com.hyun.springboot.service.posts.PostsService;
import com.hyun.springboot.web.dto.PostsResponseDto;
import com.hyun.springboot.web.dto.PostsSaveRequestDto;
import com.hyun.springboot.web.dto.PostsUpdateRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService ;

    @PostMapping("/api/v1/posts")
    public Long Save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,@RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
