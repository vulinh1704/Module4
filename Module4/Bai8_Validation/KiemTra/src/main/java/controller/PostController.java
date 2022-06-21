package controller;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IPostService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    IPostService postService;

    @GetMapping("")
    public ModelAndView show(@PageableDefault(value = 1) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("posts", postService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(Post post) {
        LocalDateTime time = LocalDateTime.now();
        post.setCreateAt(time);
        postService.save(post);
        return new ModelAndView("redirect:/posts");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        Post post = postService.findById(id).get();
        modelAndView.addObject("pro", post);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(Post post) {
        post.setCreateAt(LocalDateTime.now());
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");
        return modelAndView;
    }

    @GetMapping ("/search")
    public ModelAndView findByTitle(String title ,@PageableDefault(value = 3) Pageable pageable){
        title = "%" + title + "%";
        Page<Post> posts = postService.findByTitle1(title , pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("postsByTitle" , posts);
        return modelAndView;
    }

//    @PostMapping("")
//    public ModelAndView findByTitle(String title) {
//        title = "%" + title + "%";
//        HashMap<Integer , List<Post>> posts = postService.findByT(title);
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("postsByTitle", posts);
//        return modelAndView;
//    }
}
