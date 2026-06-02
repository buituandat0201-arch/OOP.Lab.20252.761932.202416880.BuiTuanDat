package Bai226;
import java.util.Scanner;

public class PTbac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap a: ");
        double a = sc.nextDouble();

        System.out.print("Nhap b: ");
        double b = sc.nextDouble();

        System.out.print("Nhap c: ");
        double c = sc.nextDouble();

        // Trường hợp a = 0 → thành bậc 1
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Vo so nghiem");
                } else {
                    System.out.println("Vo nghiem");
                }
            } else {
                double x = -c / b;
                System.out.println("Phuong trinh bac 1, nghiem x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Hai nghiem phan biet:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Nghiem kep x = " + x);
            } else {
                System.out.println("Vo nghiem (khong co nghiem thuc)");
            }
        }

        sc.close();
    }
}