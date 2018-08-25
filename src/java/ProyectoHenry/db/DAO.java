package ProyectoHenry.db;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    //PREPARO LA CONEXIÓN A LA BASE DE DATOS
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USS = "root";
    private static final String PASS = "";
    private static final String URL = "jdbc:mysql://localhost:3306/servicioweb?useServerPrepStmts=true";
    static final String TABLE_NAME = "paciente";

    /* 1. PREPARO EL OBJETO QUE VOY A USAR EN LAS CONEXIONES*/
    private  Connection con = null;

    /*CREO LOS GETTERS Y SETTERS PARA EL OBJETO CONNECTION*/
    public Connection getCon() {
        return con;
    }

    public  void setCon(Connection con) {
        this.con = con;
    }

    //COLOCO EL MÉTODO PARA CONECTARME A LA BASE DE DATOS
    public void createConnection() {

        try
        {
            Class.forName(DRIVER);

            con = DriverManager.getConnection(URL, USS, PASS);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Conexión establecida");
        }
    }
    //HAGO EL MÉTODO PARA CERRAR LA CONEXIÓN
    public  void closeConnection() {
        try
        {
            if (con != null)
            {
                if (con.isClosed() == false)
                {
                    con.close();
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("NO SE CERRÓ LA CONEXIÓN");
        }
    }
}
