package com.controller;

import com.controller.Service.ComputerService;
import com.controller.Service.ComputerServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TinhToan {

    ComputerService service=new ComputerServiceimpl();
    @GetMapping("")
    public String home(){
        return "calculate";
    }

    @PostMapping("/calculate")
    public String caculator(@RequestParam("number1") double number1, @RequestParam("number2") double number2,
                            @RequestParam("calculation") String calculation, Model model) {
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        model.addAttribute("result", service.calculate(number1, number2, calculation));
        return "calculate";
    }


}
