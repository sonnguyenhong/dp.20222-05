package entity.media;

import dao.media.MediaDAO;
import entity.db.AIMSDB;
import utils.Utils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * The general media class, for another media it can be done by inheriting this class
 * @author nguyenlm
 */
public class Media {

    private static Logger LOGGER = Utils.getLogger(Media.class.getName());

    private Statement stm;
    private int id;
    private String title;
    private String category;
    private int value; // the real price of product (eg: 450)
    private int price; // the price which will be displayed on browser (eg: 500)
    private int quantity;
    private String type;
    private String imageURL;
    private boolean rushSupported;

    public Media() throws SQLException {
        stm = AIMSDB.getConnection().createStatement();
    }

    public Media (int id, String title, String category, int price, int quantity, String type) throws SQLException{
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public Media(int id, String title, int quantity, String category, String imageUrl, int price, String type) throws SQLException {
        this(id, title, category, price, quantity, type);
        this.imageURL = imageUrl;
    }

    public int getQuantity() throws SQLException {
        int updated_quantity = new MediaDAO().getMediaById(id).quantity;
        this.quantity = updated_quantity;
        return updated_quantity;
    }

    // getter and setter 
    public int getId() {
        return this.id;
    }

    private Media setId(int id){
        this.id = id;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public Media setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public Media setCategory(String category) {
        this.category = category;
        return this;
    }

    public int getPrice() {
        return this.price;
    }

    public Media setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getImageURL(){
        return this.imageURL;
    }

    public Media setMediaURL(String url){
        this.imageURL = url;
        return this;
    }

    public Media setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Media setType(String type) {
        this.type = type;
        return this;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public static void setLOGGER(Logger LOGGER) {
        Media.LOGGER = LOGGER;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isRushSupported() {
        return rushSupported;
    }

    public void setRushSupported(boolean rushSupported) {
        this.rushSupported = rushSupported;
    }
}