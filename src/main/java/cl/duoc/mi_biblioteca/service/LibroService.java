package cl.duoc.mi_biblioteca.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cl.duoc.mi_biblioteca.dto.LibroRequestDTO;
import cl.duoc.mi_biblioteca.dto.LibroResponseDTO;
import cl.duoc.mi_biblioteca.entity.LibroEntity;
import cl.duoc.mi_biblioteca.repository.LibroRepository;

@Service 
public class LibroService {
    
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // get
    public List<LibroResponseDTO> getLibros() {
        return libroRepository.findAll().stream().map(this::toDTO).toList();
    }

    // get id
    public LibroResponseDTO getLibroById(Long id) {
        Optional<LibroEntity> libro = libroRepository.findById(id);
        return libro.map(this::toDTO).orElse(null);
    }

    // do
    public LibroResponseDTO doLibro(LibroRequestDTO libroRequest) {
        LibroEntity libro = new LibroEntity();

        libro.setNombre(libroRequest.getNombre());
        libro.setAutor(libroRequest.getAutor());

        libro.setAnoPublicacion(libroRequest.getAnoPublicacion());
        libro.setGenero(libroRequest.getGenero());
        libro.setCodigo(libroRequest.getCodigo());
        libro.setSinopsis(libroRequest.getSinopsis());

        LibroEntity createdLibro = libroRepository.save(libro);
        return toDTO(createdLibro);
    }

    // update
    public LibroResponseDTO setLibro(Long id, LibroRequestDTO libroRequest) {
        Optional<LibroEntity> libroOptional = libroRepository.findById(id);
        if(libroOptional.isEmpty()) {
            return null;
        }

        LibroEntity libro = libroOptional.get();

        libro.setNombre(libroRequest.getNombre());
        libro.setAutor(libroRequest.getAutor());

        libro.setAnoPublicacion(libroRequest.getAnoPublicacion());
        libro.setGenero(libroRequest.getGenero());
        libro.setCodigo(libroRequest.getCodigo());
        libro.setSinopsis(libroRequest.getSinopsis());

        LibroEntity savedLibro = libroRepository.save(libro);
        return toDTO(savedLibro);
    }


    // delete
    public boolean deleteLibro(Long id) {
        Optional<LibroEntity> libroOptional = libroRepository.findById(id);
        if(libroOptional.isEmpty()) {
            return false;
        }

        libroRepository.deleteById(id);
        return true;
    }



    private LibroResponseDTO toDTO(LibroEntity libro) {
        return new LibroResponseDTO(
            libro.getId(), 
            libro.getNombre(), 
            libro.getAutor(), 
            libro.getAnoPublicacion(), 
            libro.getGenero(), 
            libro.getCodigo(), 
            libro.getSinopsis()
        );
    }
}

