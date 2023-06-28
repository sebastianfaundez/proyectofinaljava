package tech.curso.usuariosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.curso.usuariosapi.commons.exceptions.UsuarioExceptionHandler;
import tech.curso.usuariosapi.models.Telefono;
import tech.curso.usuariosapi.models.Usuario;
import tech.curso.usuariosapi.repository.TelefonoRepository;
import tech.curso.usuariosapi.repository.UsuarioRepository;

import javax.validation.Valid;
import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    TelefonoRepository telefonoRepo;


    @GetMapping(path ="/listar")
    public List<Usuario> listar(){
        return usuarioRepo.findAll();
    }


    @PostMapping(path ="/guardar")
    @ResponseBody
    public ResponseEntity<Object> guardar(@Valid @RequestBody Usuario usuario)  {

        /*-----------inicio validación correo ------------*/
        List<Usuario> users = usuarioRepo.findAll();
        for(Usuario user: users){
            String correoUsuarioP = user.getCorreo();
            String correoUsuarioReq = usuario.getCorreo();
            if(correoUsuarioP.equalsIgnoreCase(correoUsuarioReq)){
                Map<String, String> data = new HashMap<>();
                data.put("status", "Bad request");
                data.put("mensaje", "El correo ya está registrado.");
                return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
            }
        }
        /*----------- fin validación correo --------------*/

        List<Telefono> telefonos = usuario.getTelefonos();
        usuario.setTelefonos(null);
        usuarioRepo.save(usuario);

        for(Telefono tel: telefonos){
            tel.setUsuarioId(usuario.getId());
        }
        telefonoRepo.saveAll(telefonos);
        usuario.setTelefonos(telefonos);
        //return new ResponseEntity<>(usuario, HttpStatus.OK);
        Map<String, String> data = new HashMap<>();
        data.put("status", "OK");
        data.put("mensaje", "Usuario grabado correctamente.");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }




    @PutMapping("/editar/{id}")
    public ResponseEntity<Object> edit(@PathVariable int id, @RequestBody Usuario usuario){
        Usuario updateResponse = usuarioRepo.save(usuario);
        Map<String, String> data = new HashMap<>();
        data.put("status", "OK");
        data.put("mensaje", "Usuario actualizado correctamente.");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @DeleteMapping(path = "/delete/{idusuario}")
    public ResponseEntity<Object> delete(@PathVariable ("idusuario") Long idusuario ){
        Optional<Usuario> usuario = usuarioRepo.findById(idusuario);
        if(usuario.isPresent()){
            telefonoRepo.deleteAll(usuario.get().getTelefonos());
            usuarioRepo.delete(usuario.get());
        }

        Map<String, String> data = new HashMap<>();
        data.put("status", "OK");
        data.put("mensaje", "Usuario eliminado correctamente.");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }





}
