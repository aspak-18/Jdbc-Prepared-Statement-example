package com.java.jdbc.PreparedStatement.Entity;

public class Sports {
    private int position;
    private String name;
    private String stadium;
    private int points;
    private String captain;

    Sports(){

    }

    public Sports(int position, String name, String stadium, int points, String captain) {
        this.position = position;
        this.name = name;
        this.stadium = stadium;
        this.points = points;
        this.captain = captain;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    @Override
    public String toString() {
        return "Position=" + position +
                "\nName='" + name + '\'' +
                "\nStadium='" + stadium + '\'' +
                "\nPoints=" + points +
                "\nCaptain='" + captain + '\'' ;
    }
}
