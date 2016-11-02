package HibernateExample;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Victoria on 22.10.2016.
 */

@Entity
@Table(name = "book", schema = "hibernate", catalog = "")
public class BookEntity {
    private int bookKeyIsbn;
    private String bookPublisher;
    private String bookTitle;
    private int bookYear;

    @Id
    @Column(name = "bookKeyISBN")
    public int getBookKeyIsbn() {
        return bookKeyIsbn;
    }

    public void setBookKeyIsbn(int bookKeyIsbn) {
        this.bookKeyIsbn = bookKeyIsbn;
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
    @Column(name = "bookPublisher")
    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    @Basic
    @Column(name = "bookTitle")
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Basic
    @Column(name = "bookYear")
    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (bookKeyIsbn != that.bookKeyIsbn) return false;
        if (bookYear != that.bookYear) return false;
        if (bookPublisher != null ? !bookPublisher.equals(that.bookPublisher) : that.bookPublisher != null)
            return false;
        if (bookTitle != null ? !bookTitle.equals(that.bookTitle) : that.bookTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookKeyIsbn;
        result = 31 * result + (bookPublisher != null ? bookPublisher.hashCode() : 0);
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + bookYear;
        return result;
    }
}