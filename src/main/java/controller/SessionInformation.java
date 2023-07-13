package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

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


//package controller;
//
//import entity.cart.Cart;
//import entity.user.User;
//
//import java.time.LocalDateTime;
//
///**
// * @author
// */
//
///// Common Coupling
//public class SessionInformation {
//    private static User mainUser;
//    private static Cart cartInstance = new Cart();
//    private static LocalDateTime expiredTime;
//
//    private static SessionInformation sessionInformation;
//
//    // Thiet ke Singleton
//    private SessionInformation() {}
//
//    public static SessionInformation getSessionInformation() {
//        if(sessionInformation == null) {
//            synchronized (SessionInformation.class) {
//                if(sessionInformation == null) {
//                    sessionInformation = new SessionInformation();
//                }
//            }
//        }
//        return sessionInformation;
//    }
//
//    public static User getMainUser() {
//        return mainUser;
//    }
//
//    // Stamp coupling
//    public static void setMainUser(User mainUser) {
//        SessionInformation.mainUser = mainUser;
//    }
//
//    public static Cart getCartInstance() {
//        return cartInstance;
//    }
//
//    // Stamp coupling
//    public static void setCartInstance(Cart cartInstance) {
//        SessionInformation.cartInstance = cartInstance;
//    }
//
//    public static LocalDateTime getExpiredTime() {
//        return expiredTime;
//    }
//
//    public static void setExpiredTime(LocalDateTime expiredTime) {
//        SessionInformation.expiredTime = expiredTime;
//    }
//}