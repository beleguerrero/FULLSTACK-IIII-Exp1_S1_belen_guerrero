package cl.duoc.mi_biblioteca.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class LibroResponseDTO{

    private Long id;
    private String nombre;
    private String autor;
    private Integer ano_publicacion;
    private String genero;
    private String codigo;
    private String sinopsis;
    
}
