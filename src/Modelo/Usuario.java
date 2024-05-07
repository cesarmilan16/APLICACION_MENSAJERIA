package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Persona {
    private String username;
    private String password;
    private ArrayList<Amigo> amigos;
    // Atributo estático para guardar todos los usuarios
    private static ArrayList<Usuario> listaUsuariosMensajeria;
    private Scanner scanner;

    public Usuario(String username, String nombre, String apellido, String password) {
        super(nombre, apellido);
        this.username = username;
        this.password = password;
        amigos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Método para guardar todos los usuarios creados
    public static void setListaUsuariosMensajeria(ArrayList<Usuario> listaUsuarios) {
        listaUsuariosMensajeria = listaUsuarios;
    }

    private Amigo buscarAmigo(String username) {
        Amigo amigoEncontrado = null;
        for (Amigo amigo : amigos) {
                if (amigo.getUsername().equals(username)) {
                    amigoEncontrado = amigo;
                }
        }
        return amigoEncontrado;
    }

    private Usuario buscarUsuario(String username) {
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : listaUsuariosMensajeria) {
                if (usuario.getUsername().equals(username)) {
                    usuarioEncontrado = usuario;
                }
        }
        return usuarioEncontrado;
    }

    public void gestionUsuario() {
        boolean salir = false;
        while (!salir) {
            salir = menuGestionUsuario();
        }
    }

    public boolean menuGestionUsuario() {
        boolean salir = false;
        System.out.println("*****************************");
        System.out.println("******* Menu usuario ********");
        System.out.println("*****************************");
        System.out.println("1.- Alta amigo");
        System.out.println("2.- Baja amigo");
        System.out.println("3.- Listado amigo");
        System.out.println("4.- Enviar mensaje a amigos");
        System.out.println("5.- Leer mensajes");
        System.out.println("9.- Logout");
        
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                altaAmigo();
                break;
            case "2":
                bajaAmigo();
                break;
            case "3":
                listadoAmigo();
                break;
            case "4":
                enviarMensaje();
                break;
            case "5":
                leerMensaje();
                break;
            case "9":
                salir = true;
                break;
            default:
                break;
        }
        return salir;
    }

    public void altaAmigo() {
        System.out.println("*****************************");
        System.out.println("******** Alta amigo *********");
        System.out.println("*****************************");
        System.out.println("Introduce username: ");
        String username = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(username);
        Amigo amigoEncontrado = buscarAmigo(username);

        if (usuarioEncontrado != null) {
            if (usuarioEncontrado.getUsername().equals(this.username)) {
                System.out.println("No puedes agregarte a ti mismo.");
            }
            else if (amigoEncontrado == null) {
                String nombre = usuarioEncontrado.getNombre();
                String apellido = usuarioEncontrado.getApellido();
                Amigo amigo = new Amigo(username, nombre, apellido);
                amigos.add(amigo);
                System.out.println("Amigo agregado con exito");
            }
            else {
                System.out.println("Amigo ya agregado");
            }
        }
        else {
            System.out.println("No se encuentra usuario");
        }
    }

    public void bajaAmigo() {
        System.out.println("*****************************");
        System.out.println("******** Baja amigo *********");
        System.out.println("*****************************");
        System.out.println("Introduce username: ");
        String username = scanner.nextLine();


        Amigo amigoEncontrado = buscarAmigo(username);

        if (amigoEncontrado != null) {
            amigos.remove(amigoEncontrado);
            System.out.println("Amigo eliminado correctamente");
        }
        else {
            System.out.println("No se encuentra amigo");
        }
    }

    public void listadoAmigo() {
        System.out.println("*****************************");
        System.out.println("******* Lista amigos ********");
        System.out.println("*****************************");
        if (!amigos.isEmpty()) {
            System.out.println("Amigos de " + username + ": ");
            for (Amigo amigo : amigos) {
                amigo.imprimirAmigo();
            }  
        }
        else {
            System.out.println("No tiene amigos");
        }
    }

    public void enviarMensaje() {

    }

    public void leerMensaje() {

    }
}