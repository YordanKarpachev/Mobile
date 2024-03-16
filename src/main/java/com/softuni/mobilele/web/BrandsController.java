package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtoS.model.BrandViewDTO;

import com.softuni.mobilele.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    @Autowired
    private ModelRepository modelRepository;


    @GetMapping("/all")
    public String getAllOffers(org.springframework.ui.Model model, @PageableDefault(
            size = 4
    ) Pageable pageable) {
        Page<BrandViewDTO> allModels = this.modelRepository.findAll(pageable).map(this::mapToBrandView);
        model.addAttribute("dtos", allModels);
        return "brands";
    }

    private BrandViewDTO mapToBrandView(com.softuni.mobilele.domain.entities.Model model) {
        BrandViewDTO brandViewDTO = new BrandViewDTO();
        brandViewDTO.setBrandName(model.getBrand().getName());
        brandViewDTO.setCategory(model.getCategory());
        brandViewDTO.setImageUrl(model.getImageUrl());
        brandViewDTO.setStartYear(model.getStartYear());
        brandViewDTO.setEndYear(model.getEndYear() == null ? "present" : model.getEndYear().toString());
        brandViewDTO.setId(model.getId());
        brandViewDTO.setModelName(model.getName());
        return brandViewDTO;
    }
}
