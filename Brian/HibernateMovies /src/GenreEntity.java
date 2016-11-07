package Test;

import javax.persistence.*;

/**
 * Created by Brian on 11/5/16.
 */
@Entity
@Table(name = "Genre", schema = "Movies", catalog = "")
public class GenreEntity {
    private int genreId;
    private String genre;

    @Id
    @Column(name = "Genre_ID")
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "Genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (genreId != that.genreId) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genreId;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
