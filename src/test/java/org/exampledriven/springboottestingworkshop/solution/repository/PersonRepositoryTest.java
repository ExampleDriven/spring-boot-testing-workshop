package org.exampledriven.springboottestingworkshop.solution.repository;

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
@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    private static final String JOHN = "John";
    private static final String DOE = "Doe";

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findByFirstNameAndLastName() {

        Person expected = new Person();
        expected.setId(1);
        expected.setFirstName(JOHN);
        expected.setLastName(DOE);

        assertEquals(expected, personRepository.findByFirstNameAndLastName(expected.getFirstName(), expected.getLastName()));
    }

    @Test
    public void deleteByFirstNameAndLastName() {

        personRepository.deleteByFirstNameAndLastName(JOHN, DOE);

        assertNull(personRepository.findByFirstNameAndLastName(JOHN, DOE));
    }

}