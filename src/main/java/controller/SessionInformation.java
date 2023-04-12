package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */

/// Common Coupling
public class SessionInformation {
    private static User mainUser;
    private static Cart cartInstance = new Cart();
    private static LocalDateTime expiredTime;

    public static User getMainUser() {
        return mainUser;
    }

    // Stamp coupling
    public static void setMainUser(User mainUser) {
        SessionInformation.mainUser = mainUser;
    }

    public static Cart getCartInstance() {
        return cartInstance;
    }

    // Stamp coupling
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
