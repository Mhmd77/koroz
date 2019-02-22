package com.myapps.koroz.service.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("ID")
    private int ID;
    @SerializedName("FullName")
    private String fullName;
    @SerializedName("xp")
    public int xp;
    @SerializedName("power")
    public int power;
    @SerializedName("health")
    public int health;
    @SerializedName("speed")
    public int speed;
    @SerializedName("BattleCounts")
    public int BattleCounts;
    @SerializedName("Levels")
    public int Levels;

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public int getXp() {
        return xp;
    }

    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getBattleCounts() {
        return BattleCounts;
    }

    public int getLevels() {
        return Levels;
    }
}
