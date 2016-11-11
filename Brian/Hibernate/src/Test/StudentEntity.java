package Test;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Brian on 11/7/16.
 */
@Entity
@Table(name = "student", schema = "StudentRecords", catalog = "")
public class StudentEntity {
    private String firstName;
    private String lastName;

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private int student_id;
    public int getStudent_id() {return student_id;}
    public void setStudent_id(int student_id) {this.student_id = student_id;}


    @OneToMany(mappedBy = "studentEntity")
    private List<RecordEntity> recordEntities;

    public List<RecordEntity> getRecordEntities() {
        return recordEntities;
    }

    public void setRecordEntities(List<RecordEntity> recordEntities) {
        this.recordEntities = recordEntities;
    }


    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (student_id != that.student_id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = student_id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
