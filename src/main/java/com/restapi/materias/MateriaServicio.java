package com.restapi.materias;

import com.restapi.global.Basedatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class MateriaServicio {
  public static ArrayList<Materia> obtenerLista() {
    ArrayList<Materia> lista = new ArrayList();
    
    Basedatos db = new Basedatos();
    try {
      ResultSet res = db.consultar("select * from materias");
      while(res.next()) {
        lista.add(new Materia(res.getLong("id"), res.getString("nombre")));
      }
    } catch(SQLException e) {
      System.out.println(e.getMessage());
    }
    return lista;
  }
  
  public static Materia obtenerPorId(long id) {
    Materia mat = new Materia(0, "");
    Basedatos db = new Basedatos();
    try {
      ResultSet res = db.consultar("select * from materias where id = " + id);
      if(res.next()) {
        mat.setId(res.getLong("id"));
        mat.setNombre(res.getString("nombre"));
      }
    } catch(SQLException e) {
      System.out.println(e.getMessage());
    }
    return mat;
  }
  
  public static boolean crearRegistro(Materia mat) {
    try {
      Basedatos db = new Basedatos();
      return !db.ejecutar("insert into materias (nombre) values ('"+ mat.getNombre() +"')");
    } catch(SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
  
  public static boolean actualizarRegistro(long id, Materia mat) {
    try {
      Basedatos db = new Basedatos();
      return !db.ejecutar(
        "update materias set nombre = '"+ mat.getNombre() +"' where id = " + id
      );
    } catch(SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
  
  public static boolean borrarRegistro(long id) {
    try {
      Basedatos db = new Basedatos();
      return !db.ejecutar("delete from materias where id = " + id);
    } catch(SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
