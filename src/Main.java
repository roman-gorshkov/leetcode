import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] massive2 = create(150);
        int[] massive3 = new int[]{11, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        String[] massive4 = new String[]{"Даниил", "Роман", "Вова"};
        int[] massive5 = new int[]{10, 10, 10};
        int[] massive6 = new int[]{3,5,15,22};
        System.out.println(Arrays.toString(create(150)));
        stroka(massive4);
        System.out.println(sum(massive3));
        fizzBuzz(massive6);
    }

    //на взод массив чисел если число делится на 3 то в консоль нужно записать fizz если число делится на 5 то нужно написать buzz
    //если число делится и на 3 и на 5 то в консоль нужно написать fizz buzz если число не делится на эти число то пошёл ты нахуй уебан
    public static void fizzBuzz(int[] chisla) {
        for (int i = 0; i < chisla.length; i++) {
            if (chisla[i] % 3 == 0 && chisla[i] % 5 == 0) {
                System.out.println("fizz buzz");
            }
            else if (chisla[i] % 3 == 0) {
                System.out.println("fizz");
            }
            else if (chisla[i] % 5 == 0) {
                System.out.println("buzz");
            }
            else {
                System.out.println("пошёл ты нахуй уебан");
            }
        }

    }

    public static void stroka(String[] array2) {
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }

    public static int sum(int[] massiveSum) {
        int b = 0;
        for (int i = 0; i < massiveSum.length; i++) {
            b = b + massiveSum[i];
        }
        return b;
    }


    //На вход массив целых чисел на выход колличество нечетных числе в заданном масиве
    public static int odd(int[] array) {
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                a++;
            }
        }
        return a;
    }


    public static int[] create(int n) {
        int[] massive = new int[n];
        for (int i = 0; i < n; i++) {
            massive[i] = i;
        }
        return massive;
    }

}