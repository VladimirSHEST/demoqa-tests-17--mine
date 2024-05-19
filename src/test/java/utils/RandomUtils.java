package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static void main(String[] args) {
        String[] names = {"a", "b", "c", "d", "e",};  // вспомогательный массив букв для рандома
        System.out.println(randomItem(names));
    }

    public static String randomString(int len) {   // метод для рандом имени
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomEmail() {   // метод для рандом мейла
        return randomString(10) + "@mail.ru";
    }


    public static int randomInt(int min, int max) {  //  рандом чмсла от...до
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomItem(String[] values) {
        // возвращает рандом букву из массива букв
        int index = randomInt(0, values.length-1);  // рандом число 0-4
        return values[index];  // возвращает букву под рандом числом 0-4
    }
}
