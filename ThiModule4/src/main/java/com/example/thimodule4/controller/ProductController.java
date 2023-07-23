package com.example.thimodule4.controller;


import com.example.thimodule4.entity.Product;
import com.example.thimodule4.service.ICategoryService;
import com.example.thimodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ICategoryService iCategoryService;

    @Autowired
    IProductService iProductService;

    @GetMapping("/blog")
    public String showList(Model model) {
        model.addAttribute("productList", iProductService.findAll());
        model.addAttribute("categories", iCategoryService.findAll());
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

    @GetMapping("/searchByPrice")
    public String doSearch(@RequestParam("price") double price, Model model) {
        List<Product> productList = iProductService.findProductByPrice(price);
        model.addAttribute("productList", productList);
        model.addAttribute("price", price);
        return "product/list";
    }

    @GetMapping("/searchByCategory")
    public String doSearch(@RequestParam("categoryId") Integer categoryId, Model model) {
        List<Product> productList = iProductService.findProductByCategory(categoryId);
        model.addAttribute("categories", iCategoryService.findAll());
        model.addAttribute("productList", productList);
        model.addAttribute("categoryId", categoryId);
        return "product/list";
    }

    @GetMapping("/listpaging")
    public String listPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> productList = iProductService.findWithByPaging(PageRequest.of(page, 5));
        model.addAttribute("productList", productList);
        return "product/listPaging";
    }


}
