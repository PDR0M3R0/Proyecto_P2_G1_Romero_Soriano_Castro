package Clases;

/**
 * Representa al cliente que realizará un pedido o consulta.
 */
public class Usuario {
    private String usuario;
    private String contrasena;
    private String nombreApellido;
    
    /**
     * Crea una instancia de la clase Usuario
     * @param usuario
     * @param contrasena
     * @param nombreApellido 
     */
    //Para clientes que tienen tarjeta
    public Usuario(String usuario,String contrasena,String nombreApellido){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombreApellido = nombreApellido;
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
    
    @Override
    public String toString(){
        return usuario + "-" + contrasena + "-" + nombreApellido ;
        
    }
    
    
    
    
}