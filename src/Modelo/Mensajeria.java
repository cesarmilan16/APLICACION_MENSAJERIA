package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Mensajeria {
    
    private ArrayList<Usuario> usuarios;
    private ArrayList<Usuario> amigos;
    private Scanner scanner = new Scanner(System.in);

    public Mensajeria() {
        usuarios = new ArrayList<>();
        amigos = new ArrayList<>();
    }

    private Usuario buscarUsuario(String username) {
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                usuarioEncontrado = usuario;
            }
        }
        return usuarioEncontrado;
    }

    public void altaUsuario() {
        System.out.println("***************************");
        System.out.println("****** Alta Usuario *******");
        System.out.println("***************************");
        System.out.println("Introduzca username: ");
        String username = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(username);

        if (usuarioEncontrado == null) {
            System.out.println("Nombre usuario: ");
            String nombre = scanner.nextLine();
            System.out.println("Apellido usuario: ");
            String apellido = scanner.nextLine();
            System.out.println("Contraseña usuario: ");
            String password = scanner.nextLine();
            Usuario usuario = new Usuario(username, nombre, apellido, password);
            usuarios.add(usuario);
            System.out.println("Usuario agregado con exito!");
        }
        else {
            System.out.println("Username ya utilizado!");
        }
    }

    public void bajaUsuario() {
        System.out.println("***************************");
        System.out.println("****** Baja Usuario *******");
        System.out.println("***************************");
        System.out.println("Introduzca username: ");
        String username = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(username);

        if (usuarioEncontrado != null) {
            usuarios.remove(usuarioEncontrado);
            System.out.println("Usuario borrado con exito!");
        }
        else {
            System.out.println("No se ha encontrado usuario");
        }
    }

    public void loginLogout() {
        System.out.println("***************************");
        System.out.println("****** Login usuario ******");
        System.out.println("***************************");
        System.out.println("Introduzca username: ");
        String username = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(username);

        if (usuarioEncontrado != null) {
            System.out.println("Introduzca contraseña: ");
            String password = scanner.nextLine();
            if (usuarioEncontrado.getPassword().equals(password)) {
                System.out.println("Accedido al usuario " + username + " correctamente!");;
                usuarioEncontrado.gestionUsuario();
            }
            else {
                System.out.println("Contraseña erronea");
            }         
        }
        else{
            System.out.println("Ese usuario no existe.");
        }
    }
}
