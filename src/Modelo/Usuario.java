package Modelo;

public class Usuario {
    private String nombre;
    private String apellido;
    private String username;
    private String password;

    public Usuario(String nombre, String apellido, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
    }
}