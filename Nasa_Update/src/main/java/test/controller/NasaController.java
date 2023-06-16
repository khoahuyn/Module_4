package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.model.Nasa;
import test.service.INasaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Controller
public class NasaController {
    @Autowired
    INasaService service;
    @GetMapping("/picture")
    public String showList(Model model){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate today = LocalDate.now();
        String todayString =  today.format(formatter);
        model.addAttribute("nasaList",service.findAllToday(todayString));
        model.addAttribute("nasaList",service.findAll());
        model.addAttribute("nasa", new Nasa());

        return "/nasa";
    }
//    @GetMapping("/addcomment")
//    public String showCreate(Model model){
//        return "redirect:/picture";
//    }
    @PostMapping("/addcomment")
    public String doCreate(@ModelAttribute("nasa") Nasa nasa) {
        service.create(nasa);
        return "redirect:/picture";
    }

    @GetMapping("/addLike")
    public String doLike(@RequestParam("id")Integer id) {
        service.addLike(service.findById(id));
        return "redirect:/picture";
    }

}
