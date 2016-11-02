package HibernateExample;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Victoria on 22.10.2016.
 */

@Entity
@Table(name = "author", schema = "hibernate", catalog = "")
public class AuthorEntity {
    private int authorKey;
    private String authorFirstName;
    private String authorLastName;

    @Id
    @Column(name = "authorKey")
    public int getAuthorKey() {
        return authorKey;
    }

    public void setAuthorKey(int authorKey) {
        this.authorKey = authorKey;
    }

    @OneToMany(mappedBy = "authorEntity")
    private List<BookAuthorEntity> bookAuthorEntity;

    /*
    public List<BookAuthorEntity> getBookAuthorEntity() {
        return bookAuthorEntity;
    }

    public void setBookAuthorEntity(List<BookAuthorEntity> bookAuthorEntity) {
        this.bookAuthorEntity = bookAuthorEntity;
    }
    */

    @Basic
    @Column(name = "authorFirstName")
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    @Basic
    @Column(name = "authorLastName")
    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorEntity that = (AuthorEntity) o;

        if (authorKey != that.authorKey) return false;
        if (authorFirstName != null ? !authorFirstName.equals(that.authorFirstName) : that.authorFirstName != null)
            return false;
        if (authorLastName != null ? !authorLastName.equals(that.authorLastName) : that.authorLastName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorKey;
        result = 31 * result + (authorFirstName != null ? authorFirstName.hashCode() : 0);
        result = 31 * result + (authorLastName != null ? authorLastName.hashCode() : 0);
        return result;
    }
}