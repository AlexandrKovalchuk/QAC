import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by alex on 18/04/2019.
 */
public class tester {
    protected static WebDriver driver;
    private static String yearFilterList = "2015";
    private static String priceOrderType = "Höchster Preis";

    public static void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\alex\\eclipse-workspace\\selenium_tutorials\\geckodriver-v0.21.0-win64\\geckodriver.exe");

        String url = "https://www.autohero.com/de/search/";
        driver = new FirefoxDriver();
        driver.get(url);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.setFirstRegistration(yearFilterList);
        searchPage.setPriceOrder(priceOrderType);
        pause(5000);
        int[] yearRegistrationList = searchPage.firstRegistrationList();
        boolean  correcrYear = true;
        for(int i = 0; i < yearRegistrationList.length; i++){
            if(yearRegistrationList[i] < Integer.parseInt(yearFilterList)){
                correcrYear = false;
            }
            System.out.println("year " + yearRegistrationList[i]);
            System.out.println("is year correct " + correcrYear);
        }

        float[] descendingPriceList = searchPage.totalPriceList();
        boolean correct = true;
        for(int i = 1; i < descendingPriceList.length; i++){
            if(descendingPriceList[i] > descendingPriceList[i - 1]){

                correct = false;
            }
            //System.out.println("price " + descendingPriceList[i-1]);
            //System.out.println(" is correct " + correct);
        }
        //System.out.println("Price list size" + searchPage.totalPriceList().size());
    }


    public static void verifyAllCarsAreFilteredByFirstRegistration(){

    }

    public void testTest(){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.setFirstRegistration(yearFilterList);
        System.out.println("first test");
    }

    public static void main(String[] args){
        setUp();
    }
}
