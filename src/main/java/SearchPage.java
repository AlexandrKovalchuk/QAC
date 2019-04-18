import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by alex on 16/04/2019.
 */
public class SearchPage extends PageObject{

    @FindBy(xpath="/html/body/div[1]/div/main/div[4]/div/div[1]/div/div/div/div[3]")
    private WebElement firstRegistrationFilter;

    @FindBy(xpath="/html/body/div[1]/div/main/div[4]/div/div[1]/div/div/div/div[3]/div[2]/div/select")
    private WebElement firstRegistrationFilterDropdownClick;

    @FindBy(name = "sort")
    private WebElement sortByPrice;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstRegistration(String firstRegistrationYear){
        this.firstRegistrationFilter.click();
        this.firstRegistrationFilterDropdownClick.click();
        this.firstRegistrationFilterDropdownClick.findElement(By.xpath("//*[contains(text(), '" + firstRegistrationYear + "')]")).click();

        }

    public void setPriceOrder(String typeOrder){
        this.sortByPrice.click();
        this.sortByPrice.findElement(By.xpath("//*[contains(text(), '" + typeOrder + "')]")).click();
    }

    public int[] firstRegistrationList(){
        List<WebElement> firstRegistrationList = driver.findElements(By.className("item___T1IPF"));
        int[] a = new int[firstRegistrationList.size()];
        int i = 0;
        for(WebElement w: firstRegistrationList){
            String date = w.findElement(By.className("specItem___2gMHn")).getText();
            a[i] = Integer.parseInt(date.substring(5,9));
            i++;
        }
        return a;
    }

    public float[] totalPriceList(){
        List<WebElement> totalPriceList = driver.findElements(By.className("totalPrice___3yfNv"));

        float[] a = new float[totalPriceList.size()];
        int i = 0;
        for(WebElement w : totalPriceList){
            a[i] = Float.valueOf(w.getText().substring(0,w.getText().length()-2));
            i++;
        }
        return a;
    }

    public void closeWindow() {
        driver.close();
    }

}
