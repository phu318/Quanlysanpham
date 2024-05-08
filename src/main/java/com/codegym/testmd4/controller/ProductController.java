package com.codegym.testmd4.controller;

import com.codegym.testmd4.model.Product;
import com.codegym.testmd4.service.ProductService;
import com.codegym.testmd4.service.TypeProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final TypeProductService typeProductService;
    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "") String name) {
        return new ModelAndView("index")
                .addObject("listproduct", productService.findByName(name))
                .addObject(name);

    }
    @GetMapping("/add")
    public ModelAndView showFormCreate() {
        return new ModelAndView("add")
                .addObject("listtype", typeProductService.getAllTypeProduct())
                .addObject("product", new Product());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        return new ModelAndView("update")
                .addObject("product", productService.getDetailProductBy(id))
                .addObject("listtype", typeProductService.getAllTypeProduct());
    }
    @PostMapping("/add")
    public String addProduct(@ModelAttribute @Valid Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Thêm mới sản phẩm thành công!!");
        return "redirect:/product";
    }
    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute @Valid Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Sửa thông tin sản phẩm thành công!");
        return "redirect:/product";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) throws Exception {
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa sản phẩm thành công!");
        return "redirect:/product";
    }
    @GetMapping("/product/search")
    public String searchProductsByName(
            @RequestParam(name = "productName", required = false) String productName,
            Model model) {

        List<Product> products = productService.findByName(productName);

        model.addAttribute("listproduct", products);

        return "redirect:/product";
    }
}
