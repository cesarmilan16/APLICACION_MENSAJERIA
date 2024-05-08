package Modelo;

import java.util.ArrayList;

public class Conversacion {
    private Usuario origenUsuario;
    private Amigo destinoAmigo;
    private ArrayList<String> mensajes;
    private static ArrayList<Conversacion> conversaciones = new ArrayList<>();

    public Conversacion(Usuario origenUsuario, Amigo destinoAmigo) {
        this.origenUsuario = origenUsuario;
        this.destinoAmigo = destinoAmigo;
        mensajes = new ArrayList<>();
    }

    public Usuario getOrigenUsuario() {
        return this.origenUsuario;
    }

    public Amigo getDestinoAmigo() {
        return this.destinoAmigo;
    }

    public void agregarMensaje(String mensaje) {
        mensajes.add(mensaje);
    }

    public static void mostrarMensajes(Usuario usuario, Amigo amigo) {
        for (Conversacion conversacion : conversaciones) {
            if (conversacion.origenUsuario.equals(usuario) && conversacion.destinoAmigo.equals(amigo)) {
                System.out.println(usuario.getUsername() + ": ");
                for (String mensaje : conversacion.mensajes) {
                    System.out.println(mensaje);
                }
            }
        }
    }

    public static Conversacion buscarConversacion(Usuario usuario, Amigo amigo) {
        for (Conversacion conversacion : conversaciones) {
            if (conversacion.origenUsuario.equals(usuario) && conversacion.destinoAmigo.equals(amigo)) {
                return conversacion;
            }
        }
        return null;
    }

    public static void agregarConversacion(Usuario usuario, Amigo amigoEncontrado) {
        Conversacion conversacion = new Conversacion(usuario, amigoEncontrado);
        conversaciones.add(conversacion);
    }
}