package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }

    public void load(InputStream inputStream) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        setFirstName(bufferedReader.readLine());

        setLastName(bufferedReader.readLine());

        String date = bufferedReader.readLine();
        setBirthDate(new Date(date.substring(date.length() - 4) + date.substring(3, 10)));

        setMale(Boolean.parseBoolean(bufferedReader.readLine()));

        String stringCountry = bufferedReader.readLine();
        Country country = null;
        if (stringCountry.equals("UKRAINE"))
            country = Country.UKRAINE;
        if (stringCountry.equals("RUSSIA"))
            country = Country.RUSSIA;
        if (stringCountry.equals("OTHER"))
            country = Country.OTHER;
        setCountry(country);
    }
}
