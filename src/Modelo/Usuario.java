package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

import Herramientas.Utilidades;

public class Usuario {
    private RedSocial red;
    private String username;
    private String nombre;
    private String apellido;
    private String password;
    private ArrayList<Usuario> amigos = new ArrayList<>();
    private ArrayList<Mensaje> mensajes = new ArrayList<>();


    public Usuario(RedSocial red, String username, String nombre, String apellido, String password) {
        this.red = red;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    private String getUsername() {
        return username;
    }

    private void imprimirUsuario() {
        System.out.println("Usuario:");
        System.out.println("Username: " + username);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("------------------------");
    }

    private Usuario buscarAmigo(String username) {
        Usuario amigoEncontrado = null;
        for (Usuario amigo : amigos) {
                if (amigo.getUsername().equals(username)) {
                    amigoEncontrado = amigo;
                }
        }
        return amigoEncontrado;
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
        
        String opcion = Utilidades.leerString("opción");

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
        String username = Utilidades.leerString("username");

        Usuario usuarioEncontrado = red.buscarUsuario(username);
        Usuario amigoEncontrado = buscarAmigo(username);

        if (usuarioEncontrado != null) {
            if (usuarioEncontrado.getUsername().equals(this.username)) {
                System.out.println("No puedes agregarte a ti mismo.");
            }
            else if (amigoEncontrado == null) {
                amigos.add(usuarioEncontrado);
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
        String username = Utilidades.leerString("username");


        Usuario amigoEncontrado = buscarAmigo(username);

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
            for (Usuario amigo : amigos) {
                amigo.imprimirUsuario();
            }  
        }
        else {
            System.out.println("No tiene amigos");
        }
    }

    public void enviarMensaje() {
        System.out.println("*****************************");
        System.out.println("****** Enviar mensaje *******");
        System.out.println("*****************************");
        System.out.println("Introduce username de tu amigo a quien enviar mensaje: ");
        String username = Utilidades.leerString("username");

        Usuario amigoEncontrado = buscarAmigo(username);

        if (amigoEncontrado != null) {
            System.out.println("Introduce mensaje: ");
            String mensaje = Utilidades.leerString("mensaje");
            amigoEncontrado.mensajes.add(new Mensaje(mensaje, this));
        }
        else {
            System.out.println("Amigo no encontrado");
        }
    }



    public void leerMensaje() {
        System.out.println("*****************************");
        System.out.println("******* Leer mensajes *******");
        System.out.println("*****************************");
        System.out.println("Introduce username de tu amigo a quien leer sus mensajes: ");
        String username = scanner.nextLine();

        Amigo amigoEncontrado = buscarAmigo(username);

        if (amigoEncontrado != null) {
            Conversacion conversacionUsuario = Conversacion.buscarConversacion(this, amigoEncontrado);
            if (conversacionUsuario != null){
                System.out.println("Mensajes de " + amigoEncontrado.getUsername() + ": ");
                Conversacion.mostrarMensajes(this, amigoEncontrado);
            }
            else {
                System.out.println("No hay conversaciones disponibles con " + amigoEncontrado.getUsername());
            }
        }
        else {
            System.out.println("Amigo no encontrado");
        }
    }
}

/*
El amigo debe ser clase usuario
en vez de conversacion tiene que ser mensaje con su texto y su usuario
 */