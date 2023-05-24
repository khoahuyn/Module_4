package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandWich {

    @GetMapping("/home")
    public String main(){
        return "home";
    }


    @PostMapping("/save")
    public String chooce(@RequestParam (defaultValue = "") String[] condiment, Model model){
        String choose = Arrays.toString(condiment);
        model.addAttribute("condiment",choose);
        return "result";
    }





}
