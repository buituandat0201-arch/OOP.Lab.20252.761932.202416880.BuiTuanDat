package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Đã thêm track: " + track.getTitle());
        } else {
            System.out.println("Track đã tồn tại trong CD!");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xóa track: " + track.getTitle());
        } else {
            System.out.println("Không tìm thấy track!");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }


    @Override
public void play() throws PlayerException {
    if (this.getLength() <= 0) {
        System.err.println("ERROR: CD length is non-positive!");
        throw new PlayerException("ERROR: CD length is non-positive!"); [cite: 1485]
    }
    
    System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
    
    // Duyệt qua danh sách để phát từng Track nhạc
    for (Track track : tracks) {
        try {
            track.play(); [cite: 1479]
        } catch (PlayerException e) {
            // Ném ngoại lệ ra ngoài nếu gặp bất kỳ track nào lỗi thời lượng [cite: 1480, 1483, 1489]
            throw e; 
        }
    }
}
}