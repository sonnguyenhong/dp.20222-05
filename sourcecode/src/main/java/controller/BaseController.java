package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartItem;
import entity.media.Media;

/**
 * This class is the base controller for our AIMS project
 * @author nguyenlm
 */
public class BaseController {
    SessionInformation sessionInformation = SessionInformation.getInstance();
    /**
     * The method checks whether the Media in Cart, if it were in, we will return the CartMedia else return null
     * @param media
     * @return CartMedia or null
     */

    // Stamp coupling
    public CartItem checkMediaInCart(Media media){
        // Co the dung Singleton DP de tao ra 1 cart instance duy nhat
        return sessionInformation.getCartInstance().checkMediaInCart(media); /// fix common coupling
    }

    /**
     * This method gets the list of items in cart
     * @return List[CartMedia]
     */
    public List getListCartMedia(){
        return sessionInformation.getCartInstance().getListMedia(); /// fix content coupling
    }
}