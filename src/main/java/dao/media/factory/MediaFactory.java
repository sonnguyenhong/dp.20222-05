package dao.media.factory;

import entity.media.Media;

import java.sql.SQLException;

public abstract class MediaFactory {
    public abstract Media create(Media media) throws SQLException;
}
