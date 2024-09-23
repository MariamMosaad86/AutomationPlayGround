package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ScreenShotManager {

    static String screenshotsDirectoryPath = "./screenshots";

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        Path destination = Paths.get(screenshotsDirectoryPath, screenshotName + ".jpg");
        // هدفى هنا انى احفظ ال screenshot اللى هياخدها و بعرف البرنامج ان الصورة دى هتكون byteArray
        byte[] byteArray = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            // هنا بيدلة المسار اللى هيمشى فية علشان يعمل create لل file
            Files.write(destination, byteArray, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // هنا فى حالة لو معرفش ياخد screenshot تظهرلى الرسالة دى
            System.out.println("Unable to save screenshot");
        }
    }

}