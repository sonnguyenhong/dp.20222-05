package views.screen.invoice;

import java.io.IOException;
import java.sql.SQLException;

import entity.order.OrderItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import views.screen.FXMLScreenHandler;
import views.screen.ViewsConfig;

public class MediaInvoiceScreenHandler extends FXMLScreenHandler{

    @FXML
    private HBox hboxMedia;

    @FXML
    private VBox imageLogoVbox;

    @FXML
    private ImageView image;

    @FXML
    private VBox description;

    @FXML
    private Label title;

    @FXML
    private Label numOfProd;

    @FXML
    private Label labelOutOfStock;

    @FXML
    private Label price;

    private OrderItem orderItem;

    public MediaInvoiceScreenHandler(String screenPath) throws IOException{
        super(screenPath);
    }

    public void setOrderItem(OrderItem orderItem) throws SQLException{
        this.orderItem = orderItem;
        setMediaInfo();
    }

    public void setMediaInfo() throws SQLException{
        title.setText(orderItem.getMedia().getTitle());
        price.setText(ViewsConfig.getCurrencyFormat(orderItem.getPrice()));
        numOfProd.setText(String.valueOf(orderItem.getQuantity()));
        setImage(image, orderItem.getMedia().getImageURL());
		image.setPreserveRatio(false);
		image.setFitHeight(90);
		image.setFitWidth(83);
    }

    public HBox getHboxMedia() {
        return hboxMedia;
    }

    public void setHboxMedia(HBox hboxMedia) {
        this.hboxMedia = hboxMedia;
    }

    public VBox getImageLogoVbox() {
        return imageLogoVbox;
    }

    public void setImageLogoVbox(VBox imageLogoVbox) {
        this.imageLogoVbox = imageLogoVbox;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public VBox getDescription() {
        return description;
    }

    public void setDescription(VBox description) {
        this.description = description;
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public Label getNumOfProd() {
        return numOfProd;
    }

    public void setNumOfProd(Label numOfProd) {
        this.numOfProd = numOfProd;
    }

    public Label getLabelOutOfStock() {
        return labelOutOfStock;
    }

    public void setLabelOutOfStock(Label labelOutOfStock) {
        this.labelOutOfStock = labelOutOfStock;
    }

    public Label getPrice() {
        return price;
    }

    public void setPrice(Label price) {
        this.price = price;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }
}
