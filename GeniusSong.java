package FinalProject;

public class GeniusSong {
    private double views;
    private String title;
    private int year;
    private String artist;


    public GeniusSong(String title, String artist, int year, double views){
        this.title=title;
        this.artist=artist;
        this.year = year;
        this.views=views;
    }

    public String getTitle() {
        return title;
    }
    public int getYear(){
        return year;
    }

    public String getArtist(){
        return artist;
    }
    public double getViews(){
        return views;
    }





}



