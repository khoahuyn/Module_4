package codegym.vn.controller;

import codegym.vn.model.Mail;
import codegym.vn.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;


    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("mails", mailService.findAll());
        return "list";
    }

    @GetMapping("/edit")
    public String showEdit(Model model,@RequestParam int id) {
        model.addAttribute("mail", mailService.findID(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String doEdit(@ModelAttribute("mail") Mail mail) {
        mailService.edit(mail);
        return "redirect:list";
    }
}
