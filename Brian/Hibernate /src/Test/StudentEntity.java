package Test;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Brian on 11/7/16.
 */
@Entity
@Table(name = "student", schema = "StudentRecords", catalog = "")
public class StudentEntity {
    private int studentId;
    private String firstName;
    private String lastName;

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @OneToMany(mappedBy = "studentEntity")
    private List<RecordEntity> recordEntities;

//    public List<RecordEntity> getRecordEntities() {
//        return recordEntities;
//    }
//
//    public void setRecordEntities(List<RecordEntity> recordEntities) {
//        this.recordEntities = recordEntities;
//    }


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

        if (studentId != that.studentId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
