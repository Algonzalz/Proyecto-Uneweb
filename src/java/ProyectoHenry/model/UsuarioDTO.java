package ProyectoHenry.model;

/*=============================================================================
CREO UNA CLASE USUARIO PARA INGRESAR AL PROGRAMA MEDIANTE UN LOGIN SENCILLO,
SIN CONTROL DE SESION, SOLO PARA INGRESAR AL PROGRAMA, CREANDO SUS RESPECTIVOS 
GETTERS Y SETTERS Y SUS CONSTRUCTORES.
==============================================================================*/
public class UsuarioDTO {
    private String usuario;
    private String password;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
   public String getUsuario(){
       return usuario;
   }
   
   public void setUsuario(String usuario){
       this.usuario = usuario;
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
   
}
