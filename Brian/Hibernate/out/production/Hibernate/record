package Test;

import javax.persistence.*;

/**
 * Created by Brian on 11/7/16.
 */
@Entity
@Table(name = "record", schema = "StudentRecords", catalog = "")
public class RecordEntity {
    private int recordId;

    @Id
    @Column(name = "recordId")
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "phoneId")
    private PhoneEntity phoneEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;

    public PhoneEntity getPhoneEntity() {
        return phoneEntity;
    }

    public void setPhoneEntity(PhoneEntity phoneEntity) {
        this.phoneEntity = phoneEntity;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordEntity that = (RecordEntity) o;

        if (recordId != that.recordId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return recordId;
    }
}
