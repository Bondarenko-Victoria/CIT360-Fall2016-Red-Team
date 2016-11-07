package Test;

import javax.persistence.*;

/**
 * Created by Brian on 11/5/16.
 */
@Entity
@Table(name = "Title", schema = "Movies", catalog = "")
public class TitleEntity {
    private int titleId;
    private String movieTitle;

    @Id
    @Column(name = "Title_ID")
    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    @Basic
    @Column(name = "Movie_Title")
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitleEntity that = (TitleEntity) o;

        if (titleId != that.titleId) return false;
        if (movieTitle != null ? !movieTitle.equals(that.movieTitle) : that.movieTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = titleId;
        result = 31 * result + (movieTitle != null ? movieTitle.hashCode() : 0);
        return result;
    }
}
