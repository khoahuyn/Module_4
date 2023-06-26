package codegym.vn.test.controller;

import codegym.vn.test.model.Music;
import codegym.vn.test.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class MusicController {
    @Autowired
    IMusicService service;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("musicList",service.findAll());
        return "music/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music", new Music());
        return "music/create";
    }
    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("music") Music music, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "music/create";
        }
        service.create(music);
        return "redirect:music/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(Model model,@PathVariable("id") int id) {
        model.addAttribute("music", service.findById(id));
        return "music/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("music") Music music) {
        service.update(music);
        return "redirect:music/list";
    }
}
