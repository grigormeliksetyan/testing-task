package com.sample.test.demo.helpers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Grigor_Meliksetyan
 */

public class WaitHelper {

  private static final Logger LOGGER = LogManager.getLogger(WaitHelper.class);

  private final WebDriver webDriver;

  private int timeout = 10;

  public WaitHelper(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void forceWait(long timeInMilliSeconds) {
    try {
      Thread.sleep(timeInMilliSeconds);
    } catch (InterruptedException e) {
      LOGGER.error(e.getMessage());
    }
  }

  public void pageReadyStateToComplete() {
    forceWait(500);
    ExpectedCondition<Boolean> pageLoadCondition = driver -> {
      assert driver != null;
      return (boolean) ((JavascriptExecutor) driver)
          .executeScript("return document.readyState === 'complete'");
    };
    try {
      new WebDriverWait(webDriver, timeout).until(pageLoadCondition);
    } catch (WebDriverException e) {
      LOGGER.error(e.getMessage(), e);
      throw new WebDriverException("Page is not loaded");
    }
  }

  public void ajaxJquery() {
    forceWait(200);
    ExpectedCondition<Boolean> pageLoadCondition = driver -> {
      assert driver != null;
      return (boolean) ((JavascriptExecutor) driver)
          .executeScript("return window.jQuery === undefined ? true : window.jQuery.active === 0");
    };
    try {
      new WebDriverWait(webDriver, timeout).until(pageLoadCondition);
    } catch (WebDriverException e) {
      LOGGER.error(e.getMessage(), e);
      throw new WebDriverException("Page is not loaded");
    }
  }

  public void pageToLoad() {
    pageReadyStateToComplete();
    ajaxJquery();
  }
}
