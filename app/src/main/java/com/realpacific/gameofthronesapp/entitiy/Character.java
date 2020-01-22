package com.realpacific.gameofthronesapp.entitiy;

import java.util.List;

public class Character {

    private String url;
    private String name;
    private String gender;
    private String culture;
    private String born;
    private String died;
    private String father;
    private String mother;
    private String spouse;
    private List<String> titles;
    private List<String> aliases;
    private List<String> allegiances;
    private List<String> books;
    private List<String> povBooks;
    private List<String> tvSeries;
    private List<String> playedBy;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getAllegiances() {
        return allegiances;
    }

    public void setAllegiances(List<String> allegiances) {
        this.allegiances = allegiances;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public List<String> getPovBooks() {
        return povBooks;
    }

    public void setPovBooks(List<String> povBooks) {
        this.povBooks = povBooks;
    }

    public List<String> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<String> tvSeries) {
        this.tvSeries = tvSeries;
    }

    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }
}
