package org.example.Islambek.controller;


import org.example.Islambek.model.Genre;
import org.example.Islambek.model.Publisher;
import org.example.Islambek.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping()
    public void createPublisher(@RequestBody Publisher publisher){
        publisherService.createPublisher(publisher);
    }


    @DeleteMapping("/{id}")
    public void deletePublisher(@RequestParam Long id){
        publisherService.deletePublisher(id);
    }
}
