package com.semantyca.test;

public class RegEx {

    public static void main(String[] args) {

        String example = " ,,,, 00500 ,,,3564654 ";
        System.out.println(trimPostalCodes(example));
    }


    protected static String trimPostalCodes(String postalCodes) {
        String text1 = postalCodes.replaceAll("[\\s]", ",").replaceAll(",+", ",");
        System.out.println(text1);
        String text2 = text1.replaceAll("^,*", "");
        System.out.println("text2=" + text2);
        String text3 = text2.replaceAll(",\\s+", ",");
        System.out.println("text3=" + text3);
        String text4 = text3.replaceAll("\\s+", ",");
        return text4;
    }
}
