package views.screen.home;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import common.exception.MediaNotAvailableException;
import common.interfaces.Observable;
import common.interfaces.Observer;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Utils;
import views.screen.FXMLScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.PopupScreen;

public class MediaHandler extends FXMLScreenHandler implements Observable {

    @FXML
    private ImageView mediaImage;

    @FXML
    private Label mediaTitle;

    @FXML
    private Label mediaPrice;

    @FXML
    private Label mediaAvail;

    @FXML
    private Spinner<Integer> spinnerChangeNumber;

    @FXML
    private Button addToCartBtn;

    private static Logger LOGGER = Utils.getLogger(MediaHandler.class.getName());
    private Media media;
    private List<Observer> observerList;

    public MediaHandler(String screenPath, Media media) throws SQLException, IOException{
        super(screenPath);
        this.media = media;
        this.observerList = new ArrayList<>();
        addToCartBtn.setOnMouseClicked(event -> {
            notifyObservers();
        });
        setMediaInfo();
    }

    Media getMedia(){
        return media;
    }
    int getRequestQuantity() {
        return spinnerChangeNumber.getValue();
    }

    private void setMediaInfo() throws SQLException {
        // set the cover image of media
        File file = new File(media.getImageURL());
        Image image = new Image(file.toURI().toString());
        mediaImage.setFitHeight(160);
        mediaImage.setFitWidth(152);
        mediaImage.setImage(image);

        mediaTitle.setText(media.getTitle());
        mediaPrice.setText(ViewsConfig.getCurrencyFormat(media.getPrice()));
        mediaAvail.setText(Integer.toString(media.getQuantity()));
        spinnerChangeNumber.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1)
        );

        setImage(mediaImage, media.getImageURL());
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(this));
    }

    public ImageView getMediaImage() {
        return mediaImage;
    }

    public void setMediaImage(ImageView mediaImage) {
        this.mediaImage = mediaImage;
    }

    public Label getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(Label mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public Label getMediaPrice() {
        return mediaPrice;
    }

    public void setMediaPrice(Label mediaPrice) {
        this.mediaPrice = mediaPrice;
    }

    public Label getMediaAvail() {
        return mediaAvail;
    }

    public void setMediaAvail(Label mediaAvail) {
        this.mediaAvail = mediaAvail;
    }

    public Spinner<Integer> getSpinnerChangeNumber() {
        return spinnerChangeNumber;
    }

    public void setSpinnerChangeNumber(Spinner<Integer> spinnerChangeNumber) {
        this.spinnerChangeNumber = spinnerChangeNumber;
    }

    public Button getAddToCartBtn() {
        return addToCartBtn;
    }

    public void setAddToCartBtn(Button addToCartBtn) {
        this.addToCartBtn = addToCartBtn;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public static void setLOGGER(Logger LOGGER) {
        MediaHandler.LOGGER = LOGGER;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }
}
