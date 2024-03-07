package com.softuni.mobilele;

import com.softuni.mobilele.domain.constants.ImageUrls;
import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.entities.Model;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.domain.enums.ModelCategory;
import com.softuni.mobilele.repositories.BrandRepository;
import com.softuni.mobilele.repositories.ModelRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class seedOffers implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
   private ModelRepository modelRepository;


    @Override
    public void run(String... args) throws Exception {


        if (this.brandRepository.count() == 0) {
            seedBrands();
        }

        if (this.modelRepository.count() == 0) {
            seedModels();
        }
    }

    private void seedBrands() {
        Arrays.stream(Brands.values()).map(a -> new Brand().setName(a)).forEach(this.brandRepository::save);
    }

    private void seedModels() {
        List<Model> allModels = new ArrayList<>();

        // Mercedes Models
        allModels.add(createModel(CarModels.A_CLASS, Brands.Mercedes, 1997, ImageUrls.MERCEDES_A_CLASS_IMG_URL, null));
        allModels.add(createModel(CarModels.C_CLASS, Brands.Mercedes, 1993, ImageUrls.MERCEDES_C_CLASS_IMG_URL,2000));
        allModels.add(createModel(CarModels.E_CLASS, Brands.Mercedes, 1993,ImageUrls.MERCEDES_E_CLASS_IMG_URL, 2022));

        // BMW Models
        allModels.add(createModel(CarModels.SERIES_3, Brands.Bmw, 1975, ImageUrls.BWM_SERIES_3_IMG_URL,null));
        allModels.add(createModel(CarModels.SERIES_5, Brands.Bmw, 1972,ImageUrls.BWM_SERIES_5_IMG_URL, 2020));
        allModels.add(createModel(CarModels.X5, Brands.Bmw, 1999, ImageUrls.BWM_X5_IMG_URL, null));

        // Ford Models
        allModels.add(createModel(CarModels.FIESTA, Brands.Ford, 1976,ImageUrls.FORD_FIESTA_IMG_URL, null));
        allModels.add(createModel(CarModels.FOCUS, Brands.Ford, 1998, ImageUrls.FORD_FOCUS_IMG_URL,null));
        allModels.add(createModel(CarModels.MUSTANG, Brands.Ford, 1964,ImageUrls.FORD_MUSTANG_IMG_URL, null));
        allModels.add(createModel(CarModels.RANGER, Brands.Ford, 1983, ImageUrls.FORD_RANGER_IMG_URL,null));

       // Opel Models
        allModels.add(createModel(CarModels.CORSA, Brands.Opel, 1982, ImageUrls.OPEL_CORSA_IMG_URL, null));
        allModels.add(createModel(CarModels.ASTRA, Brands.Opel, 1991, ImageUrls.OPEL_ASTRA_IMG_URL, null));
        allModels.add(createModel(CarModels.INSIGNIA, Brands.Opel, 2008,ImageUrls.OPEL_INSIGNIA_IMG_URL, null));
        allModels.add(createModel(CarModels.ZAFIRA, Brands.Opel, 1999, ImageUrls.OPEL_ZAFIRA_IMG_URL,2019));

// Tesla Models
        allModels.add(createModel(CarModels.MODEL_S, Brands.Tesla, 2012,ImageUrls.TESLA_MODEL_S_IMG_URL, null));
        allModels.add(createModel(CarModels.MODEL_3, Brands.Tesla, 2017,ImageUrls.TESLA_MODEL_3_IMG_URL, null));
        allModels.add(createModel(CarModels.MODEL_X, Brands.Tesla, 2015, ImageUrls.TESLA_MODEL_X_IMG_URL,null));
        allModels.add(createModel(CarModels.MODEL_Y, Brands.Tesla, 2020,ImageUrls.TESLA_MODEL_Y_IMG_URL, null));

// Porsche Models
        allModels.add(createModel(CarModels.BOXSTER, Brands.Porsche, 1996,ImageUrls.PORSCHE_BOXSTER_IMG_URL, null));
        allModels.add(createModel(CarModels.CAYENNE, Brands.Porsche, 2002,ImageUrls.PORSCHE_CAYENNE_IMG_URL, null));
        allModels.add(createModel(CarModels.MACAN, Brands.Porsche, 2014, ImageUrls.PORSCHE_MACAN_IMG_URL,null));
        allModels.add(createModel(CarModels.TAYCAN, Brands.Porsche, 2019,ImageUrls.PORSCHE_TAYCAN_IMG_URL, null));

// Toyota Models
        allModels.add(createModel(CarModels.COROLLA, Brands.Toyota, 1966, ImageUrls.TOYOTA_COROLLA_IMG_URL,null));
        allModels.add(createModel(CarModels.CAMRY, Brands.Toyota, 1982,ImageUrls.TOYOTA_CAMRY_IMG_URL, null));
        allModels.add(createModel(CarModels.RAV4, Brands.Toyota, 1994, ImageUrls.TOYOTA_RAV4_IMG_URL,null));
        allModels.add(createModel(CarModels.PRIUS, Brands.Toyota, 1997, ImageUrls.TOYOTA_PRIUS_IMG_URL,null));

// Honda Models
        allModels.add(createModel(CarModels.CIVIC, Brands.Honda, 1972,ImageUrls.HONDA_CIVIC_IMG_URL, null));
        allModels.add(createModel(CarModels.ACCORD, Brands.Honda, 1976,ImageUrls.HONDA_ACCORD_IMG_URL, null));
        allModels.add(createModel(CarModels.CRV, Brands.Honda, 1995, ImageUrls.HONDA_CRV_IMG_URL,null));
        allModels.add(createModel(CarModels.FIT, Brands.Honda, 2001, ImageUrls.HONDA_FIT_IMG_URL, null));

// Volkswagen Models
        allModels.add(createModel(CarModels.GOLF, Brands.Volkswagen, 1974, ImageUrls.VOLKSWAGEN_GOLF_IMG_URL,null));
        allModels.add(createModel(CarModels.PASSAT, Brands.Volkswagen, 1973, ImageUrls.VOLKSWAGEN_PASSAT_IMG_URL,null));
        allModels.add(createModel(CarModels.TIGUAN, Brands.Volkswagen, 2007,ImageUrls.VOLKSWAGEN_TIGUAN_IMG_URL, null));
        allModels.add(createModel(CarModels.POLO, Brands.Volkswagen, 1975, ImageUrls.VOLKSWAGEN_POLO_IMG_URL,null));

// Audi Models
        allModels.add(createModel(CarModels.A3, Brands.Audi, 1996, ImageUrls.AUDI_A3_IMG_URL,null ));
        allModels.add(createModel(CarModels.A4, Brands.Audi, 1994,ImageUrls.AUDI_A4_IMG_URL, null));
        allModels.add(createModel(CarModels.Q5, Brands.Audi, 2008, ImageUrls.AUDI_Q5_IMG_URL,null));
        allModels.add(createModel(CarModels.TT, Brands.Audi, 1998,ImageUrls.AUDI_TT_IMG_URL, null));

        modelRepository.saveAll(allModels);
    }



    private Model createModel(CarModels carModel, Brands brand, Integer startYear,  String imgUrl, Integer endYear) {
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
    }}
