package codegym.vn.test.controller;

import codegym.vn.test.model.Book;
import codegym.vn.test.service.IBookService;
import codegym.vn.test.service.IBorrowService;
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
public class BookController {
    @Autowired
    IBookService service;

    @Autowired
    IBorrowService borrowService;

    @GetMapping("/book")
    public String showList(Model model) {
        model.addAttribute("bookList", service.findAll());
        return "book/list";
    }

//    @GetMapping("/create")
//    public String showCreate(Model model) {
//        model.addAttribute("book", new Book());
//        model.addAttribute("borrows", borrowService.findAll());
//        return "book/create";
//    }
//
//    @PostMapping("/create")
//    public String doCreate(@ModelAttribute("book") Book book) {
//        book.setCategory(categoryService.findById(book.getCategory().getCategoryId()));
//        service.create(book);
//        return "redirect:/book";
//    }
//
//    @GetMapping("/update")
//    public String showUpdate(@RequestParam("id") Integer id, Model model) {
//        model.addAttribute("blog", service.findById(id));
//        model.addAttribute("categories", categoryService.findAll());
//        return "blog/update";
//    }
//
//    @PostMapping("/update")
//    public String doUpdate(@ModelAttribute("blog") Book book) {
//        book.setCategory(categoryService.findById(book.getCategory().getCategoryId()));
//        service.update(book);
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/delete")
//    public String doDelete(@RequestParam("id") Integer id, Model model) {
//        model.addAttribute("blog", service.findById(id));
//        service.deleteById(id);
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/search")
//    public String search(@RequestParam("name") String name, Model model) {
//        List<Book> bookList = service.findAllByName(name);
//        model.addAttribute("blogList", bookList);
//        model.addAttribute("name", name);
//        return "blog/list";
//    }
//
//
//    @GetMapping("/listpaging")
//    public String listPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//        Page<Book> blogList = service.findAllWithPaging(PageRequest.of(page, 4));
//        model.addAttribute("blogList", blogList);
//        return "blog/listPaging";
//    }
//
//    @GetMapping(value = "/listpagingslice")
//    public String listPagingSlice(Model model, @RequestParam("page") Optional<Integer> page,
//                                  @RequestParam("size") Optional<Integer> size) {
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(3);
//        Slice<Book> blogList = service.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
//        model.addAttribute("blogList", blogList.getContent());
//        model.addAttribute("page", blogList);
//        return "blog/listPagingSlice";
//    }

}
