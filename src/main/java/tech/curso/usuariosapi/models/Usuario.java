package tech.curso.usuariosapi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
//import java.util.UUID;

@Entity
public class Usuario {



    /*
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long Id;



    @Column
    @Getter
    @Setter
    private String Nombre;

    @Column
    @Getter
    @Setter
    private String correo;

    @Column
    @Getter
    @Setter
    private String password;


    @Column(name = "fecha_creacion")
    @Getter
    private LocalDateTime created;

    @Column(name = "fecha_modificacion")
    @Getter
    private LocalDateTime modified;

    /*
    @Column(name = "isactive")
    private boolean isactive = true;
    */

    //@Column(name = "isactive")
    @Column
    @Getter
    @Setter
    private boolean isactive;

    @PrePersist
    protected void create(){
        created = LocalDateTime.now();
        modified = LocalDateTime.now();
    }

    @PreUpdate
    protected void update() {
        modified = LocalDateTime.now();
    }


    @OneToMany(targetEntity = Telefono.class, cascade = CascadeType.ALL)
    @JoinColumn(name="usuario_id", referencedColumnName = "id")
    private List<Telefono> telefonos;


}
