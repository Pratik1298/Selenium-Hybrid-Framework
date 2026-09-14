package Listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public static WebDriver driver;

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] captureScreenshot() {
        if (driver == null) return new byte[0];
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source on failure", type = "text/plain")
    public String capturePageSource() {
        if (driver == null) return "driver was null";
        return driver.getPageSource();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot();
        capturePageSource();
    }
}
