package Modelo;

import java.util.ArrayList;

import Herramientas.Utilidades;

public class RedSocial {
    
    private ArrayList<Usuario> usuarios;

    public RedSocial() {
        usuarios = new ArrayList<>();
    }

    public Usuario buscarUsuario(String username) {
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
        String username = Utilidades.leerString("username");

        Usuario usuarioEncontrado = buscarUsuario(username);

        if (usuarioEncontrado == null) {
            System.out.println("Nombre usuario: ");
            String nombre = Utilidades.leerString("nombre");
            System.out.println("Apellido usuario: ");
            String apellido = Utilidades.leerString("apellido");
            System.out.println("Contraseña usuario: ");
            String password = Utilidades.leerString("contraseña");
            usuarios.add(new Usuario(this, username, nombre, apellido, password));
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
        String username = Utilidades.leerString("username");

        Usuario usuarioEncontrado = buscarUsuario(username);

        if (usuarioEncontrado != null) {
            usuarios.remove(usuarioEncontrado);
            System.out.println("Usuario borrado con exito!");
        }
        else {
            System.out.println("No se ha encontrado usuario");
        }
    }

    public void login() {
        System.out.println("***************************");
        System.out.println("****** Login usuario ******");
        System.out.println("***************************");
        System.out.println("Introduzca username: ");
        String username = Utilidades.leerString("username");

        Usuario usuarioEncontrado = buscarUsuario(username);

        if (usuarioEncontrado != null) {
            System.out.println("Introduzca contraseña: ");
            String password = Utilidades.leerString("contraseña");
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