package com.softuni.mobilele;

import com.softuni.mobilele.domain.entities.*;
import com.softuni.mobilele.domain.enums.*;
import com.softuni.mobilele.repositories.BrandRepository;
import com.softuni.mobilele.repositories.ModelRepository;
import com.softuni.mobilele.repositories.OfferRepository;
import com.softuni.mobilele.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static com.softuni.mobilele.domain.constants.OffersConstants.*;

@Component
public class seedOffers implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OfferRepository offerRepository;


    @Override
    public void run(String... args) throws Exception {

        if(this.userRepository.count() == 0){
            seedUsers();
        }

        if (this.brandRepository.count() == 0) {
            seedBrands();
        }

        if (this.modelRepository.count() == 0) {
            seedModels();
        }

        if(this.offerRepository.count() == 0){
            seedOffers();
        }

    }

    private void seedBrands() {
        Arrays.stream(Brands.values()).map(a -> new Brand().setName(a)).forEach(this.brandRepository::save);
    }

    private void seedModels() {
        List<Model> allModels = new ArrayList<>();

        // Mercedes Models
        allModels.add(createModel(CarModels.A_CLASS, Brands.Mercedes, 1997, MERCEDES_A_CLASS_IMG_URL, null));
        allModels.add(createModel(CarModels.C_CLASS, Brands.Mercedes, 1993, MERCEDES_C_CLASS_IMG_URL, 2000));
        allModels.add(createModel(CarModels.E_CLASS, Brands.Mercedes, 1993, MERCEDES_E_CLASS_IMG_URL, 2022));

        // BMW Models
        allModels.add(createModel(CarModels.SERIES_3, Brands.Bmw, 1975, BWM_SERIES_3_IMG_URL, null));
        allModels.add(createModel(CarModels.SERIES_5, Brands.Bmw, 1972, BWM_SERIES_5_IMG_URL, 2020));
        allModels.add(createModel(CarModels.X5, Brands.Bmw, 1999, BWM_X5_IMG_URL, null));

        // Ford Models
        allModels.add(createModel(CarModels.FIESTA, Brands.Ford, 1976, FORD_FIESTA_IMG_URL, null));
        allModels.add(createModel(CarModels.FOCUS, Brands.Ford, 1998, FORD_FOCUS_IMG_URL, null));
        allModels.add(createModel(CarModels.MUSTANG, Brands.Ford, 1964, FORD_MUSTANG_IMG_URL, null));
        allModels.add(createModel(CarModels.RANGER, Brands.Ford, 1983, FORD_RANGER_IMG_URL, null));

        // Opel Models
        allModels.add(createModel(CarModels.CORSA, Brands.Opel, 1982, OPEL_CORSA_IMG_URL, null));
        allModels.add(createModel(CarModels.ASTRA, Brands.Opel, 1991, OPEL_ASTRA_IMG_URL, null));
        allModels.add(createModel(CarModels.INSIGNIA, Brands.Opel, 2008, OPEL_INSIGNIA_IMG_URL, null));
        allModels.add(createModel(CarModels.ZAFIRA, Brands.Opel, 1999, OPEL_ZAFIRA_IMG_URL, 2019));

// Tesla Models
        allModels.add(createModel(CarModels.MODEL_S, Brands.Tesla, 2012, TESLA_MODEL_S_IMG_URL, null));
        allModels.add(createModel(CarModels.MODEL_3, Brands.Tesla, 2017, TESLA_MODEL_3_IMG_URL, null));
        allModels.add(createModel(CarModels.MODEL_X, Brands.Tesla, 2015, TESLA_MODEL_X_IMG_URL, null));
        allModels.add(createModel(CarModels.MODEL_Y, Brands.Tesla, 2020, TESLA_MODEL_Y_IMG_URL, null));

// Porsche Models
        allModels.add(createModel(CarModels.BOXSTER, Brands.Porsche, 1996, PORSCHE_BOXSTER_IMG_URL, null));
        allModels.add(createModel(CarModels.CAYENNE, Brands.Porsche, 2002, PORSCHE_CAYENNE_IMG_URL, null));
        allModels.add(createModel(CarModels.MACAN, Brands.Porsche, 2014, PORSCHE_MACAN_IMG_URL, null));
        allModels.add(createModel(CarModels.TAYCAN, Brands.Porsche, 2019, PORSCHE_TAYCAN_IMG_URL, null));

// Toyota Models
        allModels.add(createModel(CarModels.COROLLA, Brands.Toyota, 1966, TOYOTA_COROLLA_IMG_URL, null));
        allModels.add(createModel(CarModels.CAMRY, Brands.Toyota, 1982, TOYOTA_CAMRY_IMG_URL, null));
        allModels.add(createModel(CarModels.RAV4, Brands.Toyota, 1994, TOYOTA_RAV4_IMG_URL, null));
        allModels.add(createModel(CarModels.PRIUS, Brands.Toyota, 1997, TOYOTA_PRIUS_IMG_URL, null));

// Honda Models
        allModels.add(createModel(CarModels.CIVIC, Brands.Honda, 1972, HONDA_CIVIC_IMG_URL, null));
        allModels.add(createModel(CarModels.ACCORD, Brands.Honda, 1976, HONDA_ACCORD_IMG_URL, null));
        allModels.add(createModel(CarModels.CRV, Brands.Honda, 1995, HONDA_CRV_IMG_URL, null));
        allModels.add(createModel(CarModels.FIT, Brands.Honda, 2001,HONDA_FIT_IMG_URL, null));

// Volkswagen Models
        allModels.add(createModel(CarModels.GOLF, Brands.Volkswagen, 1974,VOLKSWAGEN_GOLF_IMG_URL, null));
        allModels.add(createModel(CarModels.PASSAT, Brands.Volkswagen, 1973, VOLKSWAGEN_PASSAT_IMG_URL, null));
        allModels.add(createModel(CarModels.TIGUAN, Brands.Volkswagen, 2007, VOLKSWAGEN_TIGUAN_IMG_URL, null));
        allModels.add(createModel(CarModels.POLO, Brands.Volkswagen, 1975, VOLKSWAGEN_POLO_IMG_URL, null));

// Audi Models
        allModels.add(createModel(CarModels.A3, Brands.Audi, 1996, AUDI_A3_IMG_URL, null));
        allModels.add(createModel(CarModels.A4, Brands.Audi, 1994, AUDI_A4_IMG_URL, null));
        allModels.add(createModel(CarModels.Q5, Brands.Audi, 2008, AUDI_Q5_IMG_URL, null));
        allModels.add(createModel(CarModels.TT, Brands.Audi, 1998, AUDI_TT_IMG_URL, null));


        modelRepository.saveAll(allModels);
    }

    private void seedUsers() {
        UserEntity user = new UserEntity();
        user.setFirstName("Max");
        user.setLastName("Mustermann");
        user.setEmail("max@example.com");
        user.setPassword("$10$hwNreaOFTfyz1pbeuUcba.N05Cb5t4.wCbsXknL10Rm6sj6cZQM4W");
        userRepository.save(user);

    }

    private void seedOffers() {
        List<Offer> offers = new ArrayList<>();
        UserEntity seller = userRepository.findByEmail("max@example.com").get();

        Model bmwSerie3Model = modelRepository.findByName(CarModels.SERIES_3);
        offers.add(createOffer(bmwSerie3Model, BigDecimal.valueOf(1000), 2018, 50000, seller, Engine.DIESEL, BWM_SERIES_3_OFFER_DESCRIPTION_IMG_URL, BWM_SERIES_3_OFFER_IMG_URL, Transmission.MANUAL));

        Model bmwSerie5Model = modelRepository.findByName(CarModels.SERIES_5);
        offers.add(createOffer(bmwSerie5Model, BigDecimal.valueOf(10025), 2023, 12000, seller, Engine.GASOLINE, BWM_SERIES_5_OFFER_DESCRIPTION_IMG_URL, BWM_SERIES_5_OFFER_IMG_URL, Transmission.MANUAL));

        Model mercedesCClassModel = modelRepository.findByName(CarModels.C_CLASS);
        offers.add(createOffer(mercedesCClassModel, BigDecimal.valueOf(15000), 2020, 800, seller, Engine.HYBRID, MERCEDES_C_CLASS_OFFER_DESCRIPTION_IMG_URL, MERCEDES_C_CLASS_OFFER_IMG_URL, Transmission.MANUAL));

        Model mercedesEClassModel = modelRepository.findByName(CarModels.E_CLASS);
        offers.add(createOffer(mercedesEClassModel, BigDecimal.valueOf(15000), 2022, 22000, seller, Engine.ELECTRIC, MERCEDES_R_CLASS_OFFER_DESCRIPTION_IMG_URL, MERCEDES_E_CLASS_OFFER_IMG_URL, Transmission.AUTOMATIC));

        Model auduTTModel = modelRepository.findByName(CarModels.TT);
        offers.add(createOffer(auduTTModel, BigDecimal.valueOf(15000), 2024, 2400, seller, Engine.DIESEL, AUDI_TT_OFFER_DESCRIPTION_IMG_URL, AUDI_TT_OFFER_IMG_URL, Transmission.AUTOMATIC));


        offerRepository.saveAll(offers);

    }

    private Offer createOffer(Model model, BigDecimal price, int year, int mileage, UserEntity seller, Engine engine, String description, String imageUrl, Transmission transmission) {



        Offer offer = new Offer();
        offer.setModel(model);
        offer.setPrice(price);
        offer.setYear(year);
        offer.setMileage(mileage);
        offer.setSeller(seller);
        offer.setEngine(engine);
        offer.setDescription(description);
        offer.setTransmission(transmission);
        offer.setCreated(LocalDateTime.now());

        Picture picture = new Picture();
        picture.setUrl(imageUrl);
        picture.setOffer(offer);
        picture.setAuthor(seller);
        offer.setPictures(Collections.singleton(picture));

        return offer;
    }

    private Model createModel(CarModels carModel, Brands brand, Integer startYear, String imgUrl, Integer endYear) {
        Model model = new Model();
        model.setName(carModel);
        model.setCreated(LocalDateTime.now());
        model.setCategory(ModelCategory.CAR);

        Brand modelBrand = brandRepository.findByName(brand).get();
        model.setBrand(modelBrand);

        model.setImageUrl(imgUrl);
        model.setStartYear(startYear);
        model.setEndYear(endYear);
        return model;
    }
}
