package com.n1wan7ha.Lottery_Scraper_SB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LotteryScraperSbApplication implements CommandLineRunner {

    @Autowired
    private LotteryScraperService scraperService;

    public static void main(String[] args) {
        SpringApplication.run(LotteryScraperSbApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("🚀 Starting Lottery Scraper...");
        scraperService.scrapeAndSaveAll();
        System.out.println("✅ All results saved into DB!");
    }
}
