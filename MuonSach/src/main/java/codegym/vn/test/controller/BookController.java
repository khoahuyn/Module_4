package codegym.vn.test.controller;

import codegym.vn.test.model.Book;
import codegym.vn.test.model.Borrow;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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


    @GetMapping("/borrow")
    public String showBorrow(@RequestParam("bookId") Integer bookId, Model model) throws ParseException {
        Borrow borrow = new Borrow();
        LocalDateTime today = LocalDateTime.now();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(today));
        borrow.setBorrowedDate(date);
        borrow.setUserId((int)(10000+Math.random()*9999));
        model.addAttribute("books", service.findById(bookId));
        model.addAttribute("borrow", borrow);
        return "book/borrow";
    }

    @PostMapping("/borrow")
    public String doBorrow(@ModelAttribute("borrow") Borrow borrow)throws Exception{
        if (borrow.getBook().getQuantity() > 0 ){
            borrow.getBook().setQuantity(borrow.getBook().getQuantity() - 1);
        }

        borrowService.create(borrow);
        return "redirect:/listUser";
    }


    @GetMapping("/pay")
    public String showPay(@RequestParam("bookId") Integer bookId, Model model) throws ParseException {
        Borrow borrow = new Borrow();
        LocalDateTime today = LocalDateTime.now();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(today));
        borrow.setPayDay(date);
        borrow.setUserId((int)(10000+Math.random()*9999));
        model.addAttribute("books", service.findById(bookId));
        model.addAttribute("borrow", borrow);
        return "book/borrow";
    }

    @GetMapping("/listUser")
    public String showListUser(Model model) {
        model.addAttribute("borrow", borrowService.findAll());
        return "book/listUser";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Book> bookList = service.findAllByName(name);
        model.addAttribute("bookList", bookList);
        model.addAttribute("name", name);
        return "book/list";
    }


}
