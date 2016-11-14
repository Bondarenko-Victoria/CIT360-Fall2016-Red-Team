package Test;

import javax.persistence.*;

/**
 * Created by Brian on 11/7/16.
 */
@Entity
@Table(name = "record", schema = "StudentRecords", catalog = "")
public class RecordEntity {
    private int studentId;
    private int phoneId;

    @Id
    @GeneratedValue
    @Column(name = "recordId")
    private int recordId;
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "phoneId", insertable = false, updatable = false)
    private PhoneEntity phoneEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    public PhoneEntity getPhoneEntity() {
        return phoneEntity;
    }

    public void setPhoneEntity(PhoneEntity phoneEntity) {
        this.phoneEntity = phoneEntity;
        /* Without this line, it will insert 0 because it won't get the
        * values from the phone entity.
        * It will throw errors:
        * MySQLIntegrityConstraintViolationException:
        *    Cannot add or update a child row: a foreign key constraint fails
        *    (`studentrecords`.`record`, CONSTRAINT `fk_studentid` FOREIGN KEY (`studentId`)
        *    REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE)
        */
        this.phoneId = phoneEntity.getPhone_id();
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
        /* Without this line, it will insert 0 because it won't get the
        * values from the student entity.
        * It will throw errors:
        * MySQLIntegrityConstraintViolationException:
        *    Cannot add or update a child row: a foreign key constraint fails
        *    (`studentrecords`.`record`, CONSTRAINT `fk_studentid` FOREIGN KEY (`studentId`)
        *    REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE)
        */

        this.studentId = studentEntity.getStudent_id();
    }

    @Basic
    @Column(name = "phoneId")
    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    @Basic
    @Column(name = "studentId")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordEntity that = (RecordEntity) o;

        if (studentId != that.studentId) return false;
        if (phoneId != that.phoneId) return false;
        if (recordId != that.recordId) return false;
        if (phoneEntity != null ? !phoneEntity.equals(that.phoneEntity) : that.phoneEntity != null) return false;
        return studentEntity != null ? studentEntity.equals(that.studentEntity) : that.studentEntity == null;

    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + phoneId;
        result = 31 * result + recordId;
        result = 31 * result + (phoneEntity != null ? phoneEntity.hashCode() : 0);
        result = 31 * result + (studentEntity != null ? studentEntity.hashCode() : 0);
        return result;
    }
}
