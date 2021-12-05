package ru.larina.person;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private static int currentId = 0;
    private static final List<String> divisionsNameIndexIsId = new ArrayList<>();
    private static final List<Division> DIVISIONS = new ArrayList<>();

    private final long id;
    private final String name;

    public Division(String name) {
        this.name = name;
        id = currentId++;
        divisionsNameIndexIsId.add(this.name);
        DIVISIONS.add(this);
    }

    public static Division getDivisionByName(String inputName) {
        if(divisionsNameIndexIsId.contains(inputName)) {
            int id = divisionsNameIndexIsId.indexOf(inputName);
            return DIVISIONS.get(id);
        }
        return new Division(inputName);
    }
}
