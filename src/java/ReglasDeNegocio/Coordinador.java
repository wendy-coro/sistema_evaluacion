package ReglasDeNegocio;

import AccesoADatos.Comando;
import AccesoADatos.Conexion;
import AccesoADatos.Global;
import AccesoADatos.Parametro;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Coordinador {
    
    private int coordinadorid;
    private String nombre;
    private String apellido;
    private String cedula;
    private Programa programa;
    private String fecha;

    public Coordinador() {
    }

    public Coordinador(int coordinadorid, String nombre, String apellido, String cedula, Programa programa, String fecha) {
        this.coordinadorid = coordinadorid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.programa = programa;
        this.fecha = fecha;
    }

    public int getCoordinadorid() {
        return coordinadorid;
    }

    public void setCoordinadorid(int coordinadorid) {
        this.coordinadorid = coordinadorid;
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
    
     @Override 
    public String toString(){
        return nombre;
    }
    // Buscar todos
    public static ArrayList<Coordinador> coordinador_buscartodos() throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Coordinador> lista= new ArrayList<Coordinador>();
       Coordinador obj= new Coordinador();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from public.coordinador_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Coordinador();
              obj.setCoordinadorid(rs.getInt("pcoordinadorid"));
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
    
    // Coordinador buscar por su id
    
    public static Coordinador coordinador_buscarporid(int picoordinadorid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Coordinador> lista= new ArrayList<Coordinador>();
       Coordinador obj= new Coordinador();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.coordinador_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, picoordinadorid);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj = new Coordinador();
              obj.setCoordinadorid(rs.getInt("pcoordinadorid"));
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
    
    //Insertar Coordinador
    public static boolean coordinador_insertar(Coordinador coordinador) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.coordinador_insertar(?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, coordinador.getNombre()));
          parametros.add(new Parametro(2, coordinador.getApellido()));
          parametros.add(new Parametro(3, coordinador.getCedula()));
          parametros.add(new Parametro(4, coordinador.getPrograma().getProgramaid()));
          parametros.add(new Parametro(5, coordinador.getFecha())); 
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

   // Editar datos Coordinador
    public static boolean coordinador_editar(Coordinador coordinador) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.coordinador_editar(?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros

          parametros.add(new Parametro(1, coordinador.getCoordinadorid()));
          parametros.add(new Parametro(2, coordinador.getNombre()));
          parametros.add(new Parametro(3, coordinador.getApellido()));
          parametros.add(new Parametro(4, coordinador.getCedula()));
          parametros.add(new Parametro(5, coordinador.getPrograma().getProgramaid()));
          parametros.add(new Parametro(6, coordinador.getFecha()));
        
          
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
    
     //Eliminar datos Coordinador
     public static boolean coordinador_eliminar(int picoordinadorid) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.coordinador_eliminar(?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, picoordinadorid));
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
     
     //Buscar Programa por nombre y fecha
     public static Coordinador buscar_por_programa(int piprogramaid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Coordinador> lista= new ArrayList<Coordinador>();
       Coordinador obj= new Coordinador();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.buscar_por_programa(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, piprogramaid);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj = new Coordinador();
              obj.setCoordinadorid(rs.getInt("pcoordinadorid"));
              obj.setNombre(rs.getString("pnombre"));
              obj.setApellido(rs.getString("papellido"));
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
