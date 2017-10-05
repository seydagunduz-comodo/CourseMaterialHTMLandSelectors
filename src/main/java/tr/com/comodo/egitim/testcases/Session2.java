package tr.com.comodo.egitim.testcases;


import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tr.com.comodo.egitim.base.BaseUITestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Session2 extends BaseUITestCase {

    private List<WebElement> menuItems;

    @Before
    public void beforeMethod(){
        super.beforeMethod();
    }

    @Test
    public void findById() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement reference = driver.findElement(By.id("topnavbtn_references"));
        System.out.println("reference: " + reference.getText());
    }

    @Test
    public void findByIdII() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement reference = driver.findElement(By.cssSelector("a[id='topnavbtn_references']"));
        System.out.println("reference: " + reference.getText());
    }

    @Test
    public void findByIdIII() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement reference = driver.findElement(By.cssSelector("a#topnavbtn_references"));
        System.out.println("reference: " + reference.getText());
    }

    @Test
    public void findByIdIV() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement reference = driver.findElement(By.cssSelector("#topnavbtn_references"));
        System.out.println("reference: " + reference.getText());
    }

    @Test
    public void findByIdV() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement reference = driver.findElement(By.cssSelector("[id='topnavbtn_references']"));
        System.out.println("reference: " + reference.getText());
    }

    @Test
    public void findByClass() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement example = driver.findElement(By.cssSelector(".w3-example"));
        System.out.println("reference: " + example.getText());
    }

    @Test
    public void readTable() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement table = driver.findElement(By.cssSelector("table[class='w3-table-all notranslate']"));
        List<WebElement> rows = table.findElements(By.cssSelector("tr"));
        System.out.println("row: " + rows.get(1).getText());
    }


    @Test
    public void asdas() {
        driver.get("https://stackoverflow.com/");
        WebElement element = driver.findElement(By.cssSelector("div#question-mini-list"));
        WebElement divVote = element.findElement(By.cssSelector("div[class='votes']")).findElement(By.cssSelector("span"));
        System.out.println(divVote.getText());
    }


    @Test
    public void multipleAttribute() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("div[id='leftmenuinnerinner'][class='w3-light-grey']"));
    }


    @Test
    public void walkingUpDOM() {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement male = driver.findElement(By.xpath("//input[@value='Male']")).findElement(By.xpath(".."));
        System.out.println(male.getText());
    }

    @After
    public void afterMethod(){
        super.afterMethod();
    }
}

