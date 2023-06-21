package tech.curso.usuariosapi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Usuario {



    @Id
    @GeneratedValue(generator = "uuid2")

    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;




    @Column
    @Getter
    @Setter
    private String Nombre;

    @Column
    @Getter
    @Setter
    private String correo;
    @OneToMany(targetEntity = Telefono.class, cascade = CascadeType.ALL)
    @JoinColumn(name="usuario_id", referencedColumnName = "id")
    private List<Telefono> telefonos;


}
