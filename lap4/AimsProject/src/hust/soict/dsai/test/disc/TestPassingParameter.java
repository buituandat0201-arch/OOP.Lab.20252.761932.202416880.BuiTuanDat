package hust.soict.dsai.test.Disc;

import disc.DigitalVideoDisc;
public class TestPassingParameter {

    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        DigitalVideoDisc temp = o1;
        o1 = o2;
        o2 = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);
    }

    public static void main(String[] args) {

        DigitalVideoDisc jungle = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderella = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("Jungle title: " + jungle.getTitle());
        System.out.println("Cinderella title: " + cinderella.getTitle());

        swap(jungle, cinderella);

        System.out.println("\nAfter swap:");
        System.out.println("Jungle title: " + jungle.getTitle());
        System.out.println("Cinderella title: " + cinderella.getTitle());

        changeTitle(jungle, "Jungle Updated");

        System.out.println("\nAfter changeTitle:");
        System.out.println("Jungle title: " + jungle.getTitle());
    }
}