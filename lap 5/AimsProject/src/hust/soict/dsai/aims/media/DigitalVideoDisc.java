package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private int id;

    // Constructor rỗng
    public DigitalVideoDisc() {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    
    // Constructor 1 tham số
    public DigitalVideoDisc(String title) {
        this(); // gọi constructor rỗng
        this.title = title;
    }

    // Constructor 3 tham số
    public DigitalVideoDisc(String category, String title, float cost) {
        this();
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // Constructor 4 tham số
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // Constructor đầy đủ
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
public void play() throws PlayerException {
    if (this.getLength() <= 0) {
        System.err.println("ERROR: DVD length is non-positive!"); [cite: 1451]
        throw new PlayerException("ERROR: DVD length is non-positive!"); [cite: 1451, 1456]
    }
    // Logic phát DVD thông thường của bạn viết tiếp ở dưới đây...
    System.out.println("Playing DVD: " + this.getTitle());
    System.out.println("DVD length: " + this.getLength());
}
}

