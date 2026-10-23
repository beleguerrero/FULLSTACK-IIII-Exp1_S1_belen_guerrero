package cl.duoc.mi_biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class LibroRequestDTO {

    @NotBlank(message = "Falta nombre del libro")
    private String nombre;

    @NotBlank(message = "Falta autor")
    private String autor;
    
    private Integer anoPublicacion;
    
    private String genero;
    
    private String codigo;

    private String sinopsis;
    
}
