package gr.excercise.codehub;

import java.util.HashMap;

public class RecognizeFileType {

    String filename;
    //Supported files extensions
    HashMap<String,Type> extension = new HashMap<>();

    public RecognizeFileType(String filename){
        this.filename = filename;
    }

    public Type splitFileName(){

        //supported extension file type
        extension.put("jpg",Type.IMAGE); //-> image file
        extension.put("png",Type.IMAGE); //-> image file
        extension.put("mp4",Type.VIDEO); //-> video file
        extension.put("wav",Type.AUDIO); //-> sound file

        String ext = "";
        int i = this.filename.lastIndexOf('.');
        if(i>=0){
            ext = this.filename.substring(i+1);
        }else{
            return Type.NOT_SUPPORTED;
        }

        if(extension.containsKey(ext)){
            return extension.get(ext);
        }else{
            return Type.NOT_SUPPORTED;
        }

    }

}
