package ProyectoHenry.db;

import ProyectoHenry.model.PacienteDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO extends DAO {

    /* ========================================================================
    ============================INSERTAR PACIENTE==============================
    ===========================================================================
    1. CREO EL MÉTODO INSERTAR PACIENTE, QUE TOMO POR PARÁMETRO UN OBEJTO 
       PACIENTEDTO AL CUAL LO INSERTO A LA BASE DE DATOS.
    
       1.1 USO PREPARE STATEMENT PARA TENER UNA LIGERA VENTAJA EN SEGURIDAD 
           Y EN VELOCIDAD, PORQUE YA PRECOMPILA LA SENTENCIA SQL 
    
    =========================================================================*/
    public void insertPac(PacienteDTO p) {

        createConnection();
        try
        {
            PreparedStatement pst = getCon().prepareStatement("INSERT INTO " + TABLE_NAME + " (id, nombre, apellido, sexo, fenac, peso, estatura) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, p.getId());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getApellido());
            pst.setString(4, String.valueOf(p.getSexo()));
            pst.setDate(5, p.getFenac());
            pst.setFloat(6, p.getPeso());
            pst.setFloat(7, p.getEstatura());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Persona no ingresada.");

        } finally
        {
            closeConnection();
        }

    }

    /*=========================================================================
    ==========================LISTAR PACIENTES=================================
    ===========================================================================
    2. SE CREA LA CONEXION Y SE PREPARA LA SETENCIA SQL.
    
    2.1 SE GUARDA EN UN OBJETO RESULTSET LA SENTENCIA OBTENIDA.
    
    2.2 SE INTERROGA EL RESULTSET Y SE MANDA CADA DATO A UN OBJETO PACIENTE
        PARA GUARDARLO EN UN ARRAYLIST DE TIPO PACIENTE.
    ==========================================================================*/
    public List<PacienteDTO> selectPacs() {
        List<PacienteDTO> arrP = new ArrayList<>();
        createConnection();

        try
        {
            ResultSet rs;
            PreparedStatement pst = getCon().prepareStatement("SELECT * FROM " + TABLE_NAME);
            rs = pst.executeQuery();

            while (rs.next())
            {
                PacienteDTO p = new PacienteDTO();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setSexo(rs.getString("sexo").charAt(0));
                p.setFenac(rs.getDate("fenac"));
                p.setPeso(rs.getFloat("peso"));
                p.setEstatura(rs.getFloat("estatura"));
                arrP.add(p);
            }

            rs.close();
            pst.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("No LISTÓ LA BASE DE DATOS");
        } finally
        {
            closeConnection();
        }

        return arrP;
    }

    /*=========================================================================
    ==========================CONSULTAR PACIENTES==============================
    ===========================================================================
    3.  SE INGRESA POR PARAMETRO UN ID DE UN PACIENTE YA INGRESADO ANTERIORMENTE  Y 
        SE INSTANCIA UN OBJETO DE PACIENTE.
    
    3.1 CREO LA CONEXION, CREO OBJETO RESULTSET Y PREPARESTATEMENT, 
        EJECUTO LA SENTENCIA DE CONSULTA.
    
    3.2 RECORRO EL RESULTSET Y LO GUARDO EN UN OBJETO, PARA LUEGO RETORNARLO.
    ==========================================================================*/
    public PacienteDTO selectById(PacienteDTO p) {

        PacienteDTO p2 = null;

        createConnection();
        try
        {
            ResultSet rs;
            PreparedStatement pst = getCon().prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id= ?");
            pst.setInt(1, p.getId());
            rs = pst.executeQuery();

            while (rs.next())
            {
                p2 = new PacienteDTO();
                p2.setId(rs.getInt("id"));
                p2.setNombre(rs.getString("nombre"));
                p2.setApellido(rs.getString("apellido"));
                p2.setSexo(rs.getString("sexo").charAt(0));
                p2.setFenac(rs.getDate("fenac"));
                p2.setPeso(rs.getFloat("peso"));
                p2.setEstatura(rs.getFloat("estatura"));

                rs.close();
                pst.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("FALLÓ LA CONSULTA POR ID");
        } finally
        {
            closeConnection();
        }

        return p2;
    }

    /*=========================================================================
    ==========================MODIFICAR PACIENTES==============================
    ===========================================================================
    4. CREO LA CONEXION Y RECIBO POR PARÁMETRO UN OBJETO DE TIPO PACIENTEDTO
    
    4.1 PREPARO LA SENTENCIA DE MODIFICAR(UPDATE) POR LOS CAMPOS Y SETEO 
        AL PREPARED LOS CAMPOS QUE QUIERO MODIFICAR

    ==========================================================================*/
    public void modifyPac(PacienteDTO p) {

        createConnection();
        try
        {
            PreparedStatement pst = getCon().prepareStatement("UPDATE " + TABLE_NAME + " SET nombre= ?, apellido= ?, sexo= ?, fenac= ?, peso= ?, estatura= ? WHERE id= ?");
            pst.setInt(7, p.getId());
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellido());
            pst.setString(3, String.valueOf(p.getSexo()));
            pst.setDate(4, p.getFenac());
            pst.setFloat(5, p.getPeso());
            pst.setFloat(6, p.getEstatura());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Persona no modificada.");

        } finally
        {
            closeConnection();
        }

    }

    /*=========================================================================
    ==========================ELIMINAR PACIENTES==============================
    ===========================================================================
    5. CREO LA CONEXION Y RECIBO POR PARÁMETRO UN OBJETO DE TIPO PACIENTEDTO
    
    5.1 PREPARO LA SENTENCIA DE ELIMINAR(DELETE) POR LOS CAMPOS Y SETEO 
        AL PREPARED EL ID DEL OBJET QUE QUIERO MODIFICAR

    ==========================================================================*/
    public void removePac(PacienteDTO p) {

        createConnection();
        try
        {
            PreparedStatement pst = getCon().prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id= ?");
            pst.setInt(1, p.getId());
            pst.execute();
            pst.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Persona no eliminada.");

        } finally
        {
            closeConnection();
        }

    }

}
