package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtoS.SearchDTO;
import com.softuni.mobilele.domain.dtoS.model.AllOffersDTO;
import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.services.BrandService;
import com.softuni.mobilele.services.ModelService;
import com.softuni.mobilele.services.OfferService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {


    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;

    @Autowired
    private OfferService offerService;

    @GetMapping
    public ModelAndView getHome(Model model, HttpServletRequest request) {



        model.addAttribute("searchDto", new SearchDTO());
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("brand", new Brand());


        return super.view("index");
    }

    @GetMapping("/welcome")
    public String welcome(@AuthenticationPrincipal UserDetails user, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("welcomeMessage", "Welcome to MobiLe Yordan Project " + user.getUsername() + "!");
        return "redirect:/";
    }

    @PostMapping
    public String searchHome(Model model, @ModelAttribute(name = "searchDto") SearchDTO searchDTO,
                             @PageableDefault(sort = "offerId",
                                     size = 4)
                             Pageable pageable) {

        Page<AllOffersDTO> allOffersDTOS = this.offerService.getOffers(pageable, searchDTO);
        model.addAttribute("dtos", allOffersDTOS);


        return "offers";

    }

    @GetMapping("api/getModelStartYear/{carModel}")
    public ResponseEntity<Integer> getModelStartYear(@PathVariable CarModels carModel) {
        com.softuni.mobilele.domain.entities.Model modelByName = this.modelService.findModelByName(carModel);

        return ResponseEntity.ok(modelByName.getStartYear());

    }

    @GetMapping("api/getOffersCount")
    public ResponseEntity<Long> getOffersCount(
            @RequestParam(required = false) Brands brand,
            @RequestParam(required = false) CarModels model,
            @RequestParam(required = false) Integer year
    ) {

        long countOffers = this.offerService.calculateTotalOffers(brand, model, year);
        return ResponseEntity.ok(countOffers);

    }


}
