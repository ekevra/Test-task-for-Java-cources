package TellerMachine;

public class CreditCard {

    private String numberOfCard;
    private String pincode;
    private int amountOfMoney;

    public String getNumberOfCard() {
        return numberOfCard;
    }
    public void setNumberOfCard(String numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }
    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public CreditCard(){
    }

    public CreditCard(String number, String pin, int money){
        this.numberOfCard = number;
        this.pincode = pin;
        this.amountOfMoney = money;
    }

    public CreditCard(String number, String pin){
        this.numberOfCard = number;
        this.pincode = pin;
        this.amountOfMoney = 0;
    }

    @Override
    public String toString() {
        return this.numberOfCard + " " + this.pincode + " " + this.amountOfMoney;
    }
}
