import java.util.List;

public class GeniusSongDataQueryImplTest {
    private DatasetQuery<GeniusSong> queryEngine;
    private List<GeniusSong> testDataset;
 
    public void setUp() {
        // Create a test dataset
        testDataset = new ArrayList<>();
 // Add sample taxi trips to the test dataset
        testDataset.add(new TaxiTrip("2019-01-01 12:00:00", "2019-01-01 12:30:00", 1, 5.2, 15.5, "credit", 1, 2));
        testDataset.add(new TaxiTrip("2019-01-01 13:00:00", "2019-01-01 13:45:00", 2, 7.8, 25.0, "cash", 3, 4));
        testDataset.add(new TaxiTrip("2019-01-01 14:00:00", "2019-01-01 14:20:00", 1, 3.5, 12.5, "credit", 5, 6));
        // Add more test data...
// Initialize the query engine with the test dataset
        queryEngine = new NYCTaxiDataQueryImpl(testDataset);
 }
 
 //test
    public void testExactMatchQuery() {
        // Test exact match for payment_type = "credit"
        List<GeniusSong> results = 
        queryEngine.exactMatchQuery("payment_type", "credit");
        // Assert that the correct number of results is returned
        assertEquals(2, results.size());
        // Assert that all results have the expected payment_type
        for (GeniusSong song : results) {
        assertEquals("credit", song.getPaymentType());
 }
 }
 
//test
    public void testRangeQuery() {
        // Test range query for 10.0 <= fare_amount <= 20.0
        List<TaxiTrip> results = queryEngine.rangeQuery("fare_amount",
        10.0, 20.0);
        // Assert that the correct number of results is returned
        assertEquals(2, results.size());
        // Assert that all results are within the expected range
        for (TaxiTrip trip : results) {
            double fareAmount = trip.getFareAmount();
            assertTrue(fareAmount >= 10.0 && fareAmount <= 20.0);
        }
}
}
