package org.exampledriven.springboottestingworkshop.solution.domain;

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

        assertThat(personJacksonTester.write(person)).isEqualToJson(PERSON_JSON);
        // Or use JSON path based assertions
        assertThat(personJacksonTester.write(person)).hasJsonPathStringValue("@.firstName");
        assertThat(personJacksonTester.write(person)).extractingJsonPathStringValue("@.firstName").isEqualTo("First");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = PERSON_JSON;
        assertThat(personJacksonTester.parse(content)).isEqualTo(person);
        assertThat(personJacksonTester.parseObject(content).getFirstName()).isEqualTo("First");
    }

}