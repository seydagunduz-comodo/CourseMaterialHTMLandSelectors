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

public class Session1 extends BaseUITestCase {

    private List<WebElement> menuItems;

    @Before
    public void beforeMethod(){
        super.beforeMethod();
    }

    @Test
    public void findById() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.id("topnavbtn_references"));
        System.out.println("References: " + element.getText());
    }

    @Test
    public void findByIdII() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("#topnavbtn_references"));
        System.out.println("References: " + element.getText());
    }

    @Test
    public void findByIdIII() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("[id='topnavbtn_references']"));
        System.out.println("References: " + element.getText());
    }

    @Test
    public void findByIdIV() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("a[id='topnavbtn_references']"));
        System.out.println("References: " + element.getText());
    }


    @Test
    public void findByClass() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.className("w3-example"));
        System.out.println("References: " + element.getText());
    }


    @Test
    public void readTable() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("[class='w3-table-all notranslate']"));
        System.out.println("Tablo: " + element.getText());
        List<WebElement> tableRows = element.findElements(By.tagName("tr"));
        List<WebElement> dataCell = tableRows.get(1).findElements(By.cssSelector("td"));
        System.out.println("row 1 data 1: " + dataCell.get(1).getText());
    }


    @Test
    public void findByHref() {
        driver.get("https://stackoverflow.com/");
        WebElement element = driver.findElement(By.cssSelector("a[href='?tab=hot']"));
        element.click();
        Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void parentChild() {
        driver.get("https://stackoverflow.com/");
        WebElement divPanel = driver.findElement(By.cssSelector("#question-mini-list"));
        WebElement firstVote = divPanel.findElement(By.cssSelector(".mini-counts")).findElement(By.cssSelector("span"));
        System.out.println("first vote value: " + firstVote.getText());
        System.out.println("span attribute: " + firstVote.getAttribute("title"));

    }


    @Test
    public void listMenu() {
        driver.get("https://www.w3schools.com/css/css_navbar.asp");
        WebElement menuBar = driver.findElement(By.cssSelector("ul[class='horizontal']"));
        menuItems = menuBar.findElements(By.cssSelector("li"));
        System.out.println("li: " + menuItems.get(1));
        WebElement firstMenuItem = menuItems.get(1).findElement(By.cssSelector("a"));
        System.out.println("a = " + firstMenuItem.getText());
    }


    @Test
    public void accessingParentElement() {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement cinsiyetMale = driver.findElement(By.cssSelector("input[value='Male']"));
        WebElement cinsiyetWalkingUp = cinsiyetMale.findElement(By.xpath(".."));
        System.out.println("cinsiyet up" + cinsiyetWalkingUp.getText());
    }


    @After
    public void afterMethod(){
        super.afterMethod();
    }
}

