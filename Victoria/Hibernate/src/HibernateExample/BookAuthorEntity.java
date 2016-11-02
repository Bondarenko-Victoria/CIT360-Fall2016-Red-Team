package HibernateExample;

import javax.persistence.*;

/**
 * Created by Victoria on 22.10.2016.
 */

@Entity
@Table(name = "book_author", schema = "hibernate", catalog = "")
public class BookAuthorEntity {
    private int authorKey;
    private int bookKeyIsbn;

    @Id
    @Column(name = "authorKey")
    public int getAuthorKey() {
        return authorKey;
    }

    public void setAuthorKey(int authorKey) {
        this.authorKey = authorKey;
    }

    @Id
    @Column(name = "bookKeyISBN")
    public int getBookKeyIsbn() {
        return bookKeyIsbn;
    }

    public void setBookKeyIsbn(int bookKeyIsbn) {
        this.bookKeyIsbn = bookKeyIsbn;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "authorKey")
    private AuthorEntity authorEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bookKeyIsbn")
    private BookEntity bookEntity;

    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookAuthorEntity that = (BookAuthorEntity) o;

        if (authorKey != that.authorKey) return false;
        if (bookKeyIsbn != that.bookKeyIsbn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorKey;
        result = 31 * result + bookKeyIsbn;
        return result;
    }
}