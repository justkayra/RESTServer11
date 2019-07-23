package com.semantyca.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final Pattern uuidPattern = Pattern.compile("/^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$/");
    private static final Map<String, String> collation = new HashMap<String, String>();

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static boolean checkByPattren(String value, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean isUUID(String value) {
        return uuidPattern.matcher(value).matches();
    }



    public static String getRndText() {
        return genRndText("qwertyuiopasdfghjklzxcvbnm", 10);
    }

    public static String getRndText(int len) {
        return genRndText("qwertyuiopasdfghjklzxcvbnm", len);
    }

    public static String getRndColor() {
        Random rand = new Random();
        int myRandomNumber = rand.nextInt(0x10) + 0x10; // Generates a random number between 0x10 and 0x20
        //System.out.printf("%x\n",myRandomNumber); // Prints it in hex, such as "0x14"
        return Integer.toHexString(myRandomNumber);
    }

    public static String genRndText(String setOfTheLetters, int len) {
        Random r = new Random();
        String key = "";
        char[] letters = new char[setOfTheLetters.length() + 10];

        for (int i = 0; i < 10; i++) {
            letters[i] = Character.forDigit(i, 10);
        }

        for (int i = 0; i < setOfTheLetters.length(); i++) {
            letters[i + 10] = setOfTheLetters.charAt(i);
        }

        for (int i = 0; i < len; i++) {
            key += letters[Math.abs(r.nextInt()) % letters.length];
        }

        return key;
    }

    public static String cleanFromMarkdown(String text) {
        String resultText = text.replace("*", "").replace("**", "").replaceAll("`", "");

        return resultText;
    }

    public static int stringToInt(String d, int defaultValue) {
        return NumberUtil.stringToInt(d, defaultValue);
    }

    public static String kindToKeyword(String kind) {
        return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(kind), "_").toLowerCase();
    }





    public static String convertStringToURL(String text) {
        if (Pattern.matches(".*\\p{InCyrillic}.*", text)) {
            return convertRusToLat(text.trim()).replaceAll(" ", "_").toLowerCase();
        } else {
            return text;
        }
    }



    public static String convertRusToLat(String text) {
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            String l = text.substring(i, i + 1);
            if (collation.containsKey(l)) {
                sb.append(collation.get(l));
            } else {
                sb.append(l);
            }
        }
        return sb.toString();
    }



    static {
        collation.put("А", "A");
        collation.put("Б", "B");
        collation.put("В", "V");
        collation.put("Г", "G");
        collation.put("Д", "D");
        collation.put("Е", "E");
        collation.put("Ё", "E");
        collation.put("Ж", "ZH");
        collation.put("З", "Z");
        collation.put("И", "I");
        collation.put("Й", "I");
        collation.put("К", "K");
        collation.put("Л", "L");
        collation.put("М", "M");
        collation.put("Н", "N");
        collation.put("О", "O");
        collation.put("П", "P");
        collation.put("Р", "R");
        collation.put("С", "S");
        collation.put("Т", "T");
        collation.put("У", "U");
        collation.put("Ф", "F");
        collation.put("Х", "H");
        collation.put("Ц", "C");
        collation.put("Ч", "CH");
        collation.put("Ш", "SH");
        collation.put("Щ", "SH");
        collation.put("Ъ", "'");
        collation.put("Ы", "Y");
        collation.put("Ъ", "'");
        collation.put("Э", "E");
        collation.put("Ю", "U");
        collation.put("Я", "YA");
        collation.put("а", "a");
        collation.put("б", "b");
        collation.put("в", "v");
        collation.put("г", "g");
        collation.put("д", "d");
        collation.put("е", "e");
        collation.put("ё", "e");
        collation.put("ж", "zh");
        collation.put("з", "z");
        collation.put("и", "i");
        collation.put("й", "i");
        collation.put("к", "k");
        collation.put("л", "l");
        collation.put("м", "m");
        collation.put("н", "n");
        collation.put("о", "o");
        collation.put("п", "p");
        collation.put("р", "r");
        collation.put("с", "s");
        collation.put("т", "t");
        collation.put("у", "u");
        collation.put("ф", "f");
        collation.put("х", "h");
        collation.put("ц", "c");
        collation.put("ч", "ch");
        collation.put("ш", "sh");
        collation.put("щ", "sh");
        collation.put("ь", "'"); //fixed
        collation.put("ы", "y");
        collation.put("ъ", "'");
        collation.put("э", "e");
        collation.put("ю", "u");
        collation.put("я", "ya");
    }
}

