package Test;

import javax.persistence.*;

/**
 * Created by Brian on 11/5/16.
 */
@Entity
@Table(name = "Rating", schema = "Movies", catalog = "")
public class RatingEntity {
    private int ratingId;
    private String rating;

    @Id
    @Column(name = "Rating_ID")
    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    @Basic
    @Column(name = "Rating")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingEntity that = (RatingEntity) o;

        if (ratingId != that.ratingId) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ratingId;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
