package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.pages.PizzaOrderFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends TestBase {

  private static final String orderAcceptedDialogTextTemplate = "Thank you for your order! TOTAL: %s %s";
  private static final String missingRequiredFieldsDialogText = "Missing name\nMissing phone number";

  @Test
  public void demoTest() {
    System.out.println("HELLO WORLD");
  }

  @Test
  public void orderCashHappyPathTest() {
    PizzaOrderFormPage pizzaOrderFormPage = new PizzaOrderFormPage(driver);
    pizzaOrderFormPage.choosePizzaType(PizzaTypes.LARGE_THREETOPPINGS);
    pizzaOrderFormPage.chooseFirstToppings(PizzaToppings.EXTRACHEESE);
    pizzaOrderFormPage.chooseSecondToppings(PizzaToppings.ITALIANHAM);
    pizzaOrderFormPage.fillQuantity("1");
    pizzaOrderFormPage.fillName("name");
    pizzaOrderFormPage.fillEmail("email");
    pizzaOrderFormPage.fillPhone("phone");
    pizzaOrderFormPage.choosePaymentMethodAsCash();
    pizzaOrderFormPage.clickPlaceOrderButton();
    Assert.assertEquals(pizzaOrderFormPage.getDialogText(),
        String.format(orderAcceptedDialogTextTemplate,
            PizzaTypes.LARGE_THREETOPPINGS.getCost(),
            PizzaTypes.LARGE_THREETOPPINGS.getDisplayName()));
  }

  @Test
  public void requiredFieldsValidationTest() {
    PizzaOrderFormPage pizzaOrderFormPage = new PizzaOrderFormPage(driver);
    pizzaOrderFormPage.clickResetButton();
    pizzaOrderFormPage.clickPlaceOrderButton();
    Assert.assertEquals(pizzaOrderFormPage.getDialogText(), missingRequiredFieldsDialogText);
  }

}
