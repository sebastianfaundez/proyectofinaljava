package tech.curso.usuariosapi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Telefono {

    @Id
    private String usuario_id;
    private String numero;
    private String cod_ciudad;
    private String cod_pais;


}
