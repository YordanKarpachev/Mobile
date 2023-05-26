package bg.softuni.mobilele.model.entiti;

import bg.softuni.mobilele.model.enums.EngineEnum;
import bg.softuni.mobilele.model.enums.TransmissionEnum;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
    strategy = "org.hibernate,id,UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineEnum engineEnum;

    private String imageUrl;

    private int mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransmissionEnum transmissionEnum;

    private int year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngineEnum() {
        return engineEnum;
    }

    public void setEngineEnum(EngineEnum engineEnum) {
        this.engineEnum = engineEnum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionEnum getTransmissionEnum() {
        return transmissionEnum;
    }

    public void setTransmissionEnum(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity user) {
        this.seller = user;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "description='" + description + '\'' +
                ", engineEnum=" + engineEnum +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmissionEnum=" + transmissionEnum +
                ", year=" + year +
                ", model=" + model +
                ", user=" + seller +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
