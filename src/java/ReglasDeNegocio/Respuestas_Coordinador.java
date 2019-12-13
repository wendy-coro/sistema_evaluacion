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
public class Respuestas_Coordinador {
    
    private int respuesta_cid;
    private Preguntas_Coordinador preguntas_coordinador;
    private int respuesta;
    private Coordinador coordinador;

    public Respuestas_Coordinador() {
    }

    public Respuestas_Coordinador(int respuesta_cid, Preguntas_Coordinador preguntas_coordinador, int respuesta, Coordinador coordinador) {
        this.respuesta_cid = respuesta_cid;
        this.preguntas_coordinador = preguntas_coordinador;
        this.respuesta = respuesta;
        this.coordinador = coordinador;
    }

    public int getRespuesta_cid() {
        return respuesta_cid;
    }

    public void setRespuesta_cid(int respuesta_cid) {
        this.respuesta_cid = respuesta_cid;
    }

    public Preguntas_Coordinador getPreguntas_coordinador() {
        return preguntas_coordinador;
    }

    public void setPreguntas_coordinador(Preguntas_Coordinador preguntas_coordinador) {
        this.preguntas_coordinador = preguntas_coordinador;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    // CRUDs para la tabla respuestas coordinador
   // respuestas coordinador buscar todos
    
    public static ArrayList<Respuestas_Coordinador> respuestac_buscartodos() throws Exception
    {
       //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Respuestas_Coordinador> lista= new ArrayList<Respuestas_Coordinador>();
       Respuestas_Coordinador obj= new Respuestas_Coordinador();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from public.respuestac_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatEstudianteement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Respuestas_Coordinador();
              obj.setRespuesta_cid(rs.getInt("prespuesta_cid"));
              Preguntas_Coordinador preguntas_coordinador = new Preguntas_Coordinador();
              Preguntas_Coordinador preguntas_coordinadores = preguntas_coordinador.preguntac_buscarporid(rs.getInt("ppregunta_cid"));
              obj.setPreguntas_coordinador(preguntas_coordinadores);
              obj.setRespuesta(rs.getInt("prespuesta"));
              Coordinador coordinador = new Coordinador();
              Coordinador coordinadores = coordinador.coordinador_buscarporid(rs.getInt("pcoordinadorid"));
              obj.setCoordinador(coordinadores);
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
 
    // Buscar por id Respuesta Coordinador
    public static Respuestas_Coordinador respuestac_buscarporid(int pirespuesta_cid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
        ArrayList<Respuestas_Coordinador> lista= new ArrayList<Respuestas_Coordinador>();
       Respuestas_Coordinador obj= new Respuestas_Coordinador();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.respuestac_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, pirespuesta_cid);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj = new Respuestas_Coordinador();
              obj.setRespuesta_cid(rs.getInt("prespuesta_cid"));
              Preguntas_Coordinador preguntas_coordinador = new Preguntas_Coordinador();
              Preguntas_Coordinador preguntas_coordinadores = preguntas_coordinador.preguntac_buscarporid(rs.getInt("ppreguntas_cid"));
              obj.setPreguntas_coordinador(preguntas_coordinadores);
              obj.setRespuesta(rs.getInt("prespuesta"));
              Coordinador coordinador = new Coordinador();
              Coordinador coordinadores = coordinador.coordinador_buscarporid(rs.getInt("pcoordinadorid"));
              obj.setCoordinador(coordinadores);
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
     
    
    public static boolean respuestac_insertar(Respuestas_Coordinador respuestas_coordinador) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.respuestac_insertar(?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          
          parametros.add(new Parametro(1, respuestas_coordinador.getPreguntas_coordinador().getPreguntas_cid()));
          parametros.add(new Parametro(2, respuestas_coordinador.getRespuesta()));
          parametros.add(new Parametro(3, respuestas_coordinador.getCoordinador().getCoordinadorid()));

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
    public static boolean respuestac_editar(Respuestas_Coordinador respuestas_coordinador) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.respuestac_editar(?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros

          parametros.add(new Parametro(1, respuestas_coordinador.getRespuesta_cid()));
          parametros.add(new Parametro(2, respuestas_coordinador.getPreguntas_coordinador().getPreguntas_cid()));
          parametros.add(new Parametro(3, respuestas_coordinador.getRespuesta()));
          parametros.add(new Parametro(4, respuestas_coordinador.getCoordinador().getCoordinadorid()));

        
          
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
