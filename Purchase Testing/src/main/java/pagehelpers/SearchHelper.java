package pagehelpers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.List;


public  class SearchHelper extends BasePage {


    private By btnSearch = By.name("submit_search");
    private By searchField = By.id("search_query_top");
    private By messageText = By.className("alert-warning");
    private By countItem = By.className("product-count");
    private By allElemens = By.className("product-container");




    public SearchHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getSearchField(){
        return waitForVisibleElement(driver, searchField,30);
    }

    public WebElement getBtnSearch(){
        return driver.findElement(btnSearch);
    }

    public void searchByKeyword(String keyword){
        clear(searchField);
        writeText(searchField, keyword);
        click(btnSearch);
    }


    public String getMessageAfterWrongKeyword(){
        return getMessage(messageText);
    }




    public Integer getCountAllArticles(){
        return getAllElements(allElemens).size();
    }


    public String getMessageArticleFound(){
        return getMessage(countItem);
    }
















}
