package com.n1wan7ha.Lottery_Scraper_SB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryScraperService {

    @Autowired
    private LotteryResultService resultService;

    public void scrapeAndSaveAll() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.nlb.lk/results");

        // Get all lotteries
        List<WebElement> lotteries = driver.findElements(By.cssSelector("ul.res li.lbox"));

        for (WebElement lottery : lotteries) {
            String header = lottery.findElement(By.tagName("h4")).getText();

            // Split header into components
            String[] parts = header.split(" ");
            String name = parts[0] + (parts.length > 1 ? " " + parts[1] : "");
            String drawNo = parts.length > 2 ? parts[2] : "";
            String drawDate = header.substring(header.indexOf(drawNo) + drawNo.length()).trim();

            // Extract numbers with spacing
            List<WebElement> balls = lottery.findElements(By.cssSelector("ol.B > li"));
            StringBuilder results = new StringBuilder();
            for (WebElement b : balls) {
                if (results.length() > 0) results.append(" ");
                results.append(b.getText());
            }

            // ✅ Save to DB
            resultService.saveResult(name.trim(), drawNo, drawDate, results.toString());
        }

        driver.quit();
    }
}
