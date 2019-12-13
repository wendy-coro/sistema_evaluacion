/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author usuario
 */
public class Respuestas {
  private int id_respuesta ;
  private Date fecha_respuesta;
  private String asunto;
  private Personal personal;
  private int id_documento ;
  private String ruta;
  private Date fecha_expira;
  private String observaciones;
  
public Respuestas (){

}

    public Respuestas(int id_respuesta, Date fecha_respuesta, String asunto, Personal personal, int id_documento, String ruta, Date fecha_expira, String observaciones) {
        this.id_respuesta = id_respuesta;
        this.fecha_respuesta = fecha_respuesta;
        this.asunto = asunto;
        this.personal = personal;
        this.id_documento = id_documento;
        this.ruta = ruta;
        this.fecha_expira = fecha_expira;
        this.observaciones = observaciones;
    }

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public Date getFecha_respuesta() {
        return fecha_respuesta;
    }

    public void setFecha_respuesta(Date fecha_respuesta) {
        this.fecha_respuesta = fecha_respuesta;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getFecha_expira() {
        return fecha_expira;
    }

    public void setFecha_expira(Date fecha_expira) {
        this.fecha_expira = fecha_expira;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
// Buscar todos
    public static ArrayList<Respuestas> respuestas_buscartodos() throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Respuestas> lista= new ArrayList<Respuestas>();
       Respuestas obj= new Respuestas();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from public.respuestas_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Respuestas();
              obj.setId_respuesta(rs.getInt("pid_respuesta"));
              obj.setFecha_respuesta(rs.getDate("pfecha_respuesta"));
              obj.setAsunto(rs.getString("pasunto"));
              Personal personal = new Personal();
              Personal persona = Personal.personal_buscarporid(rs.getInt("pid_personal "));
              obj.setPersonal(persona);
              obj.setId_documento(rs.getInt("pid_documento"));
              obj.setRuta(rs.getString("pruta"));
              obj.setFecha_expira(rs.getDate("pfecha_expira"));
              obj.setObservaciones(rs.getString("pobservaciones"));
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
    
    //  buscar por su id
    
    public static Respuestas respuestas_buscarporid(int pi_id_respuesta) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Respuestas> lista= new ArrayList<Respuestas>();
       Respuestas obj= new Respuestas();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.respuestas_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, pi_id_respuesta);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj = new Respuestas();
             obj.setId_respuesta(rs.getInt("pid_respuesta"));
              obj.setFecha_respuesta(rs.getDate("pfecha_respuesta"));
              obj.setAsunto(rs.getString("pasunto"));
              Personal personal = new Personal();
              Personal persona = Personal.personal_buscarporid(rs.getInt("pid_personal "));
              obj.setPersonal(persona);
              obj.setId_documento(rs.getInt("pid_documento"));
              obj.setRuta(rs.getString("pruta"));
              obj.setFecha_expira(rs.getDate("pfecha_expira"));
              obj.setObservaciones(rs.getString("pobservaciones"));
            
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
    
    //Insertar 
    public static boolean respuestas_insertar(Respuestas respuestas) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.recibidos_insertar(?,?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, respuestas.getFecha_respuesta()));
          parametros.add(new Parametro(2, respuestas.getAsunto()));
          parametros.add(new Parametro(3, respuestas.getPersonal().getId_personal()));
          parametros.add(new Parametro(4, respuestas.getId_documento()));
          parametros.add(new Parametro(5, respuestas.getRuta()));
          parametros.add(new Parametro(6, respuestas.getFecha_expira()));          
          parametros.add(new Parametro(7, respuestas.getObservaciones()));
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

   // Editar datos 
    public static boolean respuestas_editar(Respuestas respuestas) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.respuestas_editar(?,?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, respuestas.getId_respuesta()));     
          parametros.add(new Parametro(2, respuestas.getFecha_respuesta()));
          parametros.add(new Parametro(3, respuestas.getAsunto()));
          parametros.add(new Parametro(4, respuestas.getPersonal().getId_personal()));
          parametros.add(new Parametro(5, respuestas.getId_documento()));
          parametros.add(new Parametro(6, respuestas.getRuta()));
          parametros.add(new Parametro(7, respuestas.getFecha_expira()));          
          parametros.add(new Parametro(8, respuestas.getObservaciones()));
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
    
     //Eliminar datos 
     public static boolean respuestas_eliminar(int piid_respuesta) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.respuesta_eliminar(?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, piid_respuesta));
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
     
}
