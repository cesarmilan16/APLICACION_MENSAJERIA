package Modelo;

import java.util.ArrayList;

public class Conversacion {
    private Usuario origenUsuario;
    private Amigo destinoAmigo;
    private ArrayList<String> mensajes;

    public Conversacion(Usuario origenUsuario, Amigo destinoAmigo, String mensaje) {
        this.origenUsuario = origenUsuario;
        this.destinoAmigo = destinoAmigo;
        mensajes = new ArrayList<>();
    }
    
    public void agregarMensaje(String mensaje) {
        mensajes.add(mensaje);
    }

    public void mostrarMensaje() {
        for (String mensaje : mensajes) {
            System.out.println(destinoAmigo.getUsername() + ": " + mensaje);            
        }
    }

    public Amigo getAmigo() {
        return this.destinoAmigo;
    }

    public Usuario getUsuario() {
        return this.origenUsuario;
    }
}