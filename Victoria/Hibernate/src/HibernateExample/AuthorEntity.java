package HibernateExample;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Victoria on 22.10.2016.
 */

@Entity
@Table(name = "author", schema = "hibernatevicky", catalog = "")
public class AuthorEntity {

    private String AuthorFirstName;
    private String AuthorLastName;

    @Id
    @Column(name = "AuthorKey")
    private int AuthorKey;
    public int getAuthorKey() {
        return AuthorKey;
    }

    public void setAuthorKey(int authorKey) {
        this.AuthorKey = authorKey;
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
        return AuthorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.AuthorFirstName = authorFirstName;
    }

    @Basic
    @Column(name = "authorLastName")
    public String getAuthorLastName() {
        return AuthorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.AuthorLastName = authorLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorEntity that = (AuthorEntity) o;

        if (AuthorKey != that.AuthorKey) return false;
        if (AuthorFirstName != null ? !AuthorFirstName.equals(that.AuthorFirstName) : that.AuthorFirstName != null)
            return false;
        if (AuthorLastName != null ? !AuthorLastName.equals(that.AuthorLastName) : that.AuthorLastName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = AuthorKey;
        result = 31 * result + (AuthorFirstName != null ? AuthorFirstName.hashCode() : 0);
        result = 31 * result + (AuthorLastName != null ? AuthorLastName.hashCode() : 0);
        return result;
    }
}