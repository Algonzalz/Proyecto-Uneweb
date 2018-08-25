package ProyectoHenry.model;

import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

public class PacienteDTO {

    //ATRIBUTOS DEL PACIENTE
    private int id;
    private String nombre;
    private String apellido;
    private char sexo;
    private Date fenac;
    private int edad;
    private float peso;
    private float estatura;
    private float imc;
    private float pgc;

    //CONSTRUCTOR POR DEFECTO VACÍO
    public PacienteDTO() {
    }

    //CONSTRUCTOR QUÉ CONTIENE TODOS LOS ATRIBUTOS, MENOS IMC Y PGC QUE LOS CÁLCULO AL MOMENTO DE EJECUCIÓN
    public PacienteDTO(int id, String nombre, String apellido, char sexo, Date fenac, float peso, float estatura) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fenac = fenac;
        this.peso = peso;
        this.estatura = estatura;
    }

    /*===============================================================
     LOS GETTERS Y SETTERS DE TODOS LOS ATRIBUTOS DEL OBJETO PACIENTE
    ===============================================================*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFenac() {
        return fenac;
    }

    public void setFenac(Date fenac) {
        this.fenac = fenac;
    }

    /*=========================================================================
    EN EL GET DE LA EDAD SACO LA FECHA DEL CALENDARIO, LA PICO EN PEDAZOS PARA 
    SACAR LOS DÍAS EXACTOS Y SE LO RESTO AL AÑO ACTUAL PARA PODER SACAR LA EDAD
    ===========================================================================*/
    public int getEdad(Date fenac) {

        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        int year = cal.get(Calendar.YEAR);

        String fnac = String.valueOf(fenac);
        String nac = fnac.substring(0, 4);
        String nc = String.valueOf(nac);
        int c = Integer.parseInt(nc);
        edad = (year - c);
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    //OBTENGO EL IMC A PARTIR DE LOS DATOS DEL PESO Y LA ESTATURA DADOS, CON LA FORMULA DEL IMC
    public float getImc(float peso, float estatura) {
        imc = (float) (peso / Math.pow(estatura, 2));
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    /*==============================================================================================
    GETTER QUE CON LOS DATOS DE IMC,SEXO Y EDAD, DEPENDIENDO SI ES FEMENINO O MASCULINO OBTENGO 
    UN RESULTADO DE PGC(PORCENTAGE DE GRASA CORPORAL) DISTINTO.
    ===============================================================================================*/
    public float getPgc(float imc, char sexo, int edad) {
        if (sexo == 'f' || sexo == 'F')
        {
            sexo = 0;
        } else if (sexo == 'm' || sexo == 'M')
        {
            sexo = 1;
        }
        pgc = (float) ((1.20 * imc) + (0.23 * edad) - (10.8 * sexo) - 5.4);
        return pgc;
    }

    public void setPgc(float pgc) {
        this.pgc = pgc;
    }

}
