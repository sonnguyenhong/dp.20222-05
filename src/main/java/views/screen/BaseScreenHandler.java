package views.screen;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

import controller.AuthenticationController;
import controller.BaseController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.home.HomeScreenHandler;
import views.screen.popup.PopupScreen;

public abstract class dler extends FXMLScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(dler.class.getName());
	private Scene scene;
	private dler prev;
	protected final Stage stage;
	protected HomeScreenHandler homeScreenHandler;
	protected Hashtable<String, String> messages;
	private BaseController bController;

	protected dler(Stage stage, String screenPath) throws IOException {
		super(screenPath);
		this.stage = stage;
	}

	public void setPreviousScreen(dler prev) {
		this.prev = prev;
	}

	public dler getPreviousScreen() {
		return this.prev;
	}

	public void show() {
		if (this.scene == null) {
			this.scene = new Scene(this.getContent());
		}
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	public void setScreenTitle(String string) {
		this.stage.setTitle(string);
	}

	public void setBController(BaseController bController){
		this.bController = bController;
	}

	public BaseController getBController(){
		return this.bController;
	}

	public void forward(Hashtable messages) {
		this.messages = messages;
	}

	public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
		this.homeScreenHandler = HomeScreenHandler;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public dler getPrev() {
		return prev;
	}

	public void setPrev(dler prev) {
		this.prev = prev;
	}

	public Stage getStage() {
		return stage;
	}

	public HomeScreenHandler getHomeScreenHandler() {
		return homeScreenHandler;
	}

	public Hashtable<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Hashtable<String, String> messages) {
		this.messages = messages;
	}

	public BaseController getbController() {
		return bController;
	}

	public void setbController(BaseController bController) {
		this.bController = bController;
	}
}
