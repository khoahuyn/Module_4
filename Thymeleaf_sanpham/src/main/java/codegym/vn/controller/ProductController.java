package codegym.vn.controller;

import codegym.vn.model.Product;
import codegym.vn.service.impl.CategoryServiceImpl;
import codegym.vn.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product_thymleaf/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "product_thymleaf/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product) {
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product_thymleaf/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "product_thymleaf/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product) {
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.update(product);
        return "redirect:/product/list";
    }
}
