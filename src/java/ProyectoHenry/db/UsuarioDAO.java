package ProyectoHenry.db;

import ProyectoHenry.model.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends DAO {

    /* ========================================================================
    ============================REGISTRAR USUARIO==============================
    ===========================================================================
    1. REGISTRO EN LA BASE DE DATOS EL USUARIO INGRESADO EN EL FORMULARIO 
       DE "REGISTARSE"
    
    =========================================================================*/
    public void registerUS(UsuarioDTO us) {

        createConnection();

        try
        {
            PreparedStatement pst = getCon().prepareStatement("INSERT INTO usuario(usuario,contrasena) VALUES(?,?) ");
            pst.setString(1, us.getUsuario());
            pst.setString(2, us.getPassword());
            pst.execute();
            pst.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            System.out.println("NO SE PUDO REGISTRAR EL USUARIO");
        } finally
        {
            closeConnection();
        }

    }

    /*==========================================================================
    ============================AUTENTICAR USUARIO==============================
    ============================================================================
    2. COMPROBAR SI EL USUARIO INGRESADO EN EL LOGIN EXISTE,  DARLE PERMISOS 
       PARA ACCEDER AL PROGRAMA DEL IMC,SI EL USUARIO EXISTE, DEVUELVE UN OBJETO
       DEL TIPO SUAURIO(ESE MISMO USUARIO INGRESADO), CASO CONTRARIO DEVUELVE 
       NULO.
    
    =========================================================================*/
    public UsuarioDTO authentication(UsuarioDTO us) {
        createConnection();
        ResultSet rs = null;
        PreparedStatement pst = null;

        try
        {
            pst = getCon().prepareStatement("SELECT * FROM usuario");
            rs = pst.executeQuery();

            while (rs.next())
            {
                if ((us.getUsuario()).equals(rs.getString("usuario")) && (us.getPassword()).equals(rs.getString("contrasena")))
                {
                    UsuarioDTO usu = new UsuarioDTO(us.getUsuario(), us.getPassword());
                    return usu;
                }
            }

            rs.close();
            pst.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            System.out.println("NO SE PUDO COMPROBAR EL USUARIO");
        } finally
        {
            closeConnection();
        }

        return null;
    }
    
//    public static void main(String[] args) {
//        UsuarioDTO us=new UsuarioDTO("admin", "admin");
//       new UsuarioDAO().registerUS(us);
//        System.out.println(new UsuarioDAO().authentication(us)); ;
//    }
}
