package Clases;

/**
 *
 * @author pdrb1
 */
public class Usuario {
    private String usuario;
    private String contrasena;
    private String nombreApellido;
    
      
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

