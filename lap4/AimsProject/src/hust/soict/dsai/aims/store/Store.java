package store;
import disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyInStore = 0;

    // Thêm DVD vào store
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore[qtyInStore++] = dvd;
        System.out.println("The disc \"" + dvd.getTitle() + "\" has been added to store");
    }

    // Xóa DVD khỏi store
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getTitle().equals(dvd.getTitle())) {

                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }

                itemsInStore[--qtyInStore] = null;

                System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed from store");
                return;
            }
        }

        System.out.println("The disc was not found in store");
    }
}
