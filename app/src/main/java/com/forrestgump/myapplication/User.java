//package com.forrestgump.myapplication;
//
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;
//import java.io.Serializable;
//
//@Entity(tableName = "users")
//public class User implements Serializable {
//    @PrimaryKey(autoGenerate = true)
//    private int id;
//
//    @ColumnInfo(name = "name")
//    private String name;
//
//    @ColumnInfo(name = "city")
//    private String city;
//
//    @ColumnInfo(name = "favorite_food")
//    private String favoriteFood;
//
//
//    public User(String name, String city, String favoriteFood) {
//        this.name = name;
//        this.city = city;
//        this.favoriteFood = favoriteFood;
//    }
//
//    public int getId() { return id; }
//
//    public void setId(int id) { this.id = id; }
//
//    public String getName() { return name; }
//
//    public void setName(String name) { this.name = name; }
//
//    public String getCity() { return city; }
//
//    public void setCity(String city) { this.city = city; }
//
//    public String getFavoriteFood() { return favoriteFood; }
//
//    public void setFavoriteFood(String favoriteFood) { this.favoriteFood = favoriteFood; }
//}
