package FinalProject;

public class DriverClass {
    

    public static void main(String[] args) {
        GeniusQueriesADT obj = new GeniusQueriesIMPL();
        GeniusSong example = new GeniusSong("Killa Cam", "Cam'ron", 2004, 173166);
        obj.appendingSong(example);
    }
}
