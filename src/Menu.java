import java.util.Scanner;

public class Menu {


    //metoda uruchamiająca MENU i wybór opcji przez użytkownika, która wywołuje kolejną metodę
    void startMenu() {

        // wybór użytkownika
        int answer;

        Scanner menuAnswer = new Scanner(System.in);

        System.out.println("==========  Wybierz opcję z MENU ========== ");
        System.out.println("    [1] - Pobierz aktualną cenę złota ");
        System.out.println("    [2] - Pobierz historyczną cenę złota ");
        System.out.print("Wybierz opcję: ");
        answer = menuAnswer.nextInt();


        if (answer == 1) {
            System.out.println("Wybrano opcję: 1");
            WebAPI webAPI = new WebAPI();  //wywołanie metody AnswerOne
            webAPI.currentPriceOfGold(); //metoda playGame

        } else if (answer == 2) {
            System.out.println("Wybrano opcję: 2");
            WebAPI webAPI = new WebAPI();  //wywołanie metody AnswerTwo
            webAPI.historicalGoldPrices(); // metoda Calculator

        }
    }
}
