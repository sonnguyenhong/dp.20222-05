package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import entity.db.AIMSDB;

public class Book extends Media {

    private String author;
    private String coverType;
    private String publisher;
    private Date publishDate;
    private int numOfPages;
    private String language;
    private String bookCategory;

    public Book() throws SQLException{

    }

    public Book(int id, String title, String category, int price, int quantity, String type, String author,
            String coverType, String publisher, Date publishDate, int numOfPages, String language,
            String bookCategory) throws SQLException{
        super(id, title, category, price, quantity, type);
        this.author = author;
        this.coverType = coverType;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.numOfPages = numOfPages;
        this.language = language;
        this.bookCategory = bookCategory;
    }

    // getter and setter
    public int getId() {
        return this.getId();
    }

    public String getAuthor() {
        return this.author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCoverType() {
        return this.coverType;
    }

    public Book setCoverType(String coverType) {
        this.coverType = coverType;
        return this;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Date getPublishDate() {
        return this.publishDate;
    }

    public Book setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public int getNumOfPages() {
        return this.numOfPages;
    }

    public Book setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
        return this;
    }

    public String getLanguage() {
        return this.language;
    }

    public Book setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getBookCategory() {
        return this.bookCategory;
    }

    public Book setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
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
            return "{" +
                    basicInformation +
                    " author='" + author + "'" +
                    ", coverType='" + coverType + "'" +
                    ", publisher='" + publisher + "'" +
                    ", publishDate='" + publishDate + "'" +
                    ", numOfPages='" + numOfPages + "'" +
                    ", language='" + language + "'" +
                    ", bookCategory='" + bookCategory + "'" +
                    "}";
        } catch (SQLException ex) {
            System.out.println("SQL Exception occurred!");
            return ex.getMessage();
        }
    }
}
