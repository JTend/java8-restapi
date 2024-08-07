package com.restapi.materias;

public class Materia {
  private long id;
  private String nombre;

  public Materia(long id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
