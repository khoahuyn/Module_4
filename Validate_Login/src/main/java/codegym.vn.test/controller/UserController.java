package codegym.vn.test.controller;

import codegym.vn.test.model.User;
import codegym.vn.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class UserController {
    @Autowired
    IUserService service;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("user", new User());
        return "user/view";
    }


    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/view";
        }
        return "user/result";
    }



}
