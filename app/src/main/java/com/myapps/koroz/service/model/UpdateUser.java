package com.myapps.koroz.service.model;

public class UpdateUser {
    private int ID;
    private int power;
    private int health;
    private int speed;

    public UpdateUser(int ID, int power, int health, int speed) {
        this.ID = ID;
        this.power = power;
        this.health = health;
        this.speed = speed;
    }

    public int getID() {
        return ID;
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
}
