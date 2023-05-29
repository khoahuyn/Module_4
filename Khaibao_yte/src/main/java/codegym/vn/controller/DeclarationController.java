package codegym.vn.controller;

import codegym.vn.model.Declaration;
import codegym.vn.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/yte")
public class DeclarationController {
    @Autowired
    private DeclarationService service;


    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("declaration", service.findAll());
        return "list";
    }

//    @GetMapping("/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("declaration", new Declaration());
//        model.addAttribute("yearOfBirthList", service.yearOfBirthList());
//        model.addAttribute("genderList", service.genderList());
//        model.addAttribute("nationalityList", service.nationalityList());
//        model.addAttribute("vehicleList", service.vehicleList());
//        return "create";
//    }
//
//    @PostMapping("/create")
//    public String doCreate(@ModelAttribute("declaration") Declaration declaration) {
//        service.create(declaration);
//        return "redirect:/list";
//    }

    @GetMapping("/update")
    public String showEditForm(Model model,@RequestParam String iCard) {
        model.addAttribute("declaration", service.findByIdentifyCard(iCard));
        model.addAttribute("yearOfBirthList", service.yearOfBirthList());
        model.addAttribute("genderList", service.genderList());
        model.addAttribute("nationalityList", service.nationalityList());
        model.addAttribute("vehicleList", service.vehicleList());
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("declaration") Declaration declaration){
        service.update(declaration);
        return "redirect:/yte/list";
    }
}
