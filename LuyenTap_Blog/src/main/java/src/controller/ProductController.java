package src.controller;

import org.springframework.validation.BindingResult;
import src.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import src.service.ICategoryService;
import src.service.IProductService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ICategoryService iCategoryService;

    @Autowired
    IProductService iProductService;

    @GetMapping("/blog")
    public String showList(Model model) {
        model.addAttribute("productList", iProductService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", iCategoryService.findAll());
        return "product/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product, BindingResult bindingResult, Model model) throws ParseException {
        LocalDateTime today = LocalDateTime.now();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(today));
        product.setDateRelease(date);
        product.setCategory(iCategoryService.findById(product.getCategory().getCategoryId()));
        new Product().validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", iCategoryService.findAll());
            return "product/create";
        }
        iProductService.create(product);
        return "redirect:/blog";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("productId") Integer productId, Model model) {
        model.addAttribute("product", iProductService.findById(productId));
        model.addAttribute("categories", iCategoryService.findAll());
        return "product/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product) {
        product.setCategory(iCategoryService.findById(product.getCategory().getCategoryId()));
        iProductService.update(product);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showDetailForm(@RequestParam("productId") Integer productId, Model model){
        model.addAttribute("product",iProductService.findById(productId));
        model.addAttribute("categories",iCategoryService.findAll());
        return "product/detail";
    }

    @GetMapping("/delete")
    public String doDelete(@RequestParam("productId") Integer productId, Model model) {
        model.addAttribute("product", iProductService.findById(productId));
        iProductService.deleteById(productId);
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String doSearch(@RequestParam("name") String name, Model model) {
        List<Product> productList = iProductService.findAllByName(name);
        model.addAttribute("productList", productList);
        model.addAttribute("name", name);
        return "product/list";
    }

    @GetMapping("/listpaging")
    public String listPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> productList = iProductService.findWithByPaging(PageRequest.of(page, 4));
        model.addAttribute("productList", productList);
        return "product/listPaging";
    }


}
