import java.util.Scanner;
import java.util.Arrays;

public class SortingApp {

    // Metode Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Metode Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    public static int[] getInputArray(Scanner scanner) {
        while (true) {
            System.out.println("Masukkan elemen array (pisahkan dengan spasi): ");
            String input = scanner.nextLine();

            try {
                return Arrays.stream(input.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            } catch (NumberFormatException e) {
                System.out.println("Input salah. Pastikan hanya anda memasukkan angka");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n-SELAMAT DATANG DI APLIKASI SORTING-");
            System.out.println("== Aplikasi Sorting ==");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    int[] array = getInputArray(scanner);
                    System.out.println("Array sebelum sorting: " + arrayToString(array));
                    bubbleSort(array);
                    System.out.println("Array setelah Bubble Sort: " + arrayToString(array));
                }
                case 2 -> {
                    int[] array = getInputArray(scanner);
                    System.out.println("Array sebelum sorting: " + arrayToString(array));
                    selectionSort(array);
                    System.out.println("Array setelah Selection Sort: " + arrayToString(array));
                }
                case 3 -> {
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                }
                default -> System.out.println("Pilihan tidak valid. Silakan pilih nomor 1 - 3");
            }
        }

        scanner.close();
    }
}