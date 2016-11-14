package Test;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Brian on 11/7/16.
 */
@Entity
@Table(name = "phone", schema = "StudentRecords", catalog = "")
public class PhoneEntity {
    private String phone;

    @Id
    @GeneratedValue
    @Column(name = "phone_id")
    private int phone_id;
    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    @OneToMany(mappedBy = "phoneEntity")
    private List<RecordEntity> recordEntities;

    public List<RecordEntity> getRecordEntities() {
        return recordEntities;
    }

    public void setRecordEntities(List<RecordEntity> recordEntities) {
        this.recordEntities = recordEntities;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneEntity that = (PhoneEntity) o;

        if (phone_id != that.phone_id) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phone_id;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
