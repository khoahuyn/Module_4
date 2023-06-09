package codegym.vn.test.controller;

import codegym.vn.test.model.Blog;
import codegym.vn.test.service.IBlogService;
import codegym.vn.test.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class BlogController {
    @Autowired
    IBlogService service;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/blog")
    public String showList(Model model) {
        model.addAttribute("blogList", service.findAll());
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {
        blog.setCategory(categoryService.findById(blog.getCategory().getCategoryId()));
        service.create(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        blog.setCategory(categoryService.findById(blog.getCategory().getCategoryId()));
        service.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String doDelete(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        service.deleteById(id);
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String search(@RequestParam("title") String title, Model model) {
        List<Blog> blogList = service.findBlogByTitle(title);
        model.addAttribute("blogList", blogList);
        model.addAttribute("title", title);
        return "blog/list";
    }


    @GetMapping("/listpaging")
    public String listPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Blog> blogList = service.findAllWithPaging(PageRequest.of(page, 4));
        model.addAttribute("blogList", blogList);
        return "blog/listPaging";
    }

    @GetMapping(value = "/listpagingslice")
    public String listPagingSlice(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Slice<Blog> blogList = service.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("blogList", blogList.getContent());
        model.addAttribute("page", blogList);
        return "blog/listPagingSlice";
    }

}
