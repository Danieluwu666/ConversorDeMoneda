    import com.google.gson.Gson;

    import java.io.IOException;
    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.util.Scanner;

    public class ConsultarMoneda {


        public String obtenerDatos(int numeroPelicula) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/cb5d89ba571c8515e24e0985/latest/USD"))
                    .build();
            HttpResponse<String> response = null;
            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                System.out.println("Error");
            } catch (InterruptedException e) {
                System.out.println("Error");
            }

            String json = response.body();
            return json;
        }






}









