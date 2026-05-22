import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Vui lòng nhập chiều cao của tam giác (n): ");
        int n = keyboard.nextInt();
        
        // Vòng lặp chạy qua từng dòng, từ dòng 1 đến dòng n
        for (int i = 1; i <= n; i++) {
            
            // In khoảng trắng ở đầu mỗi dòng để tạo hình chóp
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            
            // In các dấu sao (*)
            // Số lượng sao ở mỗi dòng là số lẻ: 1, 3, 5, 7... tức là (2*i - 1)
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            
            // Xuống dòng sau khi in xong khoảng trắng và dấu sao của dòng hiện tại
            System.out.println();
        }
        
        keyboard.close();
    }
}