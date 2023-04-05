package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
/// content Coupling
public class SessionInformation {
    public static User mainUser;
    public static Cart cartInstance = new Cart();
    public static LocalDateTime expiredTime;
    
    public static User getMainUser() {
        return mainUser;
    }

    public static void setMainUser(User mainUser) {
        SessionInformation.mainUser = mainUser;
    }

    public static Cart getCartInstance() {
        return cartInstance;
    }

    public static void setCartInstance(Cart cartInstance) {
        SessionInformation.cartInstance = cartInstance;
    }

    public static LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public static void setExpiredTime(LocalDateTime expiredTime) {
        SessionInformation.expiredTime = expiredTime;
    }
}
