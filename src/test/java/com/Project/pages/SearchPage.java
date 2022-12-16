package com.Project.pages;

import com.Project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
 public SearchPage(){
     PageFactory.initElements(Driver.get(),this);
 }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBar;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement submitButton;

    @FindBy(xpath = "//span[@id=\"a-autoid-0-announce\"]")
    public WebElement sortButton;

    @FindBy(xpath = "//a[@id='s-result-sort-select_2']")
    public WebElement highToLow;

    @FindBy(xpath = "//span[.='$559.99'][1]")
    public WebElement selectedBundle;

    @FindBy(xpath = "//span[@aria-hidden='true'][normalize-space()='$559.99']")
    public WebElement priceValidation;




}
