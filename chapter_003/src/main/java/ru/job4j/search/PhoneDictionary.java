package ru.job4j.search;

import ru.job4j.search.Person;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            String pers = String.format("%s %s %s %s", person.getName(), person.getSurname(), person.getPhone(), person.getAddress());
            if (pers.contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}