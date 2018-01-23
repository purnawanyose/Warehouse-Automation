package model;

/**
 * Created by yosep on 1/23/2018.
 */

public class UsersModel {

    private int id;
    private String username;
    private String password;
    private String role;
    private String ad;

    public UsersModel() {
    }

    public UsersModel(int id, String username, String password, String role, String ad) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
