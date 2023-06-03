package com.example.demo.service;


import com.example.demo.model.Dto.BrandDTO;
import com.example.demo.model.Dto.ModelDTO;
import com.example.demo.model.entiti.BrandEntity;
import com.example.demo.model.entiti.ModelEntity;
import com.example.demo.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
    return     this.brandRepository.
                findAll().
                stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDTO mapBrand(BrandEntity brandEntity) {
        List<ModelDTO> models = brandEntity.getModels().stream()
                .map(this::mapModel).toList();
        BrandDTO result = new BrandDTO();
        result.setModels(models);
        result.setName(brandEntity.getName());
    return result;
    }

    private ModelDTO mapModel(ModelEntity modelEntity) {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setId(modelEntity.getId());
        modelDTO.setName(modelEntity.getName());
        return modelDTO;
    }
}
