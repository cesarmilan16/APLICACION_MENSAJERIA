package Modelo;

import java.util.ArrayList;

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

    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    private void imprimirUsuario() {
        System.out.println();
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
        System.out.println("6.- Responder mensajes");
        System.out.println("7.- Listar mensajes no leidos");
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
            case "6":
                responderMensaje();
                break;
            case "7":
                listarMensajesNoLeidos();
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
        String username = Utilidades.leerString("username de tu amigo");

        Usuario amigoEncontrado = buscarAmigo(username);

        if (amigoEncontrado != null) {
            String texto = Utilidades.leerString("mensaje");
            amigoEncontrado.mensajes.add(new Mensaje(texto, this));
        }
        else {
            System.out.println("Amigo no encontrado");
        }
    }



    public void leerMensaje() {
        for (Mensaje mensaje : mensajes) {
            mensaje.escribirMensaje();
            mensaje.setLeido(true);
        }
    }

    private void responderMensaje() {
        // Si no tiene mensajes salta el siguiente texto
        if (mensajes.isEmpty()) {
            System.out.println("No tienes mensajes para responder.");
            return;
        }
    
        System.out.println("*****************************");
        System.out.println("***** Responder mensaje *****");
        System.out.println("*****************************");
    
        // Mostrar mensajes para responder con un indice
        System.out.println("Mensajes:");
        int index = 1;
        for (Mensaje mensaje : mensajes) {
            System.out.println(index);
            mensaje.escribirMensaje();
            index++;
        }
        
        // Elegimos el número del mensaje que queremos responder
        int opcion = Utilidades.leerEntero("el número de mensaje que quiere responder");
        Mensaje mensajeSeleccionado = null;
        int contador = 1;
        while (mensajeSeleccionado == null && contador < mensajes.size()) {
            if (contador == opcion) {
                mensajeSeleccionado = mensajes.get(contador);
            }
            contador++;
        }

        // Escribimos el mensaje de respuesta
        String respuesta = Utilidades.leerString("su respuesta");

        // Si existe el mensaje agregaremos el nuevo mensaje
        if (mensajeSeleccionado != null) {
            mensajeSeleccionado.getDe().mensajes.add(new Mensaje(respuesta, mensajeSeleccionado.getDe()));
            System.out.println("Mensaje respondido con exito!");
        }
        // Si no mostrará lo siguiente
        else {
            System.out.println("No se ha encontrado el mensaje");
        }

    }

    // Método para listar los mensajes no leidos
    private void listarMensajesNoLeidos() {
        for (Mensaje mensaje : mensajes) {
            // Solo mostrará los mensajes no leidos
            if (!mensaje.isLeido()) {
                mensaje.escribirMensaje();
            }
        }
    }

}