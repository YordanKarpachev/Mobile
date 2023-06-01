package bg.softuni.mobilele.WEB;

import bg.softuni.mobilele.model.Dto.AddOfferDTO;
import bg.softuni.mobilele.service.BrandService;
import bg.softuni.mobilele.service.OfferService;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OfferController {

    private final OfferService offerService;

    private final BrandService brandService;
    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers(){
        return "offers";
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model){
        if(!model.containsAttribute("addOfferModel")){
            model.addAttribute("addOfferModel", new AddOfferDTO());
        }
        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferDTO addOfferModel, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                            @AuthenticationPrincipal UserDetails userDetails){


        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult );
            return "redirect:/offers/add";
        }
            this.offerService.addOffer(addOfferModel, userDetails);

        return "redirect:/offers/all";
    }

}
