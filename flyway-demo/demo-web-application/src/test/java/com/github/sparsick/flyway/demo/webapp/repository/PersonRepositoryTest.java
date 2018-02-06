package com.github.sparsick.flyway.demo.webapp.repository;

import static org.junit.Assert.assertThat;

import com.github.sparsick.flyway.demo.webapp.domain.Person;
import java.util.List;
import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

/**
 *
 * @author sparsick
 */
public class PersonRepositoryTest {

    @Rule
    public MySQLContainer mysqlDb = new MySQLContainer();

    @Test
    public void saveAndLoadAPerson() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(mysqlDb.getJdbcUrl(), mysqlDb.getUsername(), mysqlDb.getPassword());
        flyway.migrate();
        
        PersonRepository personRepositoryUnderTest = new PersonRepository(flyway.getDataSource());
        Person person = new Person("Alice", "Bob");
        personRepositoryUnderTest.save(person);
        
        List<Person> persons = personRepositoryUnderTest.findAllPersons();
        
        assertThat(persons.size(), Is.is(3));
        assertThat(persons, Matchers.hasItem(person));
    }

}
