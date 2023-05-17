package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/hienthi")
public class HienThi {
    @GetMapping("/")
    public String hienthi(@RequestParam (defaultValue = "chưa có ai") String name, Model model){
        model.addAttribute("name",name);
        return "hienthi";
    }
}
