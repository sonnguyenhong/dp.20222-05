package dao.media.factory;

import constants.MediaType;
import entity.db.AIMSDB;
import entity.media.CD;
import entity.media.DVD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DvdFactory extends MediaFactory {
    public DvdFactory() {
    }

    @Override
    public Media create(Media media) throws SQLException {
        // Validate type
        if(media.getType().equals(MediaType.dvd.toString())) {
            String sql = "SELECT * FROM "+
                    "aims.DVD " +
                    "where DVD.id = " + media.getId() + ";";
            Statement stm = AIMSDB.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()) {
                // from DVD table
                String discType = res.getString("discType");
                String director = res.getString("director");
                int runtime = res.getInt("runtime");
                String studio = res.getString("studio");
                String subtitles = res.getString("subtitle");
                Date releasedDate = res.getDate("releasedDate");
                String filmType = res.getString("filmType");

                return new DVD(media.getId(), media.getTitle(), media.getCategory(), media.getPrice(),
                        media.getQuantity(), media.getType(), discType, director, runtime,
                        studio, subtitles, releasedDate, filmType);
            } else {
                throw new SQLException();
            }
        }
        return null;
    }
}
