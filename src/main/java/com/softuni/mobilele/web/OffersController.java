package com.softuni.mobilele.web;


import com.softuni.mobilele.domain.dtoS.model.AddOfferDTO;
import com.softuni.mobilele.domain.dtoS.model.AllOffersDTO;
import com.softuni.mobilele.domain.dtoS.model.OfferDetailsDTO;
import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.entities.Offer;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;
import com.softuni.mobilele.services.ApplicationUserDetailsService;
import com.softuni.mobilele.services.BrandService;
import com.softuni.mobilele.services.OfferService;
import com.softuni.mobilele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OffersController {

    @Autowired
    private BrandService brandService;

    private final OfferService offerService;


    @Autowired
private UserService userService;
    @Autowired
    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    @ModelAttribute(name = "addOfferDto")
    public AddOfferDTO initAddOfferDto(){
        return new AddOfferDTO();
    }


    @GetMapping("/all")
    public String getAllOffers(Model model, @PageableDefault(
            sort = "offerId",
            size = 4
    ) Pageable pageable) {
        Page<AllOffersDTO> allOffersDTOS = this.offerService.getAllOffersDTOS(pageable);

        model.addAttribute("dtos", allOffersDTOS);

        return "offers";
    }

    @GetMapping("/add")
    public String getAddOffer(Model model) {
        List<Brand> brands = this.brandService.getAllBrands();
        model.addAttribute("brands", brands);
        model.addAttribute("brand", new Brand());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("engine", Engine.class);
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("transmission", Transmission.class);

        return "offer-add";
    }

    @PostMapping("/add")
    public String postAddOffer(@Valid @ModelAttribute(name = "addOfferDto") AddOfferDTO addOfferDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               @AuthenticationPrincipal UserDetails prncipal){

        UserEntity user = this.userService.findUserEntityByUsername(prncipal.getUsername());

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDTO)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addOfferDto", bindingResult);

            return "redirect:/offers/add";
        }

        this.offerService.saveOffer(addOfferDTO, user);
        return "redirect:/offers/all";
    }

    @GetMapping("/{id}")
    public String offerId(Model model, @PathVariable String id){
        OfferDetailsDTO offerDetailsDTO = this.map(this.offerService.findById(id));



        model.addAttribute("offerDetails", offerDetailsDTO );

        return "details";
    }

    private OfferDetailsDTO map(Offer offer){
        return new OfferDetailsDTO(offer.getModel().getBrand().getName(),offer.getModel().getName(), offer.getEngine(), offer.getPrice(), offer.getTransmission(), offer.getCreated(), offer.getModified(),
                offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());
    }

}
