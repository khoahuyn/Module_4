package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.model.Blog;
import test.service.IBlogService;


@Controller
public class BlogController {
    @Autowired
    IBlogService service;
    @GetMapping("/blog")
    public String showList(Model model){
        model.addAttribute("blogList",service.findAll());
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {
        service.create(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") Integer id, Model model){
        model.addAttribute("blog", service.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        service.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String doDelete(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        service.deleteById(id);
        return "redirect:/blog";
    }

}
