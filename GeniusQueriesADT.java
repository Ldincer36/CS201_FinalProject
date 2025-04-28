import java.io.IOException;
import java.util.*;

public interface GeniusQueriesADT {
    /**
     * Loads the Genius Song dataset from the specified file path.
     * @param filePath Path to the dataset file (CSV/JSON/XML format)
     * @return Number of records loaded
     * @throws IOException If there's an error reading the file
     */
    int loadDataset(String filePath) throws IOException;

    /**
     * Returns all songs (name) that exactly match the artist and year.
     * @param artist The artist of the song
     * @param year The year of the song
     * @return A List of songs (name) matching the criteria
     */
    public default List<String> exactMatchQuery(String artist, int year){
        /*
        List<String> listofsongs = new ArrayList<>();
        Map<Integer, String> newMap = new HashMap<>(songsHashMap);
        newMap.keySet().retainAll(artist);
        newMap.valueSet().retainAll(year); 
        
        List<String> listofsongs = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> row  : songsHashMap.entrySet().retainAll(year)) {
            for(Song song : entry.getValue()){
                if(song.getArtist().equalsIgnoreCase(artist)){
                    listofsongs.add(song);
                }
            }
    }
            */
           
        List<String> listOfSongs = new ArrayList<>();
    
        for (Map.Entry<Integer, List<GeniusSong>> entry : songsHashMap.entrySet()) {
            if (entry.getKey() == year) {
                for (GeniusSong song : entry.getValue()) {
                    if (song.getArtist().equalsIgnoreCase(artist)) {
                        listOfSongs.add(song.getTitle()); 
                    }
                }
            }
        }
    
        return listOfSongs;
            }
            


    /**
     * Returns all songs where the year falls within the given range.
     * @param startYear The lower bound of the range (inclusive)
     * @param endYear The upper bound of the range (inclusive)
     * @return A collection of songs matching the criteria
     */
    
    public default List<String> rangeQuery(int startYear, int endYear){

        List<String> listofsongs = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> row  : songsTreeMap.subMap(startYear, true, endYear, true).entrySet()) {
            listofsongs.addAll(row.getValue()); 
        }
        return listofsongs;

}






    /**
     * Returns the average value of the views
     * @param String The tag (genre)
     * @param startTime The start time of the period (inclusive)
     * @param endTime of the period (inclusive)
     * @return The statistic calculated */
    public default double averageViewQuery(int startYear, int endYear, String tag){
        int totalViews = 0;
        int count = 0;
        List<String> listofsongs = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> row  : songsTreeMap.subMap(startYear, true, endYear, true).entrySet()) {
            for(Song song : entry.getValue()){
                if(song.getTag().equalsIgnoreCase(tag)){
                    totalViews += song.getViews();
                    count++;
                }
            }
    }
        if(count == 0){
            return 0.0;
        }
        return totalViews/count;
}





public static final TreeMap<Integer, List<String>> songsTreeMap = new TreeMap<>();
public static final HashMap<Integer, List<GeniusSong>> songsHashMap = new HashMap<>();


    public default void appendingSong(String songName, int year) {
        songsTreeMap.putIfAbsent(year, new ArrayList<>());
        songsTreeMap.get(year).add(songName);
        
}
    public default void appendingSongsHash(GeniusSong song, int year){
        songsHashMap.putIfAbsent(year, new ArrayList<>());
        songsHashMap.get(year).add(song);
    }
}




