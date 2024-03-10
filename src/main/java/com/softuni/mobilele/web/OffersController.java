package com.softuni.mobilele.web;


import com.softuni.mobilele.domain.dtoS.model.AddOfferDTO;
import com.softuni.mobilele.domain.dtoS.model.AllOffersDTO;
import com.softuni.mobilele.domain.dtoS.model.OfferDetailsDTO;
import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.entities.Offer;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;
import com.softuni.mobilele.services.BrandService;
import com.softuni.mobilele.services.ModelService;
import com.softuni.mobilele.services.OfferService;
import com.softuni.mobilele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private final OfferService offerService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private UserService userService;

    @Autowired
    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    @ModelAttribute(name = "addOfferDto")
    public AddOfferDTO initAddOfferDto() {
        return new AddOfferDTO();
    }


    @GetMapping("/all")
    public String getAllOffers(Model model, @PageableDefault(
            sort = "offerId",
            size = 4
    ) Pageable pageable, @AuthenticationPrincipal UserDetails user ) {

        Page<AllOffersDTO> allOffersDTOS = this.offerService.getAllOffersDTOS(pageable , user);
        model.addAttribute("dtos", allOffersDTOS);
        return "offers";
    }

    @GetMapping("/add")
    public String getAddOffer(Model model) {
        prepareOfferModel(model, new AddOfferDTO());
        return "offer-add";
    }

    @PostMapping("/add")
    public String postAddOffer(@Valid @ModelAttribute(name = "addOfferDto") AddOfferDTO addOfferDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               @AuthenticationPrincipal UserDetails principal) {
        UserEntity user = this.userService.findUserEntityByUsername(principal.getUsername());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDTO)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addOfferDto", bindingResult);
            return "redirect:/offers/add";
        }
      this.offerService.saveOffer(addOfferDTO, user);
        return "redirect:/offers/all";
    }

    @GetMapping("/{id}")
    public String offerId(Model model, @PathVariable String id) {
        OfferDetailsDTO offerDetailsDTO = this.mapOfferToOfferDetailsDTO(this.offerService.findById(id));
        model.addAttribute("offerDetails", offerDetailsDTO);
        return "details";
    }


    @GetMapping("/update/{id}")
    public String getUpdateOffer(Model model, @PathVariable String id) {
        AddOfferDTO addOfferDTO = this.mapOfferToAddOfferDTO(this.offerService.findById(id));
        prepareOfferModel(model, addOfferDTO);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String postUpdateOffer(@PathVariable String id,
                                  @Valid @ModelAttribute("addOfferDto") AddOfferDTO addOfferDTO,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDTO);
            redirectAttributes.addFlashAttribute(BINDING_RESULT_PATH + "addOfferDto", bindingResult);
            return "redirect:/offers/update/" + id;
        }
        this.offerService.updateOffer(addOfferDTO);
        return "redirect:/offers/" + id;
    }

    @GetMapping("/my")
    public String getMyOffers(Model model, @PageableDefault(
            sort = "offerId",
            size = 4
    ) Pageable pageable, @AuthenticationPrincipal UserDetails principal) {

        Page<AllOffersDTO> allOffersDTOS = this.offerService.findAllBySeller(pageable, principal.getUsername());
        model.addAttribute("dtos", allOffersDTOS);
        model.addAttribute("myOffers", "My offers");
        return "offers";
    }


    @GetMapping("/delete/{id}")
    public String postDeleteOffer(@PathVariable String id) {
        this.offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }

    @GetMapping("/brands/{brand}/models")
    public ResponseEntity<List<CarModels>> getModelsForBrand(@PathVariable String brand) {

        List<CarModels> models = this.modelService.findModelsByBrandName(brand);
        return ResponseEntity.ok(models);
    }


    private void prepareOfferModel(Model model, AddOfferDTO addOfferDTO) {
        addCommonAttributes(model);
        model.addAttribute("offerDetails", addOfferDTO);
    }

    private void addCommonAttributes(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("brand", new Brand());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("engine", Engine.class);
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("transmission", Transmission.class);
    }


    private AddOfferDTO mapOfferToAddOfferDTO(Offer offer) {
        AddOfferDTO addOfferDTO = new AddOfferDTO();
        addOfferDTO.setBrand(offer.getModel().getBrand().getName());
        addOfferDTO.setPrice(offer.getPrice());
        addOfferDTO.setEngine(offer.getEngine());
        addOfferDTO.setMileage(offer.getMileage());
        addOfferDTO.setTransmission(offer.getTransmission());
        addOfferDTO.setYear(offer.getYear());
        addOfferDTO.setDescription(offer.getDescription());

        addOfferDTO.setId(offer.getId());
        addOfferDTO.setCarModels(offer.getModel().getName());
        return addOfferDTO;
    }


    private OfferDetailsDTO mapOfferToOfferDetailsDTO(Offer offer) {
       return new OfferDetailsDTO(offer.getSeller().getEmail(), offer.getId(), offer.getImageUrl(), offer.getModel().getBrand().getName(), offer.getModel().getName(), offer.getEngine(), offer.getPrice(), offer.getTransmission(), offer.getCreated(), offer.getModified(),
                offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName(), offer.getDescription());

    }
}
