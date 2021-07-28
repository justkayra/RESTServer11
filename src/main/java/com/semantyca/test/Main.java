package com.semantyca.test;
class Main {
    public static void main (String[] args) {
        String message = "Hello world!";
        String newMessage = message.substring(6, 12)
                + message.substring( 6, 12);
        System.out.println(newMessage);
    }
}
