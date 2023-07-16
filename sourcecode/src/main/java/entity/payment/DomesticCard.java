package entity.payment;

public class DomesticCard extends Card {

    private String issuingBank;
    private String cardNumber;
    private String validFromDate;
    private String cardHolderName;

    public DomesticCard(String issuingBank, String cardNumber, String validFromDate, String cardHolderName) {
        this.issuingBank = issuingBank;
        this.cardNumber = cardNumber;
        this.validFromDate = validFromDate;
        this.cardHolderName = cardHolderName;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(String validFromDate) {
        this.validFromDate = validFromDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }


}
