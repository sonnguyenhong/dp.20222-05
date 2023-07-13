package entity.payment;

public abstract class CardFactory {
    public abstract Card createCard();

    public Card performOperation() {
        Card card = createCard();
        return card;
    }
}
