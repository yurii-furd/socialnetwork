package com.furd.socialnetwork;

import com.furd.socialnetwork.entities.Message;
import com.furd.socialnetwork.entities.User;

/**
 * TODO
 *
 * @author Anatolii Bed
 */
public class ExceptionsExample {

    public static void main(String[] args) {
        // Исключительные ситуации
        // Exception - виняток
        // Except - окрім

        // 1:
        // String name = null - java: ';' expected - помилка компіляції

        // 2:
        // String name = null;
        // name.length() - Exception in thread "main" java.lang.NullPointerException - помилка виконання, Runtime exception

        // приклади:
        // SQLException
        // NullPointerException
        // ArrayIndexOutOfBoundsException
        // StackOverflowError

        // NullPointerException
         String name = null;
        // int length = name.length();
        if (name != null) {
            int length = name.length();
        }


        // ArrayIndexOutOfBoundsException - ArrayIndex індекс масива OutOfBounds - за межами
        // int[] a = {1, 2};
        // int i = a[2];

        // StackOverflowError
        // recursiveExampleStackOverflow();

        // ClassCastException
        // Integer i = 5;
        // Object iAmString = i;
        // String str = (String) iAmString;

        // Теорі: помилки компіляції поділяються на дві категорії:
        // Checked Exceptions (чеккад ексепшенс - ті які треба опрацювати! тебе змушують прийняти рішення або обробити або кинути наверх) - помилки з комп*ютером, з мережою, з доступом до ресурсів
        // Unchecked Exceptions (анчеккад ексепшенс) - помилки програміста
        // Errors !!!

    }

    private static void recursiveExampleStackOverflow() {
        recursiveExampleStackOverflow();
    }

}
