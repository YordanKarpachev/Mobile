package com.softuni.mobilele;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.entities.Model;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.ModelCategory;
import com.softuni.mobilele.repositories.BrandRepository;
import com.softuni.mobilele.repositories.ModelRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class seedOffers implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired ModelRepository modelRepository;


    @Override
    public void run(String... args) throws Exception {

        if(brandRepository.count() == 0){
            Arrays.stream(Brands.values()).map(a -> new Brand().setName(a)).forEach(this.brandRepository::save);
        }

        if(modelRepository.count() == 0){

            List<Brand> all = this.brandRepository.findAll();

            for (Brand brand : all) {
                Model model = new Model();
                model.setBrand(brand);
                model.setCategory(ModelCategory.CAR);

                model.setName(brand.getName().toString());

                this.modelRepository.save(model);

            }


        }

    }
}
