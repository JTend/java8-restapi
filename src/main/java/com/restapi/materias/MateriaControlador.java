package com.restapi.materias;

import com.restapi.global.Mensaje;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materias")
public class MateriaControlador {
  @GetMapping //METODO GET
  public ArrayList<Materia> obtenerLista() {
    return MateriaServicio.obtenerLista();
  }
  
  @GetMapping("/{index}")
  public Materia obtenerPorId(@PathVariable("index") long id) {
    return MateriaServicio.obtenerPorId(id);
  }
  
  @PostMapping
  public Mensaje crearRegistro(@RequestBody Materia mat) {
    if(MateriaServicio.crearRegistro(mat)) {
      return new Mensaje("Registro exitoso!");
    } else {
      return new Mensaje("Fallo al guardar");
    }
  }
  
  @PatchMapping("/{index}")
  public Mensaje actualizarRegistro(@PathVariable("index") long id, @RequestBody Materia mat) {
    if(MateriaServicio.actualizarRegistro(id, mat)) {
      return new Mensaje("Registro actualizado!");
    } else {
      return new Mensaje("Fallo al guardar");
    }
  }
  
  @DeleteMapping("/{index}")
  public Mensaje borrarRegistro(@PathVariable("index") long id) {
    if(MateriaServicio.borrarRegistro(id)) {
      return new Mensaje("Registro borrado!");
    } else {
      return new Mensaje("Fallo al borrar");
    }
  }
}
