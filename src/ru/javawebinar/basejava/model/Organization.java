package ru.javawebinar.basejava.model;

import java.util.Date;

public class Organization {
    private String title;
    private String description;
    private Link homePage;
    private Date startDate;
    private Date endDate;

    public Organization(String title, String description, Link homePage, Date startDate, Date endDate) {
        this.title = title;
        this.description = description;
        this.homePage = homePage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", homePage=" + homePage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
