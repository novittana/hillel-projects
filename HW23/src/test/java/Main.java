import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Main {

    WebDriver driver;

    @BeforeClass
    public static void setUpDriver() {
        final String PATH = String.format("%s/bin/chromedriver.exe",
                System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", PATH);
    }

    @Before
    public void precondition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        String userName = "Name" + Util.getRandomPrefix(false);
        String userLastName = "Last" + Util.getRandomPrefix(false);
        String userEmail = userName + "_" + userLastName + "@test.com";
        String userPassword = "pass" + Util.getRandomPrefix(true);
        int carMileage = (int) Math.floor(Math.random() * 100 + 1);
        int expenseMileage = carMileage + 5;

        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        Thread.sleep(2000);

        WebElement signUpButton = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/app-header/header/div/div/div[2]/button[2]"));
        signUpButton.click();

        WebElement registrationBtn = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-signin-modal/div[3]/button[1]"));
        registrationBtn.click();

        WebElement signupName = driver.findElement(By.id("signupName"));
        signupName.sendKeys(userName);

        WebElement signupLastName = driver.findElement(By.id("signupLastName"));
        signupLastName.sendKeys(userLastName);

        WebElement signupEmail = driver.findElement(By.id("signupEmail"));
        signupEmail.sendKeys(userEmail);

        WebElement signupPassword = driver.findElement(By.id("signupPassword"));
        signupPassword.sendKeys(userPassword);

        WebElement signupRepeatPassword = driver.findElement(By.id("signupRepeatPassword"));
        signupRepeatPassword.sendKeys(userPassword);

        WebElement registerButton = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-signup-modal/div[3]/button"));
        registerButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement myProfileButton =  driver.findElement(By.id("userNavDropdown"));
        myProfileButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement profileButton = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/app-header/header/div/div/app-user-nav/div/nav/div[1]/a[1]"));
        profileButton.click();

        String userNameInProfile = driver.findElement(By.cssSelector("div.profile>p")).getText();
        String userNameOnPage = userNameInProfile.split(" ")[0];
        String userLastNameOnPage = userNameInProfile.split(" ")[1];

        Assert.assertEquals("User name not matched", userName, userNameOnPage);
        Assert.assertEquals("User name not matched", userLastName, userLastNameOnPage);

//        if (userName.equals(userNameOnPage)){
//            System.out.println("User name matched");
//        } else{
//            System.out.println("User name not matched");
//        }
//
//        if (userLastName.equals(userLastNameOnPage)){
//            System.out.println("User lastname matched");
//        } else{
//            System.out.println("User lastname not matched");
//        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        myProfileButton.click();

//        Garage

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement garageHeaderButton = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/app-header/header/div/div/app-user-nav/div/nav/a[1]"));
        garageHeaderButton.click();
//
//        Add car

        WebElement addCarButton = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/div/app-panel-layout/div/div/div/div[2]/div/app-garage/div/div[1]/button"));
        addCarButton.click();

        WebDriverWait waitAddForm = new WebDriverWait(driver, 60);
        waitAddForm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addCarBrand\"] | //*[@id=\"addCarModel\"]")));

        WebElement addCarMileage = driver.findElement(By.id("addCarMileage"));
        addCarMileage.sendKeys(Integer.toString(carMileage));

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement addButton = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-car-modal/div[3]/button[2]"));
        addButton.click();

//      Add fuel expence

        WebElement addFuelExpenseButton = driver.findElement(By.xpath("//*[@class='car_actions']/button[2]"));
        addFuelExpenseButton.click();

        WebDriverWait waitFuelForm = new WebDriverWait(driver, 60);
        waitFuelForm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addExpenseCar\"] | //*[@id=\"addExpenseDate\"] | //*[@id=\"addExpenseMileage\"] | //*[@id=\"addExpenseLiters\"] | //*[@id=\"addExpenseTotalCost\"]")));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement addExpenseMileage = driver.findElement(By.id("addExpenseMileage"));
        addExpenseMileage.sendKeys(Integer.toString(expenseMileage));

        WebElement addExpenseLiters = driver.findElement(By.id("addExpenseLiters"));
        addExpenseLiters.sendKeys("50");

        WebElement inputAddExpenseTotalCost = driver.findElement(By.id("addExpenseTotalCost"));
        inputAddExpenseTotalCost.sendKeys("2500");

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement addButton2 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-expense-modal/div[3]/button[2]"));
        addButton2.click();

//        Deleting profile

        myProfileButton.click();

        WebElement settingsHeaderButton =  driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/app-header/header/div/div/app-user-nav/div/nav/div[1]/a[2]"));
        settingsHeaderButton.click();

        WebElement removeMyAccountButton = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/div/app-panel-layout/div/div/div/div[2]/div/app-settings/div/div[2]/div/div[5]/div/button"));
        removeMyAccountButton.click();

        WebElement removeButton = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-remove-account-modal/div[3]/button[2]"));
        removeButton.click();

        Thread.sleep(2000);

        driver.close();
    }
}
