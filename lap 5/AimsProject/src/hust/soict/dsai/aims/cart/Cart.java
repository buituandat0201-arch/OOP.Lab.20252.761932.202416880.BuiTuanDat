import disc.DigitalVideoDisc;
// Sửa đổi import sang thư viện JavaFX
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Bên trong class Cart, thay đổi kiểu dữ liệu của danh sách:
private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList(); [cite: 1264]

// Sửa lại kiểu trả về của hàm getter tương ứng:
public ObservableList<Media> getItemsOrdered() { [cite: 1251]
    return this.itemsOrdered;
}
// Bên trong class Cart, thay đổi kiểu dữ liệu của danh sách:
private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList(); [cite: 1264]

// Sửa lại kiểu trả về của hàm getter tương ứng:
public ObservableList<Media> getItemsOrdered() { [cite: 1251]
    return this.itemsOrdered;
}
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Thêm 1 DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added");
        } else {
            System.out.println("The cart is full");
        }
    }

    // Thêm nhiều DVD (varargs)
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            addDigitalVideoDisc(dvd);
        }
    }
    public DigitalVideoDisc searchById(int id) {
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].getId() == id) {
            return itemsOrdered[i];
        }
    }
    return null;
}

public DigitalVideoDisc searchByTitle(String title) {
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].getTitle().equals(title)) {
            return itemsOrdered[i];
        }
    }
    return null;
}
    // Xóa DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {

                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }

                itemsOrdered[--qtyOrdered] = null;

                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed");
                return;
            }
        }

        System.out.println("The disc was not found in the cart");
    }

    // Tính tổng tiền
    public float totalCost() {
        float sum = 0;

        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }

        return sum;
    }
    public void print() {
    System.out.println("***********************CART***********************");

    for (int i = 0; i < qtyOrdered; i++) {
        DigitalVideoDisc dvd = itemsOrdered[i];
        System.out.println((i + 1) + ". DVD - " 
            + dvd.getTitle() + " - " 
            + dvd.getCategory() + " - " 
            + dvd.getCost() + " $");
    }

    System.out.println("Total cost: " + totalCost() + " $");
    System.out.println("***************************************************");
}
}