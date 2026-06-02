package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo cost giảm dần (đưa m2 lên trước m1)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        
        // Nếu cost khác nhau thì trả về kết quả so sánh cost
        if (costCompare != 0) {
            return costCompare;
        }
        
        // Nếu cost bằng nhau, tiếp tục so sánh title theo thứ tự bảng chữ cái (A-Z)
        return m1.getTitle().compareTo(m2.getTitle());
    }
}