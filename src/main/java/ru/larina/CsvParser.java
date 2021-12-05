package ru.larina;

import ru.larina.person.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class CsvParser {

    private Scanner fileScanner;
    public int successCreateObject = 0;
    public int failCreateObject = 0;

    public CsvParser(String pathToFile) {
        try {
            fileScanner = new Scanner(new File(pathToFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pathToTaskFile = CsvParser.class.getResource("/foreign_names.csv").getPath();
        parseCsvFileByPath(pathToTaskFile);
    }

    /**
     * Parse the file by the specified path into a list of persons.
     *
     * @param pathToFile  the absolute way to file
     * @return list of persons
     */
    private static List<Person> parseCsvFileByPath(String pathToFile) {
        System.out.println("\nStart parsing: " + pathToFile);
        CsvParser parser = new CsvParser(pathToFile);
        List<Person> personsFromFile = parser.parseFileAsListPersons();

        System.out.println("End parsing: " + pathToFile);
        System.out.println("\nКоличество созданных пользователей: " + parser.successCreateObject);
        System.out.println("Количество несозданных пользователей " + parser.failCreateObject);
        System.out.println("===================================================================================");
        return personsFromFile;
    }

    /**
     * Creating a list of persons.
     *
     * @return list of persons
     */
    public List<Person> parseFileAsListPersons() {
        List<Person> persons = new ArrayList<>();

        // пропустить шапку таблицы (1-ую строку)
        if(this.fileScanner.hasNextLine()) {
            this.fileScanner.nextLine();
        }

        while (this.fileScanner.hasNextLine()) {
            String line = this.fileScanner.nextLine();
            Person person = parseLineAsPerson(line);
            if(person == null) {
                continue;
            }
            persons.add(person);
        }
    return persons;
    }

    /**
     * Person creation check.
     *
     * @param line  information of person
     */
    private Person parseLineAsPerson(String line) {
        try {
            Person person = new Person(line);
            this.successCreateObject++;
            return person;
        } catch (Exception e) {
            this.failCreateObject++;
            System.out.println("\n" + e.getMessage());
        }
        return null;
    }
}
