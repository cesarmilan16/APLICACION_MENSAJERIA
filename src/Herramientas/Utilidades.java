package Herramientas;

import java.util.Scanner;

public class Utilidades {
    

    static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String dato) {
        while (true) {
            try{
                System.out.println("Introduzca " + dato + ": ");
                String datoLeido = scanner.nextLine();
                int datoNum = Integer.parseInt(datoLeido);
                return datoNum;
            }
            catch (Exception e) {
                System.out.println("Valor erroneo");
            }
        }
    }

    public static String leerString(String dato) {
        System.out.println("Introduzca " + dato + ": ");
        String stringLeido = scanner.nextLine();
        return stringLeido;
    }
}
