package com.restapi.global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Basedatos {
  private Connection con;
  private Statement sta;
  
  public Basedatos() {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      this.con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/cursos",
              "dbuser",
              "dbpass");
      this.sta = this.con.createStatement();
    } catch(SQLException e) {
      System.out.println(e.getMessage());
      System.exit(0);
    }
  }
  
  public ResultSet consultar(String sql) throws SQLException {
    return this.sta.executeQuery(sql);
  }
  
  public boolean ejecutar(String sql) throws SQLException {
    return this.sta.execute(sql);
  }
}
