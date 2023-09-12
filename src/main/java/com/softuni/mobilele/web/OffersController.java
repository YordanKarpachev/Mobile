package com.softuni.mobilele.web;


import com.softuni.mobilele.domain.dtoS.model.AllOffersDTO;
import com.softuni.mobilele.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;

    @Autowired
    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    String getAllOffers(Model model) {
        List<AllOffersDTO> allOffersDTOS = this.offerService.getAllOffersDTOS();

        model.addAttribute("dtos", allOffersDTOS);

        return "offers";
    }
}
