import java.util.Scanner;

import Modelo.Mensajeria;

public class App {

    public static Mensajeria mensajeria = new Mensajeria();
    public static void main(String[] args) throws Exception {
        boolean salir = false;
        while (!salir) {
            salir = mostraMenuPrincipal();
        }
    }

    private static boolean mostraMenuPrincipal(){
        boolean salir = false;
        System.out.println("*****************************");
        System.out.println("*******Menu principal********");
        System.out.println("*****************************");
        System.out.println("1.- Alta usuario");
        System.out.println("2.- Baja usuario");
        System.out.println("3.- Login/Logout del usuario");
        System.out.println("9.- Salir");
        
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                mensajeria.altaUsuario();
                break;
            case "2":
                mensajeria.bajaUsuario();
                break;
            case "3":
                mensajeria.loginLogout();
                break;
            case "9":
                salir = true;
                scanner.close();
                break;
            default:
                break;
        }
        return salir;
    }
}