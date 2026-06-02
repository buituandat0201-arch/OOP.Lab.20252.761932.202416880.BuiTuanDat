package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Phục vụ cho Câu 12
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {}

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Yêu cầu tự tạo Getter và Setter cho các thuộc tính ở đây...
    public String getTitle() { return title; }
    // ... (Thêm các getter/setter khác)

    // Câu 10: Override equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false;
        Media media = (Media) obj;
        return title != null && title.equals(media.getTitle());
    }
    @Override
public boolean equals(Object obj) {
    // 1. Kiểm tra nếu cùng trỏ vào một vùng nhớ thì chắc chắn bằng nhau
    if (this == obj) {
        return true;
    }
    
    // 2. Chống lỗi NullPointerException nếu đối tượng truyền vào bị rỗng 
    if (obj == null) {
        return false;
    }
    
    // 3. Chống lỗi ClassCastException bằng toán tử instanceof [cite: 1507, 1508]
    if (!(obj instanceof Media)) {
        return false;
    }
    
    // 4. Ép kiểu và thực hiện so sánh theo tiêu đề (Title) 
    Media other = (Media) obj;
    if (this.title == null) {
        return other.title == null;
    }
    
    return this.title.equalsIgnoreCase(other.title);
}
}