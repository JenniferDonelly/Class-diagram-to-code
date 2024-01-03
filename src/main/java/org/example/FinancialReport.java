package org.example;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinancialReport {
    private static ArrayList<FinancialReport> reports = new ArrayList<FinancialReport>();
    private static int reportIdCounter = 1;

    private int reportId;
    private String title;
    private String description;
    private List<File> attachments;

    private LocalDate startDate;
    private LocalDate endDate;

    private double totalRevenue;
    private double totalExpenses;
    private double grossProfit;
    private double operatingProfit;
    private double netProfit;

    private boolean verified;

    // Constructor
    private FinancialReport(String title, String description, LocalDate startDate, LocalDate endDate, double totalRevenue, double totalExpenses, double grossProfit, double operatingProfit, double netProfit) {
        this.reportId = reportIdCounter++;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalRevenue = totalRevenue;
        this.totalExpenses = totalExpenses;
        this.grossProfit = grossProfit;
        this.operatingProfit = operatingProfit;
        this.netProfit = netProfit;
        this.attachments = new ArrayList<>();
        this.verified = false;
        reports.add(this);
    }

    // Methods for attachments
    public void addAttachment(File attachment) {
        if(attachment != null) {
            this.attachments.add(attachment);
        }
    }

    public void removeAttachment(File attachment) {
        this.attachments.remove(attachment);
    }

    public List<File> getAttachments() {
        return new ArrayList<>(attachments);
    }

    public int getReportId() {
        return reportId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getGrossProfit() {
        return grossProfit;
    }

    public double getOperatingProfit() {
        return operatingProfit;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public boolean isVerified() {
        return verified;
    }

    public void verifyReport() {
        this.verified = true;
    }

    public static List<FinancialReport> getAllReports() {
        return new ArrayList<>(reports);
    }

    public static FinancialReport generateFinancialReport(LocalDate startDate, LocalDate endDate) {
        String title = "Financial Report from " + startDate + " to " + endDate;
        String description = "This report covers the financial performance of the period including revenue, expenses, and others.";

        // Perform data fetching from database and calculations here based on start and end dates
        double totalRevenue = 0.0;
        double totalExpenses = 0.0;
        double grossProfit = totalRevenue - totalExpenses;
        double operatingCost = 0.0;
        double operatingProfit = grossProfit - operatingCost;
        double netProfit = operatingProfit - (operatingProfit * 0.25); // Ex 25% of operating cost is taken by other stuff like taxes


        return new FinancialReport(
                title,
                description,
                startDate,
                endDate,
                totalRevenue,
                totalExpenses,
                grossProfit,
                operatingProfit,
                netProfit
        );
    }
}
