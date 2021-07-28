package com.semantyca.test;

interface One {
    default void method() {
        System.out.println("One");
    }
}
