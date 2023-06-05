package test.controller;

import org.springframework.web.bind.annotation.PathVariable;
import test.model.Music;
import test.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {
    @Autowired
    IMusicService service;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("musicList",service.findAll());
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music", new Music());
        return "/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("music") Music music) {
        service.create(music);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(Model model,@PathVariable("id") int id) {
        model.addAttribute("music", service.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("music") Music music) {
        service.update(music);
        return "redirect:/list";
    }
}
