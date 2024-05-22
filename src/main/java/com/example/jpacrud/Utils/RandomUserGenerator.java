package com.example.jpacrud.Utils;

import java.util.Random;

public class RandomUserGenerator {

    private static final String[] NAMES = {"John", "Jane", "Mike", "Emily", "Robert", "Linda", "James", "Jennifer", "Michael", "Patricia"};
    private static final String[] SURNAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
    private static final String[] EMAIL_DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};

    private static final Random RANDOM = new Random();

    public static String getRandomName() {
        return NAMES[RANDOM.nextInt(NAMES.length)];
    }

    public static String getRandomSurname() {
        return SURNAMES[RANDOM.nextInt(SURNAMES.length)];
    }

    public static String getRandomEmail() {
        String name = getRandomName().toLowerCase();
        String surname = getRandomSurname().toLowerCase();
        String domain = EMAIL_DOMAINS[RANDOM.nextInt(EMAIL_DOMAINS.length)];
        return name + "." + surname + "@" + domain;
    }
}