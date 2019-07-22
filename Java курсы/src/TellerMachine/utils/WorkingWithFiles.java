package TellerMachine.utils;

import TellerMachine.CreditCard;
import TellerMachine.TellerMachine;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithFiles {

    public static void creditCardsToFile(List<CreditCard> cards){

        try(FileWriter writer = new FileWriter("credit cards.txt", false))
        {
            for(CreditCard card : cards){
                writer.write(card.toString() + "\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getStackTrace());
        }
    }

    public static List<CreditCard> creditCardsFromFile(){

        List<CreditCard> creditCards = new ArrayList<>();
        String line;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("credit cards.txt"));
            while ((line = reader.readLine()) != null) {
                creditCards.add(fromLineToCardObject(line));
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        return creditCards;
    }

    public static CreditCard fromLineToCardObject(String line){

        String[] strings = line.split(" ");
        return new CreditCard(strings[0], strings[1], Integer.valueOf(strings[2]));
    }

    public static void tellerMachineToFile(TellerMachine machine){

        try(FileWriter writer = new FileWriter("teller machine.txt", false))
        {
            writer.write(machine.toString() + "\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getStackTrace());
        }
    }

    public static TellerMachine tellerMachineFromFile(){

        TellerMachine machine = new TellerMachine();
        String line = " ";
        try{
            BufferedReader reader = new BufferedReader(new FileReader("teller machine.txt"));
            line = reader.readLine();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fromLineToMachineObject(line);
    }

    public static TellerMachine fromLineToMachineObject(String line){

        String[] strings = line.split(" ");
        return new TellerMachine(strings[0], Integer.valueOf(strings[1]));
    }

    public static void updateCreditCards(CreditCard card){

        List<CreditCard> creditCards = creditCardsFromFile();
        for(CreditCard creditCard : creditCards){
            if(creditCard.getNumberOfCard().equals(card.getNumberOfCard())
            && creditCard.getPincode().equals(card.getPincode())){
                creditCard.setAmountOfMoney(card.getAmountOfMoney());
            }
        }
        creditCardsToFile(creditCards);
    }
}
