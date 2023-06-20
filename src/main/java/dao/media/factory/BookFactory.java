package dao.media.factory;

import constants.MediaType;
import entity.db.AIMSDB;
import entity.media.Book;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class BookFactory extends MediaFactory {
    public BookFactory() {
    }

    @Override
    public Media create(Media media) throws SQLException {
        // Validate type
        if(media.getType().equals(MediaType.book.toString())) {
            String sql = "SELECT * FROM "+
                    "aims.Book " +
                    "where Book.id = " + media.getId() + ";";
            Statement stm = AIMSDB.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()) {
                // from Book table
                String author = res.getString("author");
                String coverType = res.getString("coverType");
                String publisher = res.getString("publisher");
                Date publishDate = res.getDate("publishDate");
                int numOfPages = res.getInt("numOfPages");
                String language = res.getString("language");
                String bookCategory = res.getString("bookCategory");

                return new Book(media.getId(), media.getTitle(), media.getCategory(), media.getPrice(),
                        media.getQuantity(), media.getType(), author, coverType, publisher, publishDate,
                        numOfPages, language, bookCategory);
            } else {
                throw new SQLException();
            }
        }
        return null;
    }
}
