package Pages;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;


public class Homepage {
    AndroidDriver driver;
    public Homepage(AndroidDriver driver){
    this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")
    private WebElement countrySelect;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[10]")
    private WebElement countryName;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")
    private WebElement countrName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Name']")
    private WebElement nameCheck;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")
    private WebElement nameSelect;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
    private  WebElement femaleOption;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]")
    private  WebElement maleOption;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")
    private WebElement signIn;

    public void clickCountry(){
        countrySelect.click();
    }
    public void setCountryName() throws InterruptedException {
        Thread.sleep(5000);
        countryName.click();
    }
    public void namecheck(String actualName){
        String expectedName = nameCheck.getAttribute("Text");
        assertEquals(expectedName,actualName);
    }
    public void setNameSelect(String name){
        nameSelect.sendKeys(name);
    }
    public void setGender(String gender){
        if(gender.contains("female")){
            femaleOption.click();
        }
        else
            maleOption.click();
    }
    public void setSignIn(){
        signIn.click();
    }

}
