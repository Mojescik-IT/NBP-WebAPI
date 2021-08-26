import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import java.util.Scanner;

public class WebAPI {

    //public static void main(String[] args) {

    void currentPriceOfGold() {

        //Method 2 java.net..http.HttpClient  in Java 11
        HttpClient client = HttpClient.newHttpClient();
        //HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://api.nbp.pl/api/cenyzlota/last/1/?format=json")).build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.nbp.pl/api/cenyzlota/today/?format=json")).build(); //ceny złota dziś lub brak danych
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(WebAPI::parse)
                .join();
    }

    //parser
    public static String parse(String responseBody) {
        JSONArray pricesOfGold = new JSONArray(responseBody);
        for (int i = 0; i < pricesOfGold.length(); i++) {
            JSONObject priceOfGold = pricesOfGold.getJSONObject(i);
            String data = priceOfGold.getString("data");
            double cena = priceOfGold.getDouble("cena");

            // Numeracja każdego pobranego wpisu - ID
            int id = i + 1;
            if (id == i) {
                i++;
            }
            // wypisywanie rezultatów
            System.out.println("Cena złota wynosi: \n" + id + ". " + data + " - " + cena + " PLN");
        }
        return null;
    }


    void historicalGoldPrices() {
        int numberOfEntries; //ilośc zwracanych wpisów z historii



        Scanner answer = new Scanner(System.in);


        System.out.print("Wybierz ilość historycznych wpisów: ");
        numberOfEntries = answer.nextInt();

        String urlAddress = "http://api.nbp.pl/api/cenyzlota/last/" + numberOfEntries + "/?format=json";


        //Method 2 java.net..http.HttpClient  in Java 11
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlAddress)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(WebAPI::parse2)
                .join();
    }

    //parser
    public static String parse2(String responseBody) {
        JSONArray pricesOfGold = new JSONArray (responseBody);
        for (int i = 0; i < pricesOfGold.length(); i++) {
            JSONObject priceOfGold = pricesOfGold.getJSONObject(i);
            String data = priceOfGold.getString("data");
            double cena = priceOfGold.getDouble("cena");

            // Numeracja każdego pobranego wpisu - ID
            int id = i + 1;
            if (id == i) {
                i++;
            }
            // wypisywanie rezultatów
            System.out.println(" Cena złota z dnia : " + data + " wynosi :" + "\n" + id + ". " + cena + " PLN");
        }
        return null;
    }



    void historicalGoldPricesRange() {
        String startDate; //ilośc zwracanych wpisów z historii
        String endDate; //ilośc zwracanych wpisów z historii



        Scanner answer1 = new Scanner(System.in);
        Scanner answer2 = new Scanner(System.in);

        System.out.print("Wybierz zakres OD (data w formacie rrrr-mm-dd: ");
        startDate = answer1.next();

        System.out.print("Wybierz zakres DO (data w formacie rrrr-mm-dd: ");
        endDate = answer2.next();




        String urlAddress = "http://api.nbp.pl/api/cenyzlota/" + startDate + "/" + endDate + "/?format=json";
        //String urlAddress = "http://api.nbp.pl/api/cenyzlota/2021-08-20/2021-08-25/?format=json";


        //Method 2 java.net..http.HttpClient  in Java 11
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlAddress)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(WebAPI::parse3)
                .join();
    }

    //parser
    public static String parse3(String responseBody) {
        JSONArray pricesOfGold = new JSONArray (responseBody);
        for (int i = 0; i < pricesOfGold.length(); i++) {
            JSONObject priceOfGold = pricesOfGold.getJSONObject(i);
            String data = priceOfGold.getString("data");
            double cena = priceOfGold.getDouble("cena");

            // Numeracja każdego pobranego wpisu - ID
            int id = i + 1;
            if (id == i) {
                i++;
            }
            // wypisywanie rezultatów
            System.out.println(" Cena złota z dnia : " + data + " wynosi :" + "\n" + id + ". " + cena + " PLN");
        }
        return null;
    }



}



