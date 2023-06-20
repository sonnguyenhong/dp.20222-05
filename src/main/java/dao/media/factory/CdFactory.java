package dao.media.factory;

import constants.MediaType;
import entity.db.AIMSDB;
import entity.media.Book;
import entity.media.CD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class CdFactory extends MediaFactory {

    public CdFactory() {
    }

    @Override
    public Media create(Media media) throws SQLException {

        // Validate type
        if(media.getType().equals(MediaType.cd.toString())) {
            String sql = "SELECT * FROM "+
                    "aims.CD " +
                    "where CD.id = " + media.getId() + ";";
            Statement stm = AIMSDB.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()) {
                // from CD table
                String artist = res.getString("artist");
                String recordLabel = res.getString("recordLabel");
                String musicType = res.getString("musicType");
                Date releasedDate = res.getDate("releasedDate");

                return new CD(media.getId(), media.getTitle(), media.getCategory(), media.getPrice(),
                        media.getQuantity(), media.getType(), artist, recordLabel, musicType, releasedDate);
            } else {
                throw new SQLException();
            }
        }
        return null;
    }
}
