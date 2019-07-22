package TellerMachine.utils;

import TellerMachine.ConsoleWorking;
import TellerMachine.CreditCard;
import java.util.List;
public class ValidInformation {

    public static Boolean isValidLength(String line){
        if(line.length() == 19){
            return true;
        }
        else{
            System.out.println("Номер карты должен содержать 16 цифр.");
            return false;
        }
    }

    public static Boolean isValidPinLength(String line){
        if(line.length() == 4){
            return true;
        }
        else{
            System.out.println("Пин-код должен содержать 4 цифры.");
            return false;
        }
    }

    public static boolean isTruePin(String numberOfCard, String pin){
        boolean isTrue = false;
        List<CreditCard> cards = WorkingWithFiles.creditCardsFromFile();
        for(CreditCard card : cards){
            if(numberOfCard.equals(card.getNumberOfCard())
            && pin.equals(card.getPincode())){
                isTrue = true;
            }
        }
        if(isTrue == false){
            System.out.println("Неправильный пин-код.");
        }
        return isTrue;
    }

    public static boolean isTrueNumber(String line){
        boolean isTrue = false;
        List<CreditCard> cards = WorkingWithFiles.creditCardsFromFile();
        for(CreditCard card : cards){
            if(line.equals(card.getNumberOfCard())){
                isTrue = true;
            }
        }
        if(isTrue == false){
            System.out.println("Карты с таким номером не существует.");
        }
        return isTrue;
    }

    public static boolean isNumeric(String str)
    {
        try
        { Long i = Long.parseLong(str);
        }
        catch(NumberFormatException nfe)
        { return false;
        }
        return true;
    }

    public static int isValidNumberOfFunction(String checkValue, CreditCard creditCard){
        Integer swValue = 0;
        if(!isNumeric(checkValue)){
            System.out.println("Неверный формат введенных данных.");
            ConsoleWorking.consoleMenu(creditCard);
        }
        else{
            swValue = Integer.valueOf(checkValue);
        }
        return swValue;
    }
}
