package FinalProject;


import java.util.*;
import java.io.*;

public class GeniusQueriesIMPL implements GeniusQueriesADT{
   public List<GeniusSong> rangeQuery( int startYear, int endYear){

 List<GeniusSong> listofsongs = new ArrayList<>();
    for (Map.Entry<Integer, List<GeniusSong>> row  : songsTreeMap.subMap(startYear, true, endYear, true).entrySet()) {
        listofsongs.addAll(row.getValue()); 
    }
    return listofsongs;

    }

    public void appendingSong(GeniusSong song) {
        songsTreeMap.putIfAbsent(song.getYear(), new ArrayList<>());
        songsTreeMap.get(song.getYear()).add(song);
    }


  public  double averageViewQuery(int startYear, int endYear, String tag){
        return 0.0;
    }
  public  List<String> exactMatchQuery(String artist, int year){
        return new ArrayList<>();
    }

   public int loadDataset(String filePath) throws IOException{
        return 0;
    }

}
