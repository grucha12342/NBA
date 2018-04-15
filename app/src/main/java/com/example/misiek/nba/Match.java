package com.example.misiek.nba;

public class Match {
    int gameId;
    int homeTeamId;
    int homeTeamScore;
    String homeTeamTriCode;
    int awayTeamId;
    int awayTeamScore;
    String awayTeamTriCode;

    public Match(int gameId, int homeTeamId, int homeTeamScore, String homeTeamTriCode, int awayTeamId, int awayTeamScore, String awayTeamTriCode) {
        this.gameId = gameId;
        this.homeTeamId = homeTeamId;
        this.homeTeamScore = homeTeamScore;
        this.homeTeamTriCode = homeTeamTriCode;
        this.awayTeamId = awayTeamId;
        this.awayTeamScore = awayTeamScore;
        this.awayTeamTriCode = awayTeamTriCode;
    }

    public String getHomeTeamTriCode() {
        return homeTeamTriCode;
    }

    public void setHomeTeamTriCode(String homeTeamTriCode) {
        this.homeTeamTriCode = homeTeamTriCode;
    }

    public String getAwayTeamTriCode() {
        return awayTeamTriCode;
    }

    public void setAwayTeamTriCode(String awayTeamTriCode) {
        this.awayTeamTriCode = awayTeamTriCode;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }
}
