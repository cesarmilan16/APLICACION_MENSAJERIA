import java.util.Scanner;

import Modelo.Mensajeria;

public class App {

    Mensajeria mensajeria = new Mensajeria();
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
        System.out.println("1.- Alta equipo");
        System.out.println("2.- Baja equipo");
        System.out.println("3.- Gestión equipo");
        System.out.println("4.- Lista de los jugadores más altos");
        System.out.println("5.- Lista ordenada de entrenadores");
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
            case "4":
                mensajeria.gestionAmigos();
                break;
            case "5":
                mensajeria.envioMensaje();
                break;
            case "6":
                mensajeria.lecturaMensaje();
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