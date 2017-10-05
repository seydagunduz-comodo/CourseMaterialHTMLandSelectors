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

public class Session3 extends BaseUITestCase {


    @Before
    public void beforeMethod(){
        super.beforeMethod();
    }

    @Test
    public void findById() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.id("topnavbtn_references"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByIdII() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("a[id='topnavbtn_references']"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByIdIII() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("a#topnavbtn_references"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByIdIV() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("#topnavbtn_references"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByIdV() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("[id='topnavbtn_references']"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByClass() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("div.w3-example"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void readTable() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("table[class='w3-table-all notranslate']"));
        List<WebElement> rows = element.findElements(By.cssSelector("tr"));
        System.out.println("rows: " + rows.get(1).getText());
        List<WebElement> dataCells = rows.get(1).findElements(By.cssSelector("td"));
        System.out.println("row 1 data 1: " + dataCells.get(1).getText() );
    }



    @Test
    public void findByHref() {
        driver.get("https://stackoverflow.com/");
        WebElement element = driver.findElement(By.cssSelector("a[href='?tab=hot']"));
        element.click();
        Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void findFirstVote() {
        driver.get("https://stackoverflow.com/");
        WebElement miniList = driver.findElement(By.cssSelector("div[id='question-mini-list']"));
        WebElement firstVote = miniList.findElement(By.cssSelector("div[class='votes']")).findElement(By.cssSelector("div.mini-counts")).findElement(By.cssSelector("span"));
        System.out.println("first vote: " + firstVote.getText());
    }

    @Test
    public void findByMultipleCSS() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement leftMenu = driver.findElement(By.cssSelector("div[id='leftmenuinnerinner'][class='w3-light-grey']"));

    }


    @Test
    public void walkingUpDOM() {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement male = driver.findElement(By.cssSelector("input[value='Male']"));
        WebElement maleDoubleUp = male.findElement(By.xpath(".."));
        System.out.println("male up: "+ maleDoubleUp.getText());
    }

    @After
    public void afterMethod(){
        super.afterMethod();
    }
}

