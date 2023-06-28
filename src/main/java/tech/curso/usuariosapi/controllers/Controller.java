package tech.curso.usuariosapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.curso.usuariosapi.models.Usuario;
import tech.curso.usuariosapi.repository.Repository;

import javax.validation.Valid;
import java.util.List;


@RestController
public class Controller {


    @Autowired
    private Repository repo;


    @GetMapping()
    public String index(){
        return "CONECTADO desde funcion index del controller";
    }

    @GetMapping("usuarios")
    public List<Usuario> getUsuarios(){
        return repo.findAll();
    }


    @PostMapping("create")
    public String post(@Valid @RequestBody Usuario usuario){

        repo.save(usuario);
        return "Usuario creado";
    }


    /*
    @PostMapping("create")
    public Usuario post(@Valid @RequestBody Usuario usuario){
        return usuario;
    }
    */


    @PutMapping("edit/{id}")
    public String update(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario updateUsuario = repo.findById(id).get();
        updateUsuario.setNombre(usuario.getNombre());
        updateUsuario.setCorreo(usuario.getCorreo());
        updateUsuario.setPassword(usuario.getPassword());
        updateUsuario.setIsactive(usuario.isIsactive());
        repo.save(updateUsuario);
        return "Usuario editado correctamente.";

    }


    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        Usuario deleteUsuario = repo.findById(id).get();
        repo.delete(deleteUsuario);
        return "Usuario eliminado correctamente.";
    }




}
