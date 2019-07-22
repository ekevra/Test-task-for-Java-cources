package TellerMachine;

public class TellerMachine {

    private String name;
    private int amountOfMoney;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }
    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public TellerMachine(String name, int money){
        this.name = name;
        this.amountOfMoney = money;
    }
    public TellerMachine(String name){
        this.name = name;
        this.amountOfMoney = 0;
    }
    public TellerMachine(){
    }

    @Override
    public String toString() {
        return this.name + " " + this.amountOfMoney;
    }
}
