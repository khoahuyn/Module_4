package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TinhToan {
    @GetMapping({"/money",""})
    public String Calculate(@RequestParam (defaultValue = "0")String usd, Model model){
        double  result = Double.parseDouble(usd)*23000;
        model.addAttribute("result",result);
        return "chuyendoi";
    }
}
