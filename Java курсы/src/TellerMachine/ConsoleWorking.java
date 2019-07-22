package TellerMachine;

import TellerMachine.utils.ValidInformation;
import TellerMachine.utils.WorkingWithFiles;
import java.util.Scanner;

public class ConsoleWorking {

    private static TellerMachine tellerMachine = WorkingWithFiles.tellerMachineFromFile();

    public static void authorization(){
        Scanner scanner = new Scanner(System.in);

        String numberOfCard;
        do{
            System.out.println("Для работы с банкоматом введите номер вашей карты.");
            System.out.println("Номер должен быть введён в формате XXXX-XXXX-XXXX-XXXX:");
            numberOfCard = scanner.nextLine();
        }
        while (!ValidInformation.isNumeric(numberOfCard.replaceAll("-", ""))
                || !ValidInformation.isValidLength(numberOfCard)
                || !ValidInformation.isTrueNumber(numberOfCard)
        );


        String pincode;
        do{
            System.out.println("Введите пин-код:");
            pincode = scanner.nextLine();
        }
        while (!ValidInformation.isNumeric(pincode)
                || !ValidInformation.isValidPinLength(pincode)
                || !ValidInformation.isTruePin(numberOfCard, pincode)
        );

        consoleMenu(FunctionsOfTellerMachine.findCreditCard(numberOfCard, pincode));
    }

    public static void consoleMenu(CreditCard creditCard){

        Scanner scanner = new Scanner(System.in);
        System.out.println("______________________________");
        System.out.println("ДЛЯ ДАЛЬНЕЙШЕЙ РАБОТЫ НАЖМИТЕ:");

        System.out.println("1. Для того, чтобы проверить баланс карты.");
        System.out.println("2. Для того, чтобы снять деньги со счета.");
        System.out.println("3. Для того, чтобы пополнить баланс карты.");
        System.out.println("4. Для того, чтобы вернуться на предыдущий шаг.");
        System.out.println("_______________________________________________");
        System.out.println("Выбранный вариант ответа: ");

        switch (ValidInformation.isValidNumberOfFunction(scanner.nextLine(), creditCard)) {
            case 1:
                System.out.println("На вашем счету " + creditCard.getAmountOfMoney() + " белорусских рублей.");
                lastDialog(creditCard);
                break;
            case 2:
                FunctionsOfTellerMachine.cashWithdrawal(creditCard, tellerMachine);
                lastDialog(creditCard);
                break;
            case 3:
                FunctionsOfTellerMachine.cashRefill(creditCard);
                lastDialog(creditCard);
                break;
            case 4:
                authorization();
                break;
            default:
                System.out.println("Функции под таким номером не существует.");
                consoleMenu(creditCard);
        }
    }

    public static void lastDialog(CreditCard creditCard){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Нажмите 1, если хотите продолжить.");
        System.out.println("Нажмите 2, если хотите выйти.");
        System.out.println("Ваш вариант ответа: ");

        switch (ValidInformation.isValidNumberOfFunction(scanner.nextLine(), creditCard)) {
            case 1:
                consoleMenu(creditCard);
                break;
            case 2:
                System.out.println("ХОРОШЕГО ДНЯ");
                break;
            default:
                System.out.println("Функции под таким номером не существует.");
                lastDialog(creditCard);
        }
    }
}
