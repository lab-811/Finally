package org.example.Islambek.service;

import org.example.Islambek.model.Publisher;
import org.example.Islambek.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public void createPublisher(Publisher publisher){

        Publisher newPublisher = new Publisher();
        newPublisher.setId(publisher.getId());
        newPublisher.setAddress(publisher.getAddress());
        newPublisher.setName(publisher.getName());

        publisherRepository.saveAndFlush(newPublisher);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}
