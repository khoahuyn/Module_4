package codegym.vn.controller;

import codegym.vn.model.Nasa;
import codegym.vn.service.INasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


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
        return "nasa/nasa";
    }
    @GetMapping("/addcomment")
    public String showCreate(Model model){
        return "redirect:/picture";
    }

    @PostMapping("/addcomment")
    public String doCreate(@ModelAttribute("nasa") Nasa nasa)throws Exception {
        String[] ban={"dog","abcc","xyz","123","clm","fuck","sex"};

        for(String c:ban){
            if(nasa.getFeedback().contains(c)){
                throw new Exception();
            }
        }
        service.create(nasa);
        return "redirect:/picture";
    }

    @GetMapping("/addLike")
    public String doLike(@RequestParam("id")Integer id) {
        service.addLike(service.findById(id));
        return "redirect:/picture";
    }


    @GetMapping("/listpaging")
    public String listPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Nasa> nasaList = service.findAllWithPaging(PageRequest.of(page, 4));
        model.addAttribute("nasaList", nasaList);
        model.addAttribute("nasa", new Nasa());
        return "nasa/listPaging";
    }

    @GetMapping(value = "/listpagingslice")
    public String listPagingSlice(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Slice<Nasa> nasaList = service.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("nasaList", nasaList.getContent());
        model.addAttribute("page", nasaList);
        model.addAttribute("nasa", new Nasa());
        return "nasa/listPagingSlice";
    }

    @ExceptionHandler(SQLException.class)
    public String handleError(SQLException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "errorPage";
    }

}
