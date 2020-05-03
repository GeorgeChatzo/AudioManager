package gr.excercise.codehub;

import java.util.Date;

public class ImageFile extends FileType {

    private int height;
    private int width;
    private String takenBy;

    public ImageFile(String filename, int size, String description, int height , int width ,
                     String takenBy, Date date) {
        super(filename, size, description,date);
        this.height = height;
        this.width = width;
        this.takenBy = takenBy;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", type : Image, " +
                "height =" + height +
                ", width =" + width +
                ", takenBy ='" + takenBy + '\'' +
                '}';
    }
}
