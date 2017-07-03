package org.exampledriven.springboottestingworkshop.repository;

import org.exampledriven.springboottestingworkshop.domain.Person;
import org.exampledriven.springboottestingworkshop.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Peter Szanto on 7/2/2017.
 */
//@RunWith(SpringRunner.class)
//@DataJpaTest
public class PersonRepositoryTest {

    //Hint: check all possible values in import.sql
    private static final String JOHN = "John";
    private static final String DOE = "Doe";

    //@Autowired
    //private PersonRepository personRepository;

    @Test
    public void findByFirstNameAndLastName() {
        //TODO 1
    }

    @Test
    public void deleteByFirstNameAndLastName() {
        //TODO 1
    }

}