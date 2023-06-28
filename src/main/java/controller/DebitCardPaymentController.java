package controller;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.CreditCardFactory;
import entity.payment.DebitCardFactory;
import entity.payment.PaymentTransaction;
import subsystem.InterbankSubsystem;

import java.util.Hashtable;
import java.util.Map;

public class DebitCardPaymentController extends PaymentController {
    @Override
    public Map<String, String> payOrder(int amount, String contents, String cardNumber, String cardHolderName, String expirationDate, String securityCode) {
        Map<String, String> result = new Hashtable<String, String>();
        result.put("RESULT", "PAYMENT FAILED!");
        try {
//			this.card = new CreditCard(
//					cardNumber,
//					cardHolderName,
//					getExpirationDate(expirationDate),
//					Integer.parseInt(securityCode));
            setCard(new DebitCardFactory(cardNumber, cardHolderName,
                    getExpirationDate(expirationDate), Integer.parseInt(securityCode)).createCard());
            System.out.println(getCard());
            setInterbank(new InterbankSubsystem());
            PaymentTransaction transaction = getInterbank().payOrder(getCard(), amount, contents);

            result.put("RESULT", "PAYMENT SUCCESSFUL!");
            result.put("MESSAGE", "You have successfully paid the order!");
        } catch (PaymentException | UnrecognizedException ex) {
            result.put("MESSAGE", ex.getMessage());
        }
        return result;
    }
}
