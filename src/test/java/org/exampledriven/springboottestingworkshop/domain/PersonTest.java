package org.exampledriven.springboottestingworkshop.domain;


import org.exampledriven.springboottestingworkshop.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Peter Szanto on 7/4/2017.
 */
@RunWith(SpringRunner.class)
@JsonTest
public class PersonTest {

    private static final String PERSON_JSON = "{\"id\":0, \"firstName\": \"First\", \"lastName\":\"Last\"}";

    @Autowired
    private JacksonTester<Person> personJacksonTester;

    private Person person;

    @Before
    public void setUp() {
        person = new Person();
        person.setFirstName("First");
        person.setLastName("Last");
    }

    @Test
    public void testSerialize() throws Exception {

        //TODO 7

    }

    @Test
    public void testDeserialize() throws Exception {

        //TODO 7

    }

}