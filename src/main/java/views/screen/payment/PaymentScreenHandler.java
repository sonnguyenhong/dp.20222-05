package views.screen.payment;

import controller.CreditCardPaymentController;
import controller.DebitCardPaymentController;
import controller.PaymentController;
import entity.invoice.Invoice;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

// Temporal Cohension (Thuc hien cac phuong thuc setupData va setupFunctionality o trong phuong thuc khoi tao)
// 2 phuong thuc lien quan den nhau trong luc khoi chay (related when they are executed)
public class PaymentScreenHandler extends BaseScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(PaymentScreenHandler.class.getName());

	@FXML
	private Button btnConfirmPayment;

	@FXML
	private ToggleGroup radioBtnToggleGroup;

	@FXML
	private ImageView loadingImage;

	private Invoice invoice;

	@FXML
	private Label pageTitle;

	@FXML
	private TextField cardNumber;

	@FXML
	private TextField holderName;

	@FXML
	private TextField expirationDate;

	@FXML
	private TextField securityCode;

	public PaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		try {
			setupData(invoice);
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
		this.invoice = (Invoice) dto;
	}

	protected void setupFunctionality() throws Exception {
		btnConfirmPayment.setOnMouseClicked(e -> {
			try {
				confirmToPayOrder();
				((PaymentController) getBController()).emptyCart();
			} catch (Exception exp) {
				System.out.println(exp.getStackTrace());
			}
		});
	}

	void confirmToPayOrder() throws IOException{
		String contents = "pay order";

		RadioButton selectedRadioBtn = (RadioButton) radioBtnToggleGroup.getSelectedToggle();
		System.out.println(selectedRadioBtn.getText().toString().equals("Credit Card"));
		PaymentController ctrl;
		if(selectedRadioBtn.getText().toString().equals("Credit Card")) {
			System.out.println("Credit card selected");
			ctrl = new CreditCardPaymentController();
		} else if(selectedRadioBtn.getText().toString().equals("Debit Card")) {
			System.out.println("Debit card selected");
			ctrl = new DebitCardPaymentController();
		} else {
			throw new IOException("Payment method not defined");
		}

		Map<String, String> response = ctrl.payOrder(invoice.getAmount(), contents, cardNumber.getText(), holderName.getText(),
				expirationDate.getText(), securityCode.getText());

		BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, ViewsConfig.RESULT_SCREEN_PATH, response);
		resultScreen.setPreviousScreen(this);
		resultScreen.setHomeScreenHandler(homeScreenHandler);
		resultScreen.setScreenTitle("Result Screen");
		resultScreen.show();
	}

	public Button getBtnConfirmPayment() {
		return btnConfirmPayment;
	}

	public void setBtnConfirmPayment(Button btnConfirmPayment) {
		this.btnConfirmPayment = btnConfirmPayment;
	}

	public ImageView getLoadingImage() {
		return loadingImage;
	}

	public void setLoadingImage(ImageView loadingImage) {
		this.loadingImage = loadingImage;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Label getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(Label pageTitle) {
		this.pageTitle = pageTitle;
	}

	public TextField getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(TextField cardNumber) {
		this.cardNumber = cardNumber;
	}

	public TextField getHolderName() {
		return holderName;
	}

	public void setHolderName(TextField holderName) {
		this.holderName = holderName;
	}

	public TextField getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(TextField expirationDate) {
		this.expirationDate = expirationDate;
	}

	public TextField getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(TextField securityCode) {
		this.securityCode = securityCode;
	}
}