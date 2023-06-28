package tech.curso.usuariosapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
//import java.util.UUID;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//public class Usuario extends RepresentationModel<Usuario> {
public class Usuario implements Serializable {



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


    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    @NotEmpty(message = "No puede estar vacío")
    @Email(message = "error de formato")
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

    /*
    @OneToMany(targetEntity = Telefono.class, cascade = CascadeType.ALL)
    @JoinColumn(name="usuario_id", referencedColumnName = "id")
    */

    @OneToMany(mappedBy="usuarioId")
    private List<Telefono> telefonos;


}
