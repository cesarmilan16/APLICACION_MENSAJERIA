package Modelo;


public class Usuario {
    private String username;
    private String nombre;
    private String apellido;
    private String password;

    public Usuario(String username, String nombre, String apellido, String password) {
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void gestionUsuario() {
        
    }
}