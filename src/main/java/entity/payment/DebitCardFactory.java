package entity.payment;

public class DebitCardFactory extends CardFactory{
    private String cardCode;
    private String owner;
    private String dateExpired;
    private int cvvCode;

    public DebitCardFactory(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }

    @Override
    public Card createCard() {
        return new CreditCard(cardCode, owner, dateExpired, cvvCode);
    }
}
