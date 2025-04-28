public class GeniusSong {
    private String title;
    private String tag;
    private String artist;
    private int year;
    private int views;
    private String features;
    private String lyrics;
    private int id;
    private String language_cld3;
    private String language_ft;
    
 // Constructor
    public GeniusSong(String title, String tag, String artist, int year, int views,
        String features, String lyrics, int id, String language_cld3, String language_ft) {
        this.title = title;
        this.tag = tag;
        this.year = year;
        this.artist = artist;
        this.views = views;
        this.features = features;
        this.lyrics = lyrics;
        this.id = id;
        this.language_cld3 = language_cld3;
        this.language_ft = language_ft;
        
 }
 
 // Getters
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getTag() { return tag; }
    public int getYear() { return year; }
    public double getViews() { return views; }
    public String getFeatures() { return features; }
    public String getLyrics() { return lyrics; }
    public int getId() { return id; }
    public String getLanguageCld3() { return language_cld3; }
    public String getLanguageFt() { return language_ft; }

 
 @Override
    public String toString() {
        return "GeniusSong{" +
        "title='" + title + '\'' +
        ", tag='" + tag + '\'' +
        "artist='" + artist + '\'' +
        ", year=" + year +
        ", views=" + views +
        ", features=" + features +
        ", lyrics='" + lyrics + '\'' +
        ", id=" + id +
        ", languageCld3=" + language_cld3 +
        ", languageft=" + language_ft +
        '}';
        }
 }
 
