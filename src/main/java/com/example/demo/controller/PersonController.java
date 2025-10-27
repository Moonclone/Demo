package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository repo;

    @GetMapping
    public List<Person> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return repo.save(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return repo.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
