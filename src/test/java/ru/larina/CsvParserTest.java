package ru.larina;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CsvParserTest {
    @Test
    public void parseFileAsListPersons_allCorrect() {
        String pathToSmallCorrectFile = CsvParser.class.getResource("/five_correct_row.csv").getPath();
        CsvParser parser = new CsvParser(pathToSmallCorrectFile);
        parser.parseFileAsListPersons();
        Assertions.assertEquals(5, parser.successCreateObject);
        Assertions.assertEquals(0, parser.failCreateObject);
    }



}