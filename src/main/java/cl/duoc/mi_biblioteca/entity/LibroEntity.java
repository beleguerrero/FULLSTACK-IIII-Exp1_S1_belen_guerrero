package cl.duoc.mi_biblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;


@Entity
@Table (name = "libro_desnormalizado")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class LibroEntity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 150)
    private String nombre;

    @Column (nullable = false, length = 150)
    private String autor;

    @Column (nullable = true, name = "ano_publicacion")
    private Integer anoPublicacion;

    @Column (nullable = true, length = 150)
    private String genero;

    @Column (nullable = true, length = 150)
    private String codigo;

    @Column (nullable = true, length = 150)
    private String sinopsis;
}

