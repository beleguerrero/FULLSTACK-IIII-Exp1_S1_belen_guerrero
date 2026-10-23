package cl.duoc.mi_biblioteca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.mi_biblioteca.dto.LibroRequestDTO;
import cl.duoc.mi_biblioteca.dto.LibroResponseDTO;
import cl.duoc.mi_biblioteca.service.LibroService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("microservicio/libros")
public class LibroController {
    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    // get
    @GetMapping 
    public ResponseEntity<List<LibroResponseDTO>> getLibros() {
        List<LibroResponseDTO> libros = service.getLibros();
        return ResponseEntity.ok(libros);
    }

    // get id
    @GetMapping("/{id}")
    public ResponseEntity<?> getLibro(@PathVariable Long id) {
        LibroResponseDTO libro = service.getLibroById(id);

        if(libro == null) {
            return ResponseEntity.status(404).body("No se encontró libro con id: " + id);
        }

        return ResponseEntity.ok(libro);
    }

    // post
    @PostMapping 
    public ResponseEntity<?> doLibro(@Valid @RequestBody LibroRequestDTO request) {
        LibroResponseDTO createdLibro = service.doLibro(request);
        return ResponseEntity.ok(createdLibro);
    }

    // put
    @PutMapping("/{id}")
    public ResponseEntity<?> setLibro(@PathVariable Long id, @Valid @RequestBody LibroRequestDTO request) {
        LibroResponseDTO savedLibro = service.setLibro(id, request);

        if(savedLibro == null) {
            return ResponseEntity.status(404).body("No se encontró libro con id: " + id);
        }

        return ResponseEntity.ok(savedLibro);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        boolean deletedLibro = service.deleteLibro(id);

        if(!deletedLibro) {
            return ResponseEntity.status(404).body("No se encontró libro con id: " + id);
        }

        return ResponseEntity.ok().body("Libro eliminado");
    }
}
