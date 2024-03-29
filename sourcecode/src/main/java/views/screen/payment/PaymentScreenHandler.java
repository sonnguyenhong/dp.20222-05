package views.screen.payment;

import controller.PaymentController;
import entity.invoice.Invoice;
import entity.payment.CreditCard;
import entity.payment.DomesticCard;
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
    private Label securityLabel;
    @FXML
    private TextField securityCode;

    @FXML
    private Label issuingBankLabel;
    @FXML
    private TextField issuingBank;

	public PaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		try {
            setupData(invoice);
			setupFunctionality();
		} catch (IOException ex) {
			handleIOException(ex);
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
                System.out.println(exp);
                System.out.println(exp.getStackTrace());
            }
        });

        radioBtnToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue instanceof RadioButton) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                if ("creditCardRadioBtn".equals(selectedRadioButton.getId())) {
                    securityLabel.setVisible(true);
                    securityCode.setVisible(true);
                    securityLabel.setManaged(true);
                    securityCode.setManaged(true);

                    issuingBankLabel.setVisible(false);
                    issuingBank.setVisible(false);
                    issuingBankLabel.setManaged(false);
                    issuingBank.setManaged(false);
                   issuingBank.setVisible(false);
                } else if ("domesticCardRadioBtn".equals(selectedRadioButton.getId())) {
                    securityLabel.setVisible(false);
                    securityCode.setVisible(false);
                    securityLabel.setManaged(false);
                    securityCode.setManaged(false);

                    issuingBankLabel.setVisible(true);
                    issuingBank.setVisible(true);
                    issuingBankLabel.setManaged(true);
                    issuingBank.setManaged(true);
                }
            }
        });
    }

    void confirmToPayOrder() throws IOException {
        String contents = "pay order";

        RadioButton selectedRadioBtn = (RadioButton) radioBtnToggleGroup.getSelectedToggle();
        System.out.println(selectedRadioBtn.getText().toString().equals("Credit Card"));
        PaymentController ctrl = (PaymentController) getBController();
        Map<String, String> response;
        if (selectedRadioBtn.getText().toString().equals("Credit Card")) {
            System.out.println("Credit card selected");
            CreditCard creditCard = new CreditCard(cardNumber.getText(), holderName.getText(), expirationDate.getText(), Integer.parseInt(securityCode.getText()));
            response = ctrl.payOrder(invoice.getAmount(), contents, creditCard);

        } else if (selectedRadioBtn.getText().toString().equals("Domestic Card")) {
            System.out.println("Domestic Card  selected");
            DomesticCard domesticCard = new DomesticCard(cardNumber.getText(), holderName.getText(), expirationDate.getText(),issuingBank.getText());
            response = ctrl.payOrder(invoice.getAmount(), contents, domesticCard);
        } else {
            throw new IOException("Payment method not defined");
        }

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