package bg.softuni.mobilele.model.entiti;

import bg.softuni.mobilele.model.enums.CategoryEnums;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {





    @Enumerated(EnumType.STRING)
    private CategoryEnums category;

    @Column(nullable = false)
    private String name;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;


    private int startYear;


    private Long endYear;

    @ManyToOne
    private BrandEntity brand;


    public CategoryEnums getCategory() {
        return category;
    }

    public void setCategory(CategoryEnums category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }





    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }


    public Long getEndYear() {
        return endYear;
    }

    public void setEndYear(Long endYear) {
        this.endYear = endYear;
    }
}
