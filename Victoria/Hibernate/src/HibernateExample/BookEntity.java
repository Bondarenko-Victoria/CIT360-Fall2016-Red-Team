package HibernateExample;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Victoria on 22.10.2016.
 */

@Entity
@Table(name = "book", schema = "hibernatevicky", catalog = "")
public class BookEntity {

    private String BookPublisher;
    private String BookTitle;
    private int BookYear;

    @Id
    @Column(name = "BookKeyISBN")
    private int BookKeyISBN;
    public int getBookKeyIsbn() {
        return BookKeyISBN;
    }

    public void setBookKeyIsbn(int bookKeyIsbn) {
        this.BookKeyISBN = bookKeyIsbn;
    }

    @OneToMany(mappedBy = "bookEntity")
    private List<BookAuthorEntity> bookAuthorEntity;

    public List<BookAuthorEntity> getBookAuthorEntity() {
        return bookAuthorEntity;
    }

    public void setBookAuthorEntity(List<BookAuthorEntity> bookAuthorEntity) {
        this.bookAuthorEntity = bookAuthorEntity;
    }

    @Basic
    @Column(name = "BookPublisher")
    public String getBookPublisher() {
        return BookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.BookPublisher = bookPublisher;
    }

    @Basic
    @Column(name = "BookTitle")
    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.BookTitle = bookTitle;
    }

    @Basic
    @Column(name = "BookYear")
    public int getBookYear() {
        return BookYear;
    }

    public void setBookYear(int bookYear) {
        this.BookYear = bookYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (BookKeyISBN != that.BookKeyISBN) return false;
        if (BookYear != that.BookYear) return false;
        if (BookPublisher != null ? !BookPublisher.equals(that.BookPublisher) : that.BookPublisher != null)
            return false;
        if (BookTitle != null ? !BookTitle.equals(that.BookTitle) : that.BookTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = BookKeyISBN;
        result = 31 * result + (BookPublisher != null ? BookPublisher.hashCode() : 0);
        result = 31 * result + (BookTitle != null ? BookTitle.hashCode() : 0);
        result = 31 * result + BookYear;
        return result;
    }
}