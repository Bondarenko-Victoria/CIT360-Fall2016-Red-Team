package test;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gvh57 on 10/24/2016.
 */
@Entity
@Table(name = "car", schema = "hibernate", catalog = "")
public class CarEntity {

    private String make;
    private String model;
    private int year;
    private String color;
    private String vin;

    @Id
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "carEntity")
    private List<CarOwnerEntity> carOwnerEntity;

    public List<CarOwnerEntity> getCarOwnerEntity() {
        return carOwnerEntity;
    }

    public void setCarOwnerEntity(List<CarOwnerEntity> carOwnerEntity) {
        this.carOwnerEntity = carOwnerEntity;
    }

    @Basic
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "vin")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEntity carEntity = (CarEntity) o;

        if (id != carEntity.id) return false;
        if (year != carEntity.year) return false;
        if (make != null ? !make.equals(carEntity.make) : carEntity.make != null) return false;
        if (model != null ? !model.equals(carEntity.model) : carEntity.model != null) return false;
        if (color != null ? !color.equals(carEntity.color) : carEntity.color != null) return false;
        if (vin != null ? !vin.equals(carEntity.vin) : carEntity.vin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (vin != null ? vin.hashCode() : 0);
        return result;
    }
}
