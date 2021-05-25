package org.example.Islambek.controller;

import org.example.Islambek.model.Genre;
import org.example.Islambek.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping()
    public void createGenre(@RequestBody Genre genre){
        genreService.createGenre(genre);
    }


    @DeleteMapping("/{id}")
    public void deleteGenre(@RequestParam Long id){
        genreService.deleteGenre(id);
    }

}
