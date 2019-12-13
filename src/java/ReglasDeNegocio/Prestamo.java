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
public class Prestamo {
  private int id_prestamo ;
  private int id_documento;
  private String nombre; 
  private String dependencia ;
  private Personal personal ;
  private Ciudadanos ciudadanos ;
  
 public Prestamo(){
 }

    public Prestamo(int id_prestamo, int id_documento, String nombre, String dependencia, Personal personal, Ciudadanos ciudadanos) {
        this.id_prestamo = id_prestamo;
        this.id_documento = id_documento;
        this.nombre = nombre;
        this.dependencia = dependencia;
        this.personal = personal;
        this.ciudadanos = ciudadanos;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Ciudadanos getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(Ciudadanos ciudadanos) {
        this.ciudadanos = ciudadanos;
    }
 
        // Buscar todos
    public static ArrayList<Prestamo> prestamo_buscartodos() throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Prestamo> lista= new ArrayList<Prestamo>();
       Prestamo obj= new Prestamo();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from public.prestamo_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Prestamo();
              obj.setId_prestamo(rs.getInt("pid_prestamo"));
              obj.setId_documento(rs.getInt("pid_documento"));
              obj.setNombre(rs.getString("pnombre"));
              obj.setDependencia(rs.getString("pdependencia"));
              Personal personal = new Personal();
              Personal persona = Personal.personal_buscarporid(rs.getInt("pid_personal "));
              obj.setPersonal(persona);
              
               Ciudadanos ciudadanos = new Ciudadanos();
              Ciudadanos ciudadano = Ciudadanos.ciudadano_buscarporid(rs.getInt("pid_ciudadano "));
              obj.setCiudadanos(ciudadano);
              
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
    
    public static Prestamo prestamo_buscarporid(int piid_prestamo) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Prestamo> lista= new ArrayList<Prestamo>();
       Prestamo obj= new Prestamo();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.prestamo_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, piid_prestamo);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj = new Prestamo();
              obj.setId_prestamo(rs.getInt("pid_prestamo"));
              obj.setId_documento(rs.getInt("pid_documento"));
              obj.setNombre(rs.getString("pnombre"));
              obj.setDependencia(rs.getString("pdependencia"));
              Personal personal = new Personal();
              Personal persona = Personal.personal_buscarporid(rs.getInt("pid_personal "));
              obj.setPersonal(persona);
              
               Ciudadanos ciudadanos = new Ciudadanos();
              Ciudadanos ciudadano = Ciudadanos.ciudadano_buscarporid(rs.getInt("pid_ciudadano "));
              obj.setCiudadanos(ciudadano);
              
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
    public static boolean prestamo_insertar(Prestamo prestamo) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.prestamo_insertar(?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, prestamo.getId_documento()));
          parametros.add(new Parametro(2, prestamo.getNombre()));
          parametros.add(new Parametro(3, prestamo.getDependencia()));
          parametros.add(new Parametro(4, prestamo.getPersonal().getId_personal()));
          parametros.add(new Parametro(5, prestamo.getCiudadanos().getId_ciudadano()));
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
    public static boolean prestamo_editar(Prestamo prestamo) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.prestamo_editar(?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, prestamo.getId_prestamo()));
          parametros.add(new Parametro(2, prestamo.getId_documento()));
          parametros.add(new Parametro(3, prestamo.getNombre()));
          parametros.add(new Parametro(4, prestamo.getDependencia()));
          parametros.add(new Parametro(5, prestamo.getPersonal().getId_personal()));
          parametros.add(new Parametro(6, prestamo.getCiudadanos().getId_ciudadano()));
          
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
     public static boolean prestamo_eliminar(int piid_prestamo) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.prestamo_eliminar(?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, piid_prestamo));
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
