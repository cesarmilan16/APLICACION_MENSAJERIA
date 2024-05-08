import Herramientas.Utilidades;
import Modelo.RedSocial;

public class App {

    public static RedSocial mensajeria = new RedSocial();
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
        System.out.println("3.- Login del usuario");
        System.out.println("9.- Salir");
        
        String opcion = Utilidades.leerString("opción");

        switch (opcion) {
            case "1":
                mensajeria.altaUsuario();
                break;
            case "2":
                mensajeria.bajaUsuario();
                break;
            case "3":
                mensajeria.login();
                break;
            case "9":
                salir = true;
                break;
            default:
                break;
        }
        return salir;
    }
}