package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

    @Autowired
    BrandService brandService;

    @GetMapping
    public ModelAndView getHome(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("brand", new Brand());
        return super.view("index");
    }


}
