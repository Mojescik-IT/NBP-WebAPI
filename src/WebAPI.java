import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebAPI {

    public static void main(String[] args) {

//Method 2 java.net..http.HttpClient  in Java 11

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://api.nbp.pl/api/cenyzlota/last/5/?format=json")).build();
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


            System.out.println(data + " - " + cena + " PLN");

        }
        return null;

    }

}




