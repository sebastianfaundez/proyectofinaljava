package tech.curso.usuariosapi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="telefono")
@Getter
@Setter
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_telefono")
    private Integer idTelefono;

    @Column(name="usuario_id")
    private Long usuarioId;

    private String numero;

    private String codCiudad;

    private String codPais;


}
