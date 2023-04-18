package views.screen.payment;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.popup.PopupScreen;

// Temporal Cohension (Thuc hien cac phuong thuc setupData va setupFunctionality o trong phuong thuc khoi tao)
// 2 phuong thuc lien quan den nhau trong luc khoi chay (related when they are executed)
public class ResultScreenHandler extends BaseScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(PaymentScreenHandler.class.getName());

	private String result;
	private String message;

	public ResultScreenHandler(Stage stage, String screenPath, Map<String, String> response) throws IOException {
		super(stage, screenPath);
		try {
			setupData(response);
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
		Map<String, String> response = (Map<String, String>) dto;
		resultLabel.setText(response.get("RESULT"));
		messageLabel.setText(response.get("MESSAGE"));
	}

	protected void setupFunctionality() throws Exception {
		return;
	}

	@FXML
	private Label pageTitle;

	@FXML
	private Label resultLabel;

	@FXML
	private Button okButton;
	
	@FXML
	private Label messageLabel;

	@FXML
	void confirmPayment(MouseEvent event) throws IOException {
		homeScreenHandler.show();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Label getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(Label pageTitle) {
		this.pageTitle = pageTitle;
	}

	public Label getResultLabel() {
		return resultLabel;
	}

	public void setResultLabel(Label resultLabel) {
		this.resultLabel = resultLabel;
	}

	public Button getOkButton() {
		return okButton;
	}

	public void setOkButton(Button okButton) {
		this.okButton = okButton;
	}

	public Label getMessageLabel() {
		return messageLabel;
	}

	public void setMessageLabel(Label messageLabel) {
		this.messageLabel = messageLabel;
	}
}
