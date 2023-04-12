package com.spb.spb0410.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spb.spb0410.Dao.PersonDao;

import com.spb.spb0410.VO.PersonVO;


@RestController
public class PersonController {

    @Autowired
    private PersonDao personDao;



    @GetMapping("/persons")
    public List<PersonVO> getAllPersons() {
        return personDao.getAllPersons();
    }

    @PostMapping("/persons")
    public void addPerson(@RequestBody PersonVO person) {
        personDao.addPerson(person);
    }

// http://localhost:8080/h2-console/

// http://localhost:8080/persons

}
