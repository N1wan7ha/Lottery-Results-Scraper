package com.n1wan7ha.Lottery_Scraper_SB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotteryResultService {
    @Autowired
    private LotteryResultRepository repository;

    public void saveResult(String name, String drawNo, String drawDate, String results) {
        LotteryResult result = new LotteryResult(name, drawNo, drawDate, results);
        repository.save(result);
        System.out.println("✅ Saved to DB: " + name + " (" + drawNo + ")");
    }
}
