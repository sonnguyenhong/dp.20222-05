package entity.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import java.sql.Connection;
import utils.*;

// Singleton DP
public class AIMSDB {
	private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
	private static Connection connect;
	// TODO: refactor Utils -> limit connections
    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
			Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/main/resources/assets/db/aims.db";
            connect = DriverManager.getConnection(url);
            LOGGER.info("Connect database successfully");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } 
        return connect;
    }


    public static void main(String[] args) {
        AIMSDB.getConnection();
    }
}
