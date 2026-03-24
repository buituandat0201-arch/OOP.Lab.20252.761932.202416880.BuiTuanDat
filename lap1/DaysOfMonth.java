import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = -1;
        int year = -1;

        // Vòng lặp yêu cầu người dùng nhập cho đến khi dữ liệu hợp lệ
        while (true) {
            System.out.print("Vui lòng nhập tháng (VD: January, Jan., Jan, hoặc 1): ");
            String monthInput = scanner.nextLine().trim();
            
            System.out.print("Vui lòng nhập năm (VD: 1999): ");
            String yearInput = scanner.nextLine().trim();

            month = getMonthNumber(monthInput);
            year = getYearNumber(yearInput);

            // Kiểm tra tính hợp lệ: tháng phải từ 1-12 và năm phải >= 0
            if (month != -1 && year >= 0) {
                break; // Thoát vòng lặp nếu nhập đúng
            } else {
                System.out.println("Tháng hoặc năm không hợp lệ. Vui lòng nhập lại!\n");
            }
        }

        // Tính toán số ngày trong tháng
        int days = 0;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                // Công thức tính năm nhuận theo yêu cầu đề bài
                boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                days = isLeapYear ? 29 : 28;
                break;
        }

        System.out.println("Số ngày của tháng " + month + " năm " + year + " là: " + days + " ngày.");
        scanner.close();
    }

    // Hàm phụ trợ để chuyển đổi chuỗi nhập vào thành số thứ tự tháng (1-12)
    private static int getMonthNumber(String monthInput) {
        // Chuyển toàn bộ chuỗi về chữ thường để dễ dàng so sánh
        switch (monthInput.toLowerCase()) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun.": case "jun": case "6": return 6;
            case "july": case "jul.": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1; // Trả về -1 nếu chuỗi không khớp với bất kỳ tháng nào
        }
    }

    // Hàm phụ trợ để chuyển đổi và kiểm tra chuỗi năm hợp lệ
    private static int getYearNumber(String yearInput) {
        try {
            int year = Integer.parseInt(yearInput);
            if (year >= 0) return year; // Năm phải là số không âm
        } catch (NumberFormatException e) {
            // Lỗi này xảy ra nếu người dùng nhập chữ thay vì số cho năm
        }
        return -1; // Trả về -1 nếu không hợp lệ
    }
}