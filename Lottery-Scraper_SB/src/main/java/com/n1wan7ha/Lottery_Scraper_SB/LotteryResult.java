package com.n1wan7ha.Lottery_Scraper_SB;

import jakarta.persistence.*;

@Entity
@Table(name = "lottery_results_NS") //dn
public class LotteryResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lotteryName;
    private String drawNo;
    private String drawDate;

    @Column(length = 200)
    private String results;

    public LotteryResult() {}

    public LotteryResult(String lotteryName, String drawNo, String drawDate, String results) {
        this.lotteryName = lotteryName;
        this.drawNo = drawNo;
        this.drawDate = drawDate;
        this.results = results;
    }

    // Getters & setters
    public Long getId() { return id; }
    public String getLotteryName() { return lotteryName; }
    public void setLotteryName(String lotteryName) { this.lotteryName = lotteryName; }
    public String getDrawNo() { return drawNo; }
    public void setDrawNo(String drawNo) { this.drawNo = drawNo; }
    public String getDrawDate() { return drawDate; }
    public void setDrawDate(String drawDate) { this.drawDate = drawDate; }
    public String getResults() { return results; }
    public void setResults(String results) { this.results = results; }
}
