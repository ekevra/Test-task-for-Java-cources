package TellerMachine;

import TellerMachine.utils.ValidInformation;
import TellerMachine.utils.WorkingWithFiles;
import java.util.List;
import java.util.Scanner;

public class FunctionsOfTellerMachine {

    public static CreditCard findCreditCard(String number, String pin){
        CreditCard creditCard = new CreditCard();
        List<CreditCard> cards = WorkingWithFiles.creditCardsFromFile();
        for(CreditCard card : cards){
            if(number.equals(card.getNumberOfCard())
                    && pin.equals(card.getPincode())){
                creditCard = card;
            }
        }
        return creditCard;
    }

    public static void cashWithdrawal(CreditCard creditCard, TellerMachine tellerMachine){

        System.out.println("Введите сумму, которую хотите снять с вашего счета:");
        Scanner scanner = new Scanner(System.in);
        String stringSum = scanner.nextLine();
        Integer sum = 0;
        if(!ValidInformation.isNumeric(stringSum)){
            System.out.println("Неверный формат введенных данных.");
            cashWithdrawal(creditCard, tellerMachine);
        }
        else{
            sum = Integer.valueOf(stringSum);
        }
        if(creditCard.getAmountOfMoney() < sum){
            System.out.println("На карте недостаточно средств.");
            cashWithdrawal(creditCard, tellerMachine);
        }
        else if(tellerMachine.getAmountOfMoney() < sum){
            System.out.println("В банкомате недостаточно средств.");
            cashWithdrawal(creditCard, tellerMachine);
        }
        else{
            creditCard.setAmountOfMoney(creditCard.getAmountOfMoney() - sum);
            tellerMachine.setAmountOfMoney(tellerMachine.getAmountOfMoney() - sum);
            System.out.println("С вашей карты снято " + sum + " рублей(рубля).");
            WorkingWithFiles.tellerMachineToFile(tellerMachine);
            WorkingWithFiles.updateCreditCards(creditCard);
        }
    }

    public static void cashRefill(CreditCard creditCard){

        System.out.println("Введите сумму, которой хотите пополнить баланс:");
        Scanner scanner = new Scanner(System.in);
        String stringSum = scanner.nextLine();
        Integer sum = 0;
        if(!ValidInformation.isNumeric(stringSum)){
            System.out.println("Неверный формат введенных данных.");
            cashRefill(creditCard);
        }
        else{
            sum = Integer.valueOf(stringSum);
        }
        if(sum > 1000000){
            System.out.println("Cумма пополнения не должна превышать 1 000 000");
            cashRefill(creditCard);
        }
        else{
            creditCard.setAmountOfMoney(creditCard.getAmountOfMoney() + sum);
            System.out.println(" вашу карту добавлено " + sum + " рублей(рубля).");
            WorkingWithFiles.updateCreditCards(creditCard);
        }

    }
}
