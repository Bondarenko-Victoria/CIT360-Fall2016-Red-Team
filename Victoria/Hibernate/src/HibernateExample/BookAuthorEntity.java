package HibernateExample;

import javax.persistence.*;

/**
 * Created by Victoria on 22.10.2016.
 */

@Entity
@Table(name = "book_author", schema = "hibernate", catalog = "")
public class BookAuthorEntity {
    private int id;
    private int authorKey;
    private int bookKeyIsbn;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Basic
    @Column(name = "authorKey")
    public int getAuthorKey() {
        return authorKey;
    }

    public void setAuthorKey(int authorKey) {
        this.authorKey = authorKey;
    }

    @Basic
    @Column(name = "bookKeyISBN")
    public int getBookKeyIsbn() {
        return bookKeyIsbn;
    }

    public void setBookKeyIsbn(int bookKeyIsbn) {
        this.bookKeyIsbn = bookKeyIsbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookAuthorEntity that = (BookAuthorEntity) o;

        if (id != that.id) return false;
        if (authorKey != that.authorKey) return false;
        if (bookKeyIsbn != that.bookKeyIsbn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + authorKey;
        result = 31 * result + bookKeyIsbn;
        return result;
    }
}