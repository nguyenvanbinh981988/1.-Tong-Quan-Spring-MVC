package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.CrudProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    @Autowired
    CrudProduct crudProduct;

    @GetMapping("/home")
    public String showHome(Model model) {
        model.addAttribute("products", crudProduct.products);
        return "home";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        crudProduct.products.add(product);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        for (Product p : crudProduct.products) {
            if (p.getId() == id) {
                model.addAttribute("product", p);
                break;
            }
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product) {
        for (Product p : crudProduct.products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setImg(product.getImg());
                break;
            }
        }
        return "redirect:/home";
    }

    @GetMapping("/Search")
    public String search(@RequestParam String search,Model model) {
        List<Product> findSearch = new ArrayList<>();
        for (Product p : crudProduct.products) {
            if (p.getName().contains(search)) {
                findSearch.add(p);
            }
        }
        model.addAttribute("products", findSearch);
        return "home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        for (Product p : crudProduct.products) {
            if (p.getId() == id) {
                int index = crudProduct.products.indexOf(p);
                crudProduct.products.remove(index);
                break;
            }
        }
        return "redirect:/home";
    }
}
