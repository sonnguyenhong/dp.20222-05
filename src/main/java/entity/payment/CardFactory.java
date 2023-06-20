package entity.payment;

public abstract class CardFactory {
    public abstract Card createCard();

    public Card performCreateCard() {
        Card card = createCard();
        return card;
    }
}
