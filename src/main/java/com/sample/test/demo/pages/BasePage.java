package com.sample.test.demo.pages;

import com.sample.test.demo.helpers.WaitHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Grigor_Meliksetyan
 */

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

  private static final Logger LOGGER = LogManager.getLogger(WaitHelper.class);

  private final WebDriver webDriver;

  private WaitHelper waitFor;

  private int timeout = 10;


  public BasePage(WebDriver webDriver) {
    this.webDriver = webDriver;
    this.waitFor = new WaitHelper(webDriver);
  }

  public T openPage() {
    LOGGER.info("Page is loading.");
    load();
    return get();
  }

  public T initPage() {
    PageFactory.initElements(this.webDriver, this);
    return get();
  }

  public void passBasicAuth(String username, String password) {
    String currentUrl = this.webDriver.getCurrentUrl();
    this.webDriver.get(currentUrl.replaceFirst("://", "://" + username + ":" + password + "@"));
  }

  protected abstract String getPageUrl();

  @Override
  protected void load() {
    this.webDriver.get(getPageUrl());
  }

  @Override
  public void isLoaded() throws Error {
    waitFor.pageToLoad();
  }

  public void condition(ExpectedCondition<Boolean> expectedCondition) throws WebDriverException {
    new WebDriverWait(this.webDriver, timeout).until(expectedCondition);
  }

  @Override
  public T get() {
    isLoaded();
    return (T) this;
  }

}
