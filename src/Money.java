
import com.google.gson.annotations.SerializedName;

import java.util.Scanner;

public class Money {


    private double conversion;

    public Money(double conversion) {
        this.conversion = conversion;

    }

    public Money (Moneda moneda) { //constructor que recibe como parametro a miTituloOMDB
        this.conversion=Double.parseDouble(moneda.conversion_rate());

    }

    public double getConversion() {
        return conversion;
    }

    public void CalcularValor(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea convertir: ");
        double numeroValor = teclado.nextDouble();

        double resultado= conversion*numeroValor;
        System.out.println(resultado);
    }




}
