package com.example.misiek.nba;

public class Team {
    int id;
    String city;
    String nickname;
    String confName;
    String divName;

    public Team(int id, String city, String nickname, String confName, String divName) {
        this.id = id;
        this.city = city;
        this.nickname = nickname;
        this.confName = confName;
        this.divName = divName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }
}
