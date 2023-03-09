package com.fit2081.rooms.provider;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//defines all the differnet secitons of the database
@Entity(tableName = "customers")
public class Customer {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "MovieId")
    private int id;
    @ColumnInfo(name = "MovieName")
    private String name;
    @ColumnInfo(name = "MovieGenre")
    private String genre;
    @ColumnInfo(name = "MovieCountry")
    private String country;
    @ColumnInfo(name = "MovieKeywords")
    private String keywords;
    @ColumnInfo(name = "MovieCost")
    private int cost;
    @ColumnInfo(name = "MovieYear")
    private int year;
//creates the constructor for the customer object
    public Customer(String name, String genre, String country, String keywords, int cost, int year) {
        this.name = name;
        this.genre = genre;
        this.country = country;
        this.keywords = keywords;
        this.cost = cost;
        this.year = year;
    }

    //creates the different getters.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
    public String getCountry() {
        return country;
    }
    public String getKeywords() {
        return keywords;
    }
    public int getCost() {
        return cost;
    }
    public int getYear() {
        return year;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

}
