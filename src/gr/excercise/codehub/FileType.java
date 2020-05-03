package gr.excercise.codehub;

import java.util.Date;

public class FileType {

    private int size;
    private String description;
    private String filename;
    private Date date;
    private int id;
    private static int nextID=1;

    public FileType(String filename, int size, String description, Date date){
        this.size = size;
        this.description = description;
        this.filename = filename;
        this.date = date;
        id = nextID++;

    }

    public int getID() {
        return id;
    }

    public Date getDate(){
        return date;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setName(String filename){
        this.filename = filename;
    }

    public String getName(){
        return filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "id = " + id + " " +
                "size= " + size + " in mb "+
                ", description='" + description + '\'' +
                ", filename='" + filename + '\'' +
                ", date=" + date;
    }
}
