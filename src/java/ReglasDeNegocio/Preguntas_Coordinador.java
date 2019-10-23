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
public class Preguntas_Coordinador {
    
    private int preguntas_cid;
    private String pregunta;

    public Preguntas_Coordinador() {
    }

    public Preguntas_Coordinador(int preguntas_cid, String pregunta) {
        this.preguntas_cid = preguntas_cid;
        this.pregunta = pregunta;
    }

    public int getPreguntas_cid() {
        return preguntas_cid;
    }

    public void setPreguntas_cid(int preguntas_cid) {
        this.preguntas_cid = preguntas_cid;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
     @Override 
    public String toString(){
        return pregunta;
    }
    
    
    // CRUDs para la tabla preguntas coordinador
    // Preguntas coordinador buscar todos
    public static ArrayList<Preguntas_Coordinador> preguntac_buscartodos() throws Exception
    {
        //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Preguntas_Coordinador> lista= new ArrayList<Preguntas_Coordinador>();
       Preguntas_Coordinador obj= new Preguntas_Coordinador();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from public.preguntac_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Preguntas_Coordinador();
              obj.setPreguntas_cid(rs.getInt("ppreguntas_cid"));
              obj.setPregunta(rs.getString("ppregunta"));
              
              
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
    

    
   // pregunta_Coordinador buscar por su id
    
    public static Preguntas_Coordinador preguntac_buscarporid(int pipreguntas_cid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       Preguntas_Coordinador obj= new Preguntas_Coordinador();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.preguntac_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, pipreguntas_cid);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Preguntas_Coordinador();
              obj.setPreguntas_cid(rs.getInt("ppreguntas_cid"));
              obj.setPregunta(rs.getString("ppregunta"));
             
             
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
    
    // Insertar valores a la tabla Programa
    
    public static boolean pregunta_coordinador_insertar(Preguntas_Coordinador pregunta_coordinador) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÑADIDO AL ARRAYLIST DE COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.pregunta_coordinador_insertar(?)");
          //CREAMOS EL ARRAYLIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, pregunta_coordinador.getPregunta()));
  

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
    
     public static boolean preguntac_editar(Preguntas_Coordinador preguntas_coordinador) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.preguntac_editar_editar(?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros

          parametros.add(new Parametro(1, preguntas_coordinador.getPreguntas_cid()));
          parametros.add(new Parametro(2, preguntas_coordinador.getPregunta()));

        
          
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
