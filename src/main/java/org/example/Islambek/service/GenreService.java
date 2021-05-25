package org.example.Islambek.service;

import org.example.Islambek.controller.GenreController;
import org.example.Islambek.model.Genre;
import org.example.Islambek.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public void createGenre(Genre genre) {

        Genre newGenre = new Genre();
        newGenre.setId(genre.getId());
        newGenre.setName(genre.getName());

        genreRepository.saveAndFlush(newGenre);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
