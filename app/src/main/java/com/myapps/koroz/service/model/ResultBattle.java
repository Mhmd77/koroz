package com.myapps.koroz.service.model;

import com.google.gson.annotations.SerializedName;

public class ResultBattle {
    @SerializedName("Winner")
    private String Winner;

    public ResultBattle(String winner) {
        Winner = winner;
    }

    public String getWinner() {
        return Winner;
    }
}
