package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtoS.model.BrandViewDTO;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    @Autowired
    private ModelRepository modelRepository;


    @GetMapping("/all")
    private String getAllBrands(Model model) {

        List<BrandViewDTO> models = this.modelRepository.findAll().stream().map(this::mapToBrandView).collect(Collectors.toList());

        model.addAttribute("models", models);

        return "brands";
    }

    private BrandViewDTO mapToBrandView(com.softuni.mobilele.domain.entities.Model model) {
        BrandViewDTO brandViewDTO = new BrandViewDTO();
        brandViewDTO.setBrand(model.getBrand().getName());
        brandViewDTO.setCategory(model.getCategory());
        brandViewDTO.setImageUrl(model.getImageUrl());
        brandViewDTO.setStartYear(model.getStartYear());
        brandViewDTO.setEndYear(model.getEndYear());
        brandViewDTO.setId(model.getId());
        return brandViewDTO;

    }


}
