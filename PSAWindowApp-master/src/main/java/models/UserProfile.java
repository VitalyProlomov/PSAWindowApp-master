package models;

import java.util.HashSet;

public class UserProfile {
    private final String userName;

    private HashSet<String> allGamesIds;
    int vpip;
    int threeBetPercentage;
    double fourBetPercentage;
    double fiveBetPercentage;
    int handsAnalizedAmount;

    int bbWinlossAllTime;

    public UserProfile(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

//    public addGames(Date startDate, Date finishDate, String userIdInSession) {
//        pathWithGames
//
//    }

    public void get3BetPercent() {

    }
}