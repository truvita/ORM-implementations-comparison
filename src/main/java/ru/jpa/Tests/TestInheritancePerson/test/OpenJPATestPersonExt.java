package ru.jpa.Tests.TestInheritancePerson.test;

import ru.jpa.Tests.TestInheritancePerson.dao.PersonExtDaoOpenJPA;
import ru.jpa.Tests.TestInheritancePerson.model.PersonExtExt;
import ru.jpa.Tests.imp.ITestPersonInheritance;

import java.util.List;

public class OpenJPATestPersonExt implements ITestPersonInheritance {

    private List<PersonExtExt> persons;
    private PersonExtDaoOpenJPA dao;

    @Override
    public void createPerson() {
        PersonExtExt person = new PersonExtExt();
        dao = new PersonExtDaoOpenJPA();
        dao.save(person);
    }

    public List<PersonExtExt> getAllPersons() {
        dao = new PersonExtDaoOpenJPA();
        persons = dao.getAllPersons();
        persons.forEach(person -> System.out.println(person));
        return persons;
    }

    @Override
    public void deletePerson() {
        dao = new PersonExtDaoOpenJPA();
        if(persons == null || persons.isEmpty()){
            getAllPersons();
        }
        persons.forEach(person -> dao.delete(person));
    }
}