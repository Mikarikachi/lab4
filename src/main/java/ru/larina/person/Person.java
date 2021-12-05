package ru.larina.person;

public class Person {

    private static final long CORRECT_NUMBER_OF_FIELDS_FOR_PARSING = 6;

    private final Long id;
    private final String name;
    private final String gender;
    private final Division division;
    private final String salary;
    private final String birthday;

    public String getName() {
        return name;
    }

    public Person(String cvsString) throws Exception {
        String[] data = cvsString.split(";");

        if (data.length != CORRECT_NUMBER_OF_FIELDS_FOR_PARSING) {
            String errMessage = String.format("Неверное количество полей - %d (ожидалось - %d), в полученной строке:%n%s",
                    data.length,
                    CORRECT_NUMBER_OF_FIELDS_FOR_PARSING,
                    cvsString);
            throw new Exception(errMessage);
        }

        try {
            this.id = Long.valueOf(data[0]);
            this.name = data[1];
            this.gender = data[2];
            this.birthday = data[3];
            this.division = Division.getDivisionByName(data[4]);
            this.salary = data[5];
        } catch (Exception e) {
            throw new Exception(e.getMessage() + "\nНевозможно создать пользователя из полученной строки:\n" + cvsString);
        }
    }

}
