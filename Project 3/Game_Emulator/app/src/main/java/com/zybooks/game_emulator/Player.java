package com.zybooks.game_emulator;

public class Player {
    private String name;
    private Integer totalScore;
    private Integer wins;
    private Integer losses;
    private Integer ties;

    public Player() {
        this.name = "";
        totalScore = 0;
        wins = 0;
        losses = 0;
        ties = 0;
    }

    public Player(String name) {
        this.name = name;
        totalScore = 0;
        wins = 0;
        losses = 0;
        ties = 0;
    }


    public Player(Integer losses, String name, Integer wins,  Integer ties) {
        this.name = name;
        totalScore = (wins * 2) + (ties * 1);
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore() {
        this.totalScore = wins * 2 + ties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Name:" + this.getName()
                + "/n" + this.getName()
                + "/n" + "Wins: " + this.getWins()
                + "/n" + "Losses: " + this.getLosses()
                + "/n" + "Ties: " + this.getTies();
    }
}
