package com.fieldwire.test.ui.tests.util;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.UUID;

import com.fieldwire.test.ui.tests.constants.CompanyType;
import com.fieldwire.test.ui.tests.constants.NumberOfEmployees;
import com.fieldwire.test.ui.tests.constants.TradeType;

public class RandomGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();

    private RandomGenerator() {
    }

    public static <T extends Enum<?>> T randomEnum(final Class<T> clazz) {
        final int x = RANDOM.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static int getRandomNumber(final int boundary) {
        return RANDOM.nextInt(boundary);
    }

    public static CompanyType getRandomCompanyType() {
        return randomEnum(CompanyType.class);
    }

    public static TradeType getRandomTradeType() {
        return randomEnum(TradeType.class);
    }

    public static NumberOfEmployees getRandomNumberOfEmployees() {
        return randomEnum(NumberOfEmployees.class);
    }

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static String getRandomString() {
        String uuid = "AQA" + UUID.randomUUID().toString().replace("-", "") + Instant.now().toEpochMilli();
        return RandomGenerator.getRandomBoolean() ? uuid : uuid.toUpperCase();
    }

    public static String getRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getRandomString()).append("~!@#$%^&*()_+<>?/\\.,`[]{}:;'|\"").append(getRandomString());
        while (stringBuilder.length() < length) {
            stringBuilder.append(getRandomString());
        }
        return stringBuilder.toString();
    }

    private static String getString(int length) {
        int leftLimit = 97; // numeral '0'
        int rightLimit = 122; // letter 'z'

        return RANDOM.ints(leftLimit, rightLimit + 1).limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String getRandomEmailOfMaxLength() {
        return getString(64) + "@" + getString(63)
                + "." + getString(63) + "." + getString(61);
    }

    public static String getRandomPhoneNumber() {
        int num1 = (RANDOM.nextInt(7) + 1) * 100 + (RANDOM.nextInt(8) * 10) + RANDOM.nextInt(8);
        int num2 = RANDOM.nextInt(743);
        int num3 = RANDOM.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000");
        DecimalFormat df4 = new DecimalFormat("0000");

        return df3.format(747) + "-" + df3.format(num2) + "-" + df4.format(num3);
    }

}
