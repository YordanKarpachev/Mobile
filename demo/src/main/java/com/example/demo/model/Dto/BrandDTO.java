package com.example.demo.model.Dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private List<ModelDTO> models;

    private String name;

    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }

    public void addModel(ModelDTO model) {
        if(this.models == null){
            this.models = new ArrayList<>();
        }
        this.addModel(model);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
