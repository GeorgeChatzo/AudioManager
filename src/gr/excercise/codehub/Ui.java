package gr.excercise.codehub;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.*;

public class Ui {


    ArrayList<FileType> filesLoaded = new ArrayList<>();
    ArrayList<VideoFile> videoFiles = new ArrayList<>();
    ArrayList<ImageFile> imageFiles = new ArrayList<>();
    ArrayList<AudioFile> audioFiles = new ArrayList<>();

    public void inputAnalysis(){
        // C:\Users\GeorgeChatz\Desktop\AudioManager\src\gr\excercise\codehub\file.txt
        System.out.println("Give path: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] words = line.split(",");
            RecognizeFileType t = new RecognizeFileType(words[0]);
            Type result = t.splitFileName();

            switch(result){
                case IMAGE:
                    if(words.length==7) {
                        ImageFile image = new ImageFile(words[0], Integer.parseInt(words[1]), words[2], Integer.parseInt(words[3]), Integer.parseInt(words[4]), words[5],Date.valueOf(words[6]));
                        filesLoaded.add(image);
                        imageFiles.add(image);
                        System.out.println("Image file created");
                    }else{
                        System.out.println("Cannot initialize image object!");
                    }
                    break;
                case VIDEO:
                    if(words.length==6){
                        VideoFile video = new VideoFile(words[0],Integer.parseInt(words[1]),words[2],Integer.parseInt(words[3]),PictureQuality.valueOf(words[4]),Date.valueOf(words[5]));
                        filesLoaded.add(video);
                        videoFiles.add(video);
                        System.out.println("Video file created");
                    }else{
                        System.out.println("Cannot initialize video object!");
                    }
                    break;
                case AUDIO:
                    if(words.length==9) {
                        AudioFile audio = new AudioFile(words[0], Integer.parseInt(words[1]), words[2], Integer.parseInt(words[3]), words[4],
                                words[5], words[6], MusicCategory.valueOf(words[7]),Date.valueOf(words[8]));
                        filesLoaded.add(audio);
                        audioFiles.add(audio);
                        System.out.println("Audio file created");
                    }else{
                        System.out.println("Cannot initialize audio object!");
                    }
                    break;
                case NOT_SUPPORTED:
                    System.out.println("Not supported type...");
            }


        }

    }

    public void manageBase(){
        //start by getting input file from user
        //System.out.println("Give file name to load " +
          //      "audiovisual material: ");
        inputAnalysis();
        //after file is loaded main menu insertion
        mainMenu();

    }

    public void mainMenu(){

        int choice;

        do {
            System.out.println("\n");
            System.out.println("Basic functionality");
            System.out.println("1. View all files loaded");
            System.out.println("2. Add new file from url");
            System.out.println("3. Add new file from console");
            System.out.println("4. Remove file from already loaded");
            System.out.println("5. Save all files included the newly added");
            System.out.println("6. Calculate total size of all files");
            System.out.println("7. Display by input image video or audio");
            System.out.println("8. Search file by id");
            System.out.println("9. Search file max size");
            System.out.println("10. Search file max video duration");
            System.out.println("11. Search file max audio duration");
            System.out.println("0. Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    displayFilesLoaded();
                    break;
                case 2:
                    addNewFileUrl();
                    break;
                case 3:
                    addNewFile();
                case 4:
                    removeFile();
                    break;
                case 5:
                    saveNewFile();
                    break;
                case 6:
                    calculate();
                    break;
                case 7:
                    displayByInput();
                    break;
                case 8:
                    System.out.println("Select a valid id from: 1 - "+ filesLoaded.size());
                    Scanner scanner = new Scanner(System.in);
                    int input = scanner.nextInt();
                    searchById(input);
                    break;
                case 9:
                    FileType Msize = searchMaxSize();
                    System.out.println("Max file size found is: " + Msize.getSize());
                    break;
                case 10:
                    VideoFile vf = searchMaxDurationVideo();
                    System.out.println("Max video duration found is: " + vf.getDuration() );
                    break;
                case 11:
                    AudioFile af = searchMaxAudioDuration();
                    System.out.println("Max audio duration found is: " + af.getDuration());
            }

        }while(choice!=0);
    }

    public void displayFilesLoaded(){
        filesLoaded.forEach(System.out::println);
        System.out.println("\n");
    }

    public void addNewFileUrl(){

        System.out.println("Let's add a new file");
        System.out.println("Select File type location to add: ");
        inputAnalysis();

    }

    public void addNewFile(){
        System.out.println("Let's add a new file");
        System.out.println("Give file type you want to add: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        RecognizeFileType r = new RecognizeFileType(input);
        Type t = r.splitFileName();
        if(t==Type.IMAGE){
            String filename = input;
            System.out.println("Recognized as Image Type");
            System.out.println("Enter size in mb: ");
            int size = scanner.nextInt();
            System.out.println("Enter description: ");
            String description = scanner.next();
            System.out.println("Enter height: ");
            int height = scanner.nextInt();
            System.out.println("Enter width: ");
            int width = scanner.nextInt();
            System.out.println("Enter photographer: ");
            String takenBy = scanner.next();
            System.out.println("Enter Date: ");
            Date date = Date.valueOf(scanner.next());
            ImageFile image = new ImageFile(filename,size,description,height,width,takenBy,date);
            filesLoaded.add(image);
            imageFiles.add(image);

        }else if(t==Type.AUDIO){

            String filename = input;
            System.out.println("Recognized as Audio Type");
            System.out.println("Enter size in mb: ");
            int size = scanner.nextInt();
            System.out.println("Enter description: ");
            String description = scanner.next();
            System.out.println("Enter duration: ");
            int duration = scanner.nextInt();
            System.out.println("Enter Song name: ");
            String songName = scanner.next();
            System.out.println("Enter Song producer: ");
            String songProducer = scanner.next();
            System.out.println("Enter Song Album: ");
            String songAlbum = scanner.next();
            System.out.println("Enter category: ");
            MusicCategory category = MusicCategory.valueOf(scanner.next());
            System.out.println("Enter Date: ");
            Date date = Date.valueOf(scanner.next());
            AudioFile audio = new AudioFile(filename,size,description,duration,songName,songProducer
            ,songAlbum,category,date);
            filesLoaded.add(audio);
            audioFiles.add(audio);

        }else if(t==Type.VIDEO){

            String filename = input;
            System.out.println("Recognized as Video Type");
            System.out.println("Enter size in mb: ");
            int size = scanner.nextInt();
            System.out.println("Enter description: ");
            String description = scanner.next();
            System.out.println("Enter duration: ");
            int duration = scanner.nextInt();
            System.out.println("Enter picture quality: ");
            PictureQuality quality = PictureQuality.valueOf(scanner.next());
            System.out.println("Enter Date: ");
            Date date = Date.valueOf(scanner.next());
            VideoFile video = new VideoFile(filename,size,description,duration,quality,date);
            filesLoaded.add(video);
            videoFiles.add(video);
        }else{
            System.out.println("Input not recognized...");
        }
    }

    public void removeFile(){
        displayFilesLoaded();
        System.out.println("Select number to delete based on the id");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input<0 || input>filesLoaded.size()){
            System.out.println("Wrong input");
        }else{
            filesLoaded.remove(input);
            for(int i=0; i<imageFiles.size(); i++){
                if(imageFiles.get(i).getID()==input){
                    imageFiles.remove(imageFiles.get(i));
                }
            }

            for(int i=0; i<audioFiles.size(); i++){
                if(audioFiles.get(i).getID()==input){
                    audioFiles.remove(audioFiles.get(i));
                }
            }

            for(int i=0; i<videoFiles.size(); i++){
                if(videoFiles.get(i).getID()==input){
                    videoFiles.remove(videoFiles.get(i));
                }
            }

            System.out.println("Successfully removed");
        }
    }

    public void saveNewFile(){
        System.out.println("Give file name");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try {
            PrintWriter printWriter = new PrintWriter(new File(input));
            for (FileType f : filesLoaded) {
                printWriter.println(f.toString());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }
    }

    public void calculate(){
        System.out.println("Calculating total size");
        int TotalSize = 0;
        for (int i=0; i<filesLoaded.size(); i++){
            TotalSize += filesLoaded.get(i).getSize();
        }

        System.out.println("Total size files is: " + TotalSize + " in mb! ");
    }

    public void displayByInput(){
        System.out.println("Give image,video or audio to view each category!");
        System.out.println("Give input: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        if(input.equals("image")){
            imageFiles.forEach(System.out::println);
        }else if(input.equals("audio")){
            audioFiles.forEach(System.out::println);
        }else if(input.equals("video")){
            videoFiles.forEach(System.out::println);
        }else{
            System.out.println("Wrong input");
        }

    }

    public void searchById(int Id){
        filesLoaded.forEach(p->{
            if(p.getID()==Id){
                System.out.println(p.toString());
            }
        });
    }

    public FileType searchMaxSize(){
        return filesLoaded.stream()
                .max(Comparator.comparingInt(FileType::getSize)).get();
    }

    public FileType searchMinSize(){
        return filesLoaded.stream()
                .min(Comparator.comparingInt(FileType::getSize)).get();
    }

    public VideoFile searchMaxDurationVideo(){

         return videoFiles.stream().max(Comparator.comparingInt(VideoFile::getDuration)).get();

    }

    public AudioFile searchMaxAudioDuration(){
        return audioFiles.stream().max(Comparator.comparingInt(AudioFile::getDuration)).get();
    }

}
