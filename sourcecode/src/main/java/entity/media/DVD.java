package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DVD extends Media {

    private String discType;
    private String director;
    private int runtime;
    private String studio;
    private String subtitles;
    private Date releasedDate;
    private String filmType;

    public DVD() throws SQLException{

    }

    public DVD(int id, String title, String category, int price, int quantity, String type, String discType,
            String director, int runtime, String studio, String subtitles, Date releasedDate, String filmType) throws SQLException{
        super(id, title, category, price, quantity, type);
        this.discType = discType;
        this.director = director;
        this.runtime = runtime;
        this.studio = studio;
        this.subtitles = subtitles;
        this.releasedDate = releasedDate;
        this.filmType = filmType;
    }

    public String getDiscType() {
        return this.discType;
    }

    public DVD setDiscType(String discType) {
        this.discType = discType;
        return this;
    }

    public String getDirector() {
        return this.director;
    }

    public DVD setDirector(String director) {
        this.director = director;
        return this;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public DVD setRuntime(int runtime) {
        this.runtime = runtime;
        return this;
    }

    public String getStudio() {
        return this.studio;
    }

    public DVD setStudio(String studio) {
        this.studio = studio;
        return this;
    }

    public String getSubtitles() {
        return this.subtitles;
    }

    public DVD setSubtitles(String subtitles) {
        this.subtitles = subtitles;
        return this;
    }

    public Date getReleasedDate() {
        return this.releasedDate;
    }

    public DVD setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getFilmType() {
        return this.filmType;
    }

    public DVD setFilmType(String filmType) {
        this.filmType = filmType;
        return this;
    }

    @Override
    public String toString() {
        try {
            String basicInformation = "{" +
                    " id='" + this.getId() + "'" +
                    ", title='" + this.getTitle() + "'" +
                    ", category='" + this.getCategory() + "'" +
                    ", price='" + this.getPrice() + "'" +
                    ", quantity='" + this.getQuantity() + "'" +
                    ", type='" + this.getType() + "'" +
                    ", imageURL='" + this.getImageURL() + "'" +
                    "}";
            return "{" + basicInformation + " discType='" + discType + "'" + ", director='" + director + "'" + ", runtime='"
                    + runtime + "'" + ", studio='" + studio + "'" + ", subtitles='" + subtitles + "'" + ", releasedDate='"
                    + releasedDate + "'" + ", filmType='" + filmType + "'" + "}";
        } catch (SQLException ex) {
            System.out.println("SQL Exception occurred!");
            return ex.getMessage();
        }
    }
}
