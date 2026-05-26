package hust.soict.dsai.aims.media;

import java.util.ArrayList;

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
    public void play() {
        System.out.println("Playing CD by: " + this.getArtist());
        System.out.println("Total CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
}