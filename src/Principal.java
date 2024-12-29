import com.google.gson.Gson;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        while (true) {
            try {

                System.out.println("*************************************");
                System.out.println("Bienvenido/a al conversor de moneda :)");
                System.out.println("");
                System.out.println("1) Dólar =>> Peso argentino");
                System.out.println("2) Peso argentino =>> Dólar");
                System.out.println("3) Dólar =>> Real brasileño");
                System.out.println("4) Real brasileño =>> Dólar");
                System.out.println("5) Dólar =>> Peso colombiano");
                System.out.println("6) Peso colombiano =>> Dólar");
                System.out.println("7) Salir");
                System.out.println("");
                System.out.println("Elija una opción válida: ");
                int numero = teclado.nextInt();



                // Obtener los datos de la API
                Moneda moneda = consulta.obtenerDatos(numero);
                if (moneda == null) {
                    System.out.println("No se pudo obtener la tasa de conversión.");
                    continue;
                }


                System.out.println("Ingrese el valor que desea convertir: ");

                double valorUsuario = teclado.nextDouble();
                // Realizar la conversión
                double conversionRate = Double.parseDouble(moneda.conversion_rate());
                double resultado = conversionRate * valorUsuario;
                String monedaBase= moneda.base_code();
                String monedaFinal=moneda.target_code();
                // Mostrar el resultado
                System.out.println("El resultado de la conversión de "+valorUsuario+" "+monedaBase+" corresponde a: "+ resultado +" "+monedaFinal);
            }catch (NumberFormatException e){
                System.out.println("Valor invalido");
            }catch (Exception e){
                System.out.println("Algo anda mal "+e.getMessage());
            }


                teclado.nextLine();

        }
    }
}

