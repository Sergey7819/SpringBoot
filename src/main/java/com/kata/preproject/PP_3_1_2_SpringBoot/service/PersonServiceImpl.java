package com.kata.preproject.PP_3_1_2_SpringBoot.service;

import com.kata.preproject.PP_3_1_2_SpringBoot.dao.PersonDAO;
import com.kata.preproject.PP_3_1_2_SpringBoot.models.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {


    private final PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Transactional
    public List<Person> getAllPeople() {
        return personDAO.getAllPeople();

    }


    @Transactional(readOnly = true)
    public Person getUser(int id) {
        return personDAO.getUser(id);
    }

    @Transactional
    public void save(Person person) {
        personDAO.save(person);
    }

    @Transactional
    public void update(Person updatedPerson) {
        Person personToBeUpdated = personDAO.getUser(updatedPerson.getId());
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    @Transactional
    public void delete(int id) {
        personDAO.delete(id);
    }
}
