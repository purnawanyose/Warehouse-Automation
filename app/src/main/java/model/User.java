package model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by muham on 1/29/2018.
 */
@IgnoreExtraProperties
public class User {

    public String username;
    public String pass;
    public String role;
    public String id;


    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String username, String role, String pass, String id) {
        this.username = username;
        this.pass = pass;
        this.role = role;
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
