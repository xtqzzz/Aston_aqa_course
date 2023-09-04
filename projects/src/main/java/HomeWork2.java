public class HomeWork2 {
    public static void main(String[] args) {
        // System.out.println(firstMethod(1,19));
        // secondMethod(-1);
        // thirdMethod(-1);
        // fourthMethod("Nikita", 5);
        // System.out.println(fifthMethod(2017));
        // sixthMethod();
        // seventhMethod(100);
        // eighthMethod();
        // ninthMethod();
        // tenth(1, 5);
    }

    static boolean firstMethod(int a, int b) {
        System.out.println("Задание 1");
        int sum = a + b;
        if (sum >= 10 && sum <= 20) return true;
        else return false;
    }

    static void secondMethod(int c) {
        System.out.println("Задание 2");
        if (c >= 0) {
            System.out.println("Число" + c + "положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    static boolean thirdMethod(int d) {
        System.out.println("Задание 3");
        if (d < 0) return true;
        else return false;
    }

    static void fourthMethod(String str, int e) {
        System.out.println("Задание 4");
        for (int i = 0; i < e; i++) {
            System.out.println(str);
        }
    }

    static boolean fifthMethod(int a) {
        System.out.println("Задание 5");
        if (((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0)) {
            return true;
        } return false;
    }

    static void sixthMethod() {
            int[] arr = {1, 0, 1, 0, 1, 0, 1};
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    arr[i] = 0;
                } else {
                    arr[i] = 1;
                }
                System.out.println(arr[i]);
        }
    }

    public static void seventhMethod(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    public static void eighthMethod() {
    int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void ninthMethod() {
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, x = arr[i].length - 1; j < arr[i].length; j++, x--) {
                if (i == j || i == x) arr[i][j] = 1;
                else arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void tenth(int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            System.out.print("[" + i + "]" + arr[i] + " ");
        }
    }
}