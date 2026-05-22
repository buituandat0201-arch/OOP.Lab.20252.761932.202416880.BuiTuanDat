import disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {

        // Tạo giỏ hàng
        Cart anOrder = new Cart();

        // Tạo DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Thêm DVD
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // In tổng tiền
        System.out.println("Total cost is: " + anOrder.totalCost());

        // Test xóa
        anOrder.removeDigitalVideoDisc(dvd2);

        // In lại tổng tiền
        System.out.println("Total cost after removal: " + anOrder.totalCost());
    }
}