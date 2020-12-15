package com.sample.test.demo.pages;

import com.sample.test.demo.Configuration;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Grigor_Meliksetyan
 */

public class PizzaOrderFormPage extends BasePage<PizzaOrderFormPage> {

  private final Configuration config;

  @FindBy(id = "pizza1Pizza")
  private WebElement pizza1;

  @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
  private WebElement pizza1Toppings1;

  @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
  private WebElement pizza1Toppings2;

  @FindBy(id = "pizza1Qty")
  private WebElement pizza1Quantity;

  @FindBy(id = "pizza1Cost")
  private WebElement pizza1Cost;

  @FindBy(id = "name")
  private WebElement name;

  @FindBy(id = "email")
  private WebElement email;

  @FindBy(id = "phone")
  private WebElement phone;

  @FindBy(id = "ccpayment")
  private WebElement radioCreditCard;

  @FindBy(id = "cashpayment")
  private WebElement radioCash;

  @FindBy(id = "placeOrder")
  private WebElement placeOrderButton;

  @FindBy(id = "reset")
  private WebElement resetButton;

  @FindBy(id = "dialog")
  private WebElement dialog;

  @FindBy(xpath = "//div[@id='dialog']/p")
  private WebElement dialogText;

  public PizzaOrderFormPage(WebDriver webDriver) {
    super(webDriver);
    this.config = new Configuration();
    super.initPage();
  }

  @Override
  public String getPageUrl() {
    return this.config.getUrl();
  }

  public void choosePizzaType(PizzaTypes pizzaType) {
    Select pizzaTypes = new Select(pizza1);
    pizzaTypes.selectByValue(pizzaType.getDisplayName());
  }

  public void chooseFirstToppings(PizzaToppings pizzaTopping) {
    Select pizzaToppings = new Select(pizza1Toppings1);
    pizzaToppings.selectByValue(pizzaTopping.getDisplayName());
  }

  public void chooseSecondToppings(PizzaToppings pizzaTopping) {
    Select pizzaToppings = new Select(pizza1Toppings2);
    pizzaToppings.selectByValue(pizzaTopping.getDisplayName());
  }

  public void fillQuantity(String quantity) {
    this.pizza1Quantity.clear();
    this.pizza1Quantity.sendKeys(quantity);
  }

  public String getCost() {
    return this.pizza1Cost.getText();
  }

  public void fillName(String name) {
    this.name.clear();
    this.name.sendKeys(name);
  }

  public void fillEmail(String email) {
    this.email.clear();
    this.email.sendKeys(email);
  }

  public void fillPhone(String phone) {
    this.phone.clear();
    this.phone.sendKeys(phone);
  }

  public void choosePaymentMethodAsCreditCard() {
    radioCreditCard.click();
  }

  public void choosePaymentMethodAsCash() {
    radioCash.click();
  }

  public void clickPlaceOrderButton() {
    placeOrderButton.click();
  }

  public void clickResetButton() {
    resetButton.click();
  }

  public String getDialogText() {
    return dialogText.getText();
  }
}
