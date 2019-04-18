import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SearchPageTest {
    private static SeleniumConfig config;
    private static String url = "https://www.autohero.com/de/search/";
    private static SearchPage searchPage = new SearchPage(config.getDriver());
    private static String yearFilterList = "2015";

    public static void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @BeforeClass
    public void setUp(){
        config.getDriver().get(url);
        searchPage.setFirstRegistration(yearFilterList);
        searchPage.setPriceOrder("Höchster Preis");
        pause(5000);
        System.out.println("Set Up");
    }

    @Test
    public void verifyIfFirstRegistrationYearHigherOrEcualToFilter(){
        int[] yearRegistrationList = searchPage.firstRegistrationList();
        boolean  correcrYear = true;
        for(int i = 0; i < yearRegistrationList.length; i++){
            if(yearRegistrationList[i] < Integer.parseInt(yearFilterList)){
                correcrYear = false;
            }
            System.out.println("year " + yearRegistrationList[i]);
            System.out.println("is year correct " + correcrYear);
        }

        assertEquals(true, correcrYear);
    }


    @Test
    public void verifyIfPriceOrderDescend(){
        float[] descendingPriceList = searchPage.totalPriceList();
        boolean correct = true;
        for(int i = 1; i < descendingPriceList.length; i++){
            if(descendingPriceList[i] > descendingPriceList[i - 1]){

                correct = false;
            }
            System.out.println("price " + descendingPriceList[i-1]);
            System.out.println(" is correct " + correct);
        }
        assertEquals(true, correct);
    }

    @AfterClass
    public static void tearDown() {
        searchPage.closeWindow();
    }

}