package edu.cityuniversity.warharness.service;

/**
 * @author rajarar
 */
public class Utilities {

    public static String toCamelcase(String str, String delimiter) {
        str = str.replaceAll("[^\\w\\s]","");
        String[] split = str.split(delimiter);
        String camelCaseString = "";
        for (String indi : split) {
            // CamelCase only if not empty
            if (!indi.isEmpty()) {
                camelCaseString = camelCaseString + toProperCase(indi);
            }
        }

        if (!camelCaseString.isEmpty() && Character.isDigit(camelCaseString.charAt(0))) {
            camelCaseString = "_" + camelCaseString;
        }

        return camelCaseString;
    }

    private static String toProperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

}
