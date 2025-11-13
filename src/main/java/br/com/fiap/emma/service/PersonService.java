package br.com.fiap.emma.service;

import br.com.fiap.emma.model.Person;
import br.com.fiap.emma.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "persons")
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Cacheable(value = "person", key = "#id")
    public Person findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person não encontrada: " + id));
    }

    @CachePut(value = "person", key = "#result.id")
    @CacheEvict(value = "persons", allEntries = true)
    public Person save(Person person) {
        return repository.save(person);
    }

    @CachePut(value = "person", key = "#id")
    @CacheEvict(value = "persons", allEntries = true)
    public Person update(Long id, Person person) {
        Person existing = findById(id);
        existing.setName(person.getName());
        existing.setEmail(person.getEmail());
        existing.setPassword(person.getPassword());
        existing.setRole(person.getRole());
        return repository.save(existing);
    }

    @CacheEvict(value = {"person", "persons"}, key = "#id", allEntries = true)
    public void delete(Long id) {
        repository.deleteById(id);
    }
}