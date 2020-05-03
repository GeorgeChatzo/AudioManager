package gr.excercise.codehub;

import java.util.Date;

public class AudioFile extends FileType{

    private int duration;
    private String songName;
    private String songProducer;
    private String songAlbum;
    private MusicCategory category;

    public AudioFile(String filename, int size, String description, int duration, String songName,
                     String songProducer, String songAlbum , MusicCategory category, Date date) {
        super(filename, size, description,date);
        this.songAlbum = songAlbum;
        this.songName = songName;
        this.songProducer = songProducer;
        this.category = category;
        this.duration = duration;
    }


    public MusicCategory getCategory() {
        return category;
    }

    public void setCategory(MusicCategory category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongProducer() {
        return songProducer;
    }

    public void setSongProducer(String songProducer) {
        this.songProducer = songProducer;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type : Audio," +
                " duration = " + duration + "in sec" +
                ", songName ='" + songName + '\'' +
                ", songProducer ='" + songProducer + '\'' +
                ", songAlbum ='" + songAlbum + '\'' +
                ", category =" + category +
                '}';
    }
}
