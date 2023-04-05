package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */

/// Common Coupling
public class SessionInformation {
	private static SessionInformation instance;
    private User mainUser;
    private Cart cartInstance;
    private LocalDateTime expiredTime;
    
    private SessionInformation() {
        // Private constructor to prevent instantiation from outside
        cartInstance = Cart.getCartInstance();
    }

    public static SessionInformation getInstance() {
        if (instance == null) {
            synchronized (SessionInformation.class) {
                if (instance == null) {
                    instance = new SessionInformation();
                }
            }
        }
        return instance;
    }

    public User getMainUser() {
        return mainUser;
    }

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }
    
    public Cart getCartInstance() {
        return cartInstance;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }
}
