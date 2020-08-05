/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public class User {

    private static int idUser;
    private String username;
    private String numberPhone;
    private String discordProfile;
    private String annotations;
    private int rankGuild;
    private static boolean memberActivity = true;

    public User(int idUser) {

    }

    public User(String username, String numberPhone, String discordProfile, String annotations, int rankGuild) {
        this.username = username;
        this.numberPhone = numberPhone;
        this.discordProfile = discordProfile;
        this.annotations = annotations;
        this.rankGuild = rankGuild;

    }

    public User(int userID, String username, String numberPhone, String discordProfile, String annotations, int rankGuild) {
        this.idUser = userID;
        this.username = username;
        this.numberPhone = numberPhone;
        this.discordProfile = discordProfile;
        this.annotations = annotations;
        this.rankGuild = rankGuild;

    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getDiscordProfile() {
        return discordProfile;
    }

    public void setDiscordProfile(String discordProfile) {
        this.discordProfile = discordProfile;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public int getRankGuild() {
        return rankGuild;
    }

    public void setRankGuild(int rankGuild) {
        this.rankGuild = rankGuild;
    }

    public boolean isMemberActivity() {
        return memberActivity;
    }

    public void setMemberActivity(boolean memberActivity) {
        this.memberActivity = memberActivity;
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        User.idUser = idUser;
    }

}
