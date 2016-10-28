package test;

import javax.persistence.*;

/**
 * Created by gvh57 on 10/24/2016.
 */
@Entity
@Table(name = "car_owner", schema = "hibernate", catalog = "")
public class CarOwnerEntity {

    private String vin;
    private String purchaseDate;
    private int is_current_owner;

    @Id
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private CarEntity carEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private OwnerEntity ownerEntity;

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }

    @Basic
    @Column(name = "vin")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Basic
    @Column(name = "purchaseDate")
    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Basic
    @Column(name = "is_current_owner")
    public int getIsCurrentOwner() {
        return is_current_owner;
    }

    public void setIsCurrentOwner(int isCurrentOwner) {
        this.is_current_owner = isCurrentOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarOwnerEntity that = (CarOwnerEntity) o;

        if (id != that.id) return false;
        if (is_current_owner != that.is_current_owner) return false;
        if (vin != null ? !vin.equals(that.vin) : that.vin != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (vin != null ? vin.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + is_current_owner;
        return result;
    }
}
