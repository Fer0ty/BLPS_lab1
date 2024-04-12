package ru.artemiyandarina.blps_lab1.enums;

public enum Country {
    USA,
    RUSSIA,
    UK,
    GERMANY,
    FRANCE,
    CANADA,
    AUSTRALIA,
    JAPAN,
    CHINA,
    INDIA,
    BRAZIL;

    public static Country valueOfIgnoreCase(String countryName) {
        for (Country country : values()) {
            if (country.name().equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Country.class.getName() + " with name " + countryName);
    }
}
