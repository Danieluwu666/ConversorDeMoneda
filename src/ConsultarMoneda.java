    import com.google.gson.Gson;

    import java.io.IOException;
    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.util.Scanner;

    public class ConsultarMoneda {
            URI direccion;

        public Moneda obtenerDatos(int opcion) {

            switch (opcion) {
                case 1:
                    direccion = URI.create("https://v6.exchangerate-api.com/v6/cb5d89ba571c8515e24e0985/pair/USD/ARS");
                    break;
                case 2:
                    direccion=URI.create("https://v6.exchangerate-api.com/v6/cb5d89ba571c8515e24e0985/pair/ARS/USD");
                    break;
                case 3:
                    direccion=URI.create("https://v6.exchangerate-api.com/v6/cb5d89ba571c8515e24e0985/pair/USD/BRL");
                    break;
                case 4:
                    direccion=URI.create("https://v6.exchangerate-api.com/v6/cb5d89ba571c8515e24e0985/pair/BRL/USD");
                    break;
                case 5:
                    direccion=URI.create("https://v6.exchangerate-api.com/v6/cb5d89ba571c8515e24e0985/pair/USD/COP");
                    break;
                case 6:
                    direccion=URI.create("https://v6.exchangerate-api.com/v6/cb5d89ba571c8515e24e0985/pair/COP/USD");
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor");
                    System.exit(0);
                    break;
                default:
                    System.out.println("opcion no valida");
            }
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();



            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                return new Gson().fromJson(response.body(), Moneda.class);

            } catch (Exception e) {
                throw new RuntimeException("No encontré datos");

            }




        }


}









