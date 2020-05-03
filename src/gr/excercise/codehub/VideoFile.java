package gr.excercise.codehub;

import java.util.Date;

public class VideoFile extends FileType {

    private int duration;
    private PictureQuality quality;

    public VideoFile(String filename, int size, String description, int duration,
                     PictureQuality quality, Date date) {
        super(filename, size, description,date);
        this.duration = duration;
        this.quality = quality;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public PictureQuality getQuality() {
        return quality;
    }

    public void setQuality(PictureQuality quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Type : Video, " +
                "duration = " + duration + " in sec" +
                ", quality = " + quality +
                '}';
    }
}
