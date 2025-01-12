import java.util.Scanner;

public class Fibonacci implements Runnable {
    private final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        if (n < 3) {
            System.out.println("Inserte un número mayor que 2");
        } else {
            int nminusone = 1;
            int nminustwo = 1;
            System.out.println("1: 1");
            System.out.println("2: 1");

            for (int i = 3; i <= n; i++) {
                int current = nminusone + nminustwo;
                System.out.println(i + ": " + current);
                nminustwo = nminusone;
                nminusone = current;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número mayor que 2: ");

        try {
            int number = scanner.nextInt();
            if (number <= 2) {
                System.out.println("Por favor, ingrese un número mayor que 2.");
            } else {
                Thread thread = new Thread(new Fibonacci(number));
                thread.start();
            }
        } catch (Exception e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
        } finally {
            scanner.close();
        }
    }
}
