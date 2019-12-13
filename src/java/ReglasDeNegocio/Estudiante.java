
package ReglasDeNegocio;
import AccesoADatos.Comando;
import AccesoADatos.Conexion;
import AccesoADatos.Global;
import AccesoADatos.Parametro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author marco
 */
public class Estudiante {
    
    private int estudianteid ;
    private String nombre;
    private String apellido;
    private String cedula;
    private Programa programa;
    private String fecha;

    public Estudiante() {
    }

    public Estudiante(int estudianteid, String nombre, String apellido, String cedula, Programa programa, String fecha) {
        this.estudianteid = estudianteid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.programa = programa;
        this.fecha = fecha;
    }

    public int getEstudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(int estudianteid) {
        this.estudianteid = estudianteid;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
   
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    // CRUDs para la tabla estudiante
   // Estudiante buscar todos
    
    public static ArrayList<Estudiante> estudiante_buscartodos() throws Exception
    {
        //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Estudiante> lista= new ArrayList<Estudiante>();
       Estudiante obj= new Estudiante();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from public.estudiante_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatEstudianteement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Estudiante();
              obj.setEstudianteid(rs.getInt("pestudianteid"));
              obj.setNombre(rs.getString("pnombre"));
              obj.setApellido(rs.getString("papellido"));
              obj.setCedula(rs.getString("pcedula"));
              Programa programa = new Programa();
              Programa programas = programa.programa_buscarporid(rs.getInt("pprogramaid"));
              obj.setPrograma(programas);
              obj.setFecha(rs.getString("pfecha"));
              lista.add(obj);
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      finally
      {
          rs.close();
          preStm.close();
          con.desconectar();
      }
            return lista;

    }
    
    // Buscar por id Estudiante
    public static Estudiante estudiante_buscarporid(int piestudianteid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
        ArrayList<Estudiante> lista= new ArrayList<Estudiante>();
          Estudiante obj= new Estudiante();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.estudiante_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, piestudianteid);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj = new Estudiante();
              obj.setEstudianteid(rs.getInt("pestudianteid"));
              obj.setNombre(rs.getString("pnombre"));
              obj.setApellido(rs.getString("papellido"));
              obj.setCedula(rs.getString("pcedula"));
              Programa programa= new Programa();
              Programa programas = programa.programa_buscarporid(rs.getInt("pprogramaid"));
              obj.setPrograma(programas);
              obj.setFecha(rs.getString("pfecha"));
              lista.add(obj);
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      finally
      {
          rs.close();
          preStm.close();
          con.desconectar();
      }
            return obj;

    }
    
    // Intertar datos Estudiante
    
    public static boolean estudiante_insertar(Estudiante estudiante) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.estudiante_insertar(?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          
          parametros.add(new Parametro(1, estudiante.getNombre()));
          parametros.add(new Parametro(2, estudiante.getApellido()));
          parametros.add(new Parametro(3, estudiante.getCedula()));
          parametros.add(new Parametro(4, estudiante.getPrograma().getProgramaid()));
          parametros.add(new Parametro(5, estudiante.getFecha()));
          //llenar el comando con los parametros
          cmd.setLstParametros(parametros);
          comandos.add(cmd);
          //llamamos al funcion que ejecuta la transaccion en la base de datos
          respuesta= con.ejecutaPreparedTransaccion(comandos);

      } catch (SQLException e) {
          throw  new Exception(e.getMessage());
      }
      finally
      {
          con.desconectar();
      }
      return respuesta;

  }
    
    // Editar datos estudiante
    public static boolean estudiante_editar(Estudiante estudinate) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.estudiante_editar(?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros

          parametros.add(new Parametro(1, estudinate.getEstudianteid()));
          parametros.add(new Parametro(2, estudinate.getNombre()));
          parametros.add(new Parametro(3, estudinate.getApellido()));
          parametros.add(new Parametro(4, estudinate.getCedula()));
          parametros.add(new Parametro(5, estudinate.getPrograma().getProgramaid()));
          parametros.add(new Parametro(6, estudinate.getFecha()));
          
          //llenar el comando con los parametros
          cmd.setLstParametros(parametros);
          comandos.add(cmd);
          //llamamos al funcion que ejecuta la transaccion en la base de datos
          respuesta= con.ejecutaPreparedTransaccion(comandos);

      } catch (SQLException e) {
          throw  new Exception(e.getMessage());
      }
      finally
      {
          con.desconectar();
      }
      return respuesta;

  }
    
    //Eliminar datos Estudiante
     public static boolean estudiante_eliminar(int piestudianteid) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.estudiante_eliminar(?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, piestudianteid));
          //llenar el comando con los parametros
          cmd.setLstParametros(parametros);
          comandos.add(cmd);
          //llamamos al funcion que ejecuta la transaccion en la base de datos
          respuesta= con.ejecutaPreparedTransaccion(comandos);

      } catch (SQLException e) {
          throw  new Exception(e.getMessage());
      }
            finally
      {
          con.desconectar();
      }
      return respuesta;

  }

     // Buscar usuarios que se encuentren registrados
    
     public static Estudiante estudiante_buscar_por_credenciales(String pinombre_usuario, String picontrasenia) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Estudiante> lista= new ArrayList<Estudiante>();
       Estudiante obj= new Estudiante();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.estudiante_buscar_por_credenciales(?,?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          preStm.setString(1, pinombre_usuario);
          preStm.setString(2, picontrasenia);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Estudiante();
              obj.setEstudianteid(rs.getInt("pestudianteid"));
              obj.setNombre(rs.getString("pnombre"));
              obj.setApellido(rs.getString("papellido"));
              obj.setCedula(rs.getString("pcedula"));
              Programa programa= new Programa();
              Programa programas = programa.programa_buscarporid(rs.getInt("pprogramaid"));
              obj.setPrograma(programas);
              obj.setFecha(rs.getString("pfecha"));
              lista.add(obj);
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      finally
      {
          rs.close();
          preStm.close();
          con.desconectar();
      }
            return obj;

    }
     
     
    
    
}
