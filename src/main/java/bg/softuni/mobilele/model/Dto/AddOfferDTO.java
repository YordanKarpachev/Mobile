package bg.softuni.mobilele.model.Dto;

import bg.softuni.mobilele.model.enums.EngineEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddOfferDTO {

    @NotNull
    private EngineEnum engine;


    @NotEmpty
    private String imageUrl;


    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
