package tr.com.comodo.egitim.testcases;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tr.com.comodo.egitim.base.BaseUITestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DenemeTestCase extends BaseUITestCase {

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
    public void findByIdCSS() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("[id='topnavbtn_references']"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByIdCSSAlternativeI() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("#topnavbtn_references"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByIdCSSAlternativeII() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("a#topnavbtn_references"));
        System.out.println("element: " + element.getText());
    }

    //Do this with one of the w3-examples which is not the first one
    // There are many of the same classes on the page, so the first one is shown
    @Test
    public void findByClass() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.className("w3-example"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByClassCSS() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("[class='w3-example']"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByClassCSSAlternative() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector(".w3-example"));
        System.out.println("element: " + element.getText());
    }

    // Handle find by text

    @Test
    public void findByMultipleClass() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("table[class='w3-table-all notranslate']"));
        System.out.println("element: " + element.getText());
    }

    // If there would be many of these links then //
    @Test
    public void findByAttributeExampleI() {
        driver.get("https://stackoverflow.com/");
        WebElement element = driver.findElement(By.cssSelector("a[href='?tab=hot']"));
        System.out.println("element: " + element.getText());
    }

    // Sadece ikinci kısmı ararsan hata vereceğini; bazen elemanların önce visible olması gerektiğini anlat
    @Test
    public void findByAttributeExampleII() {
        driver.get("https://stackoverflow.com/");
        WebElement element = driver.findElement(By.cssSelector("a[href='https://stackexchange.com']"));
        element.click();
        Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
        WebElement searchBar = driver.findElement(By.cssSelector("[id='js-site-filter-txt']"));
        searchBar.click();
        Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
    }

    // First top question'ın vote'unu buluyoruz
    // question-summary narrow'dan önce başka olmasın diye mini list'i alıyoruz
    // Get attribute
    @Test
    public void findByAttributeExampleIII() {
        driver.get("https://stackoverflow.com/");
        WebElement element = driver.findElement(By.cssSelector("#question-mini-list"));
        WebElement firstQuestionSummary = element.findElement(By.cssSelector("div[class='question-summary narrow']"));
        WebElement voteSpan = firstQuestionSummary.findElement(By.cssSelector("span"));
        System.out.println("title: " + voteSpan.getAttribute("title"));
    }

    @Test
    public void readListItems() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement list = driver.findElement(By.cssSelector("ol#ex1"));
        List<WebElement> listElements = list.findElements(By.cssSelector("li"));
        // Or instead of the two upper lines we can used a combined version as:
        // List<WebElement> listElements = driver.findElement(By.cssSelector("ol#ex1")).findElements(By.cssSelector("li"));
        System.out.println("List: " + list);
        System.out.println("n-th List item: " + listElements.get(0).getText());
    }

    @Test
    public void readTable() {
        driver.get("https://www.w3schools.com/css/css_table.asp");
        WebElement table = driver.findElement(By.cssSelector("table#customers"));
        System.out.println("Table: " + table.getText());
        List<WebElement> rows = table.findElements(By.cssSelector("tr"));
        System.out.println("Row (0): " + rows.get(0).getText());
        System.out.println("Row (2): " + rows.get(2).getText());
        List<WebElement> columns = rows.get(1).findElements(By.cssSelector("td"));
        System.out.println("Columns (2) of row 1: " + columns.get(2).getText());
    }

    @Test
    public void readMenuItems(){
        driver.get("https://www.w3schools.com/css/css_navbar.asp");
        WebElement menuBar = driver.findElement(By.cssSelector("ul.horizontal"));
        List<WebElement> menuItems = menuBar.findElements(By.cssSelector("li"));
        System.out.println(menuItems.get(0).getText());
    }

    @Test
    public void dropDown(){
        driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
        WebElement ddButon = driver.findElement(By.cssSelector("button[id='menu1']"));
        ddButon.click();
        Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
        WebElement dropdownPanel = driver.findElement(By.cssSelector("ul[class='dropdown-menu test']"));
        List<WebElement> panelItemsList = dropdownPanel.findElements(By.cssSelector("li"));
        System.out.println("panel (2)nd item: " + panelItemsList.get(1).getText());
    }

    // Selenium Workshop'ında kullan

    @Ignore
    public void dropDownII(){
        driver.get("http://toolsqa.com/automation-practice-form/");
    }


    @Test
    public void radioButton(){
        driver.get("http://toolsqa.com/automation-practice-form/");
        Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
        // Select "Male" // Unselect "Male"
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='Male']"));
        System.out.println("is selected? " + maleRadioButton.isSelected());
    }


    @Test
    public void findWithMultipleCSSSelectors() {
        driver.get("https://www.w3schools.com/css/css_list.asp");
        WebElement element = driver.findElement(By.cssSelector("div[class='w3-sidebar w3-collapse'][id='sidenav']"));
        System.out.println("element: " + element.getText());
    }

    @Test
    public void findByXpath(){
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='Male']"));
        System.out.println("RadioButton: " + maleRadioButton.getText());
        WebElement maleRadioButtonParent = maleRadioButton.findElement(By.xpath(".."));
        System.out.println("RadioButton parent: " + maleRadioButtonParent.getText());
        WebElement maleRadioButtonParentUp = maleRadioButtonParent.findElement(By.xpath(".."));
        System.out.println("RadioButton parentUp: " + maleRadioButtonParentUp.getText());
    }

    @Ignore
    public void findByXpathII(String urunIsmi, String urunAciklama, String urunFiyat){
        // Example not working, copied from another project
        WebElement title = driver.findElement(By.xpath("//UIAScrollView/UIAStaticText[@label='" + urunIsmi + "']"));
        WebElement aciklama = driver.findElement(By.xpath("//UIAScrollView/UIAStaticText[@label='" + urunIsmi + "']/following-sibling::UIAStaticText"));

        System.out.println("title = " + title.getText());
        System.out.println("aciklama = " + aciklama.getText());
    }

    @After
    public void afterMethod(){
        super.afterMethod();
    }
}
