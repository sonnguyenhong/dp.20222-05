package views.screen.shipping;

import common.exception.InvalidDeliveryInfoException;
import controller.PlaceOrderController;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.shipping.DeliveryInfo;
import entity.shipping.ShippingConfigs;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.invoice.InvoiceScreenHandler;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Logger;


// Temporal Cohension (Thuc hien cac phuong thuc setupData va setupFunctionality o trong phuong thuc khoi tao)
// 2 phuong thuc lien quan den nhau trong luc khoi chay (related when they are executed)

public class ShippingScreenHandler extends BaseScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(ShippingScreenHandler.class.getName());

	@FXML
	private Label screenTitle;

	@FXML
	private TextField name;

	@FXML
	private TextField phone;

	@FXML
	private TextField address;

	@FXML
	private TextField instructions;

	@FXML
	private ComboBox<String> province;

	private Order order;

	public ShippingScreenHandler(Stage stage, String screenPath, Order order) throws IOException {
		super(stage, screenPath);
		try {
			setupData(order);
			setupFunctionality();
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error("Error when loading resources.");
		} catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error(ex.getMessage());
		}
	}

	protected void setupData(Object dto) throws Exception {
		this.order = (Order) dto;
		this.province.getItems().addAll(ShippingConfigs.PROVINCES);
		this.province.getSelectionModel().select(ShippingConfigs.RUSH_SUPPORT_PROVINCES_INDEX[0]);
	}

	protected void setupFunctionality() throws Exception {
		final BooleanProperty firstTime = new SimpleBooleanProperty(true); // Variable to store the focus on stage load
		name.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
			if(newValue && firstTime.get()){
				this.getContent().requestFocus(); // Delegate the focus to container
				firstTime.setValue(false); // Variable value changed for future references
			}
		});

	}

	@FXML
	void submitDeliveryInfo(MouseEvent event) throws IOException, InterruptedException, SQLException {

		// validate delivery info and prepare order info
		preprocessDeliveryInfo();
		
		// create invoice screen
		Invoice invoice = getBController().createInvoice(order);
		BaseScreenHandler InvoiceScreenHandler = new InvoiceScreenHandler(this.stage, ViewsConfig.INVOICE_SCREEN_PATH, invoice);
		InvoiceScreenHandler.setPreviousScreen(this);
		InvoiceScreenHandler.setHomeScreenHandler(homeScreenHandler);
		InvoiceScreenHandler.setScreenTitle("Invoice Screen");
		InvoiceScreenHandler.setBController(getBController());
		InvoiceScreenHandler.show();
	}

	public void preprocessDeliveryInfo() throws IOException, InterruptedException {
		// add info to messages
		HashMap<String, String> messages = new HashMap<>();
		messages.put("name", name.getText());
		messages.put("phone", phone.getText());
		messages.put("address", address.getText());
		messages.put("instructions", instructions.getText());
		messages.put("province", province.getValue());
		DeliveryInfo deliveryInfo;
		try {
			// process and validate delivery info
			deliveryInfo = getBController().processDeliveryInfo(messages);
		} catch (InvalidDeliveryInfoException e) {
			// TODO: implement pop up screen
			throw new InvalidDeliveryInfoException(e.getMessage());
		}

		order.setDeliveryInfo(deliveryInfo);
	}

	public PlaceOrderController getBController(){
		return (PlaceOrderController) super.getBController();
	}

	public void notifyError(){
		// TODO: implement later on if we need
	}

	public Label getScreenTitle() {
		return screenTitle;
	}

	public void setScreenTitle(Label screenTitle) {
		this.screenTitle = screenTitle;
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public TextField getPhone() {
		return phone;
	}

	public void setPhone(TextField phone) {
		this.phone = phone;
	}

	public TextField getAddress() {
		return address;
	}

	public void setAddress(TextField address) {
		this.address = address;
	}

	public TextField getInstructions() {
		return instructions;
	}

	public void setInstructions(TextField instructions) {
		this.instructions = instructions;
	}

	public ComboBox<String> getProvince() {
		return province;
	}

	public void setProvince(ComboBox<String> province) {
		this.province = province;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
