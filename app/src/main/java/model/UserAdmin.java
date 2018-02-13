package model;

/**
 * Created by muham on 1/31/2018.
 */

public class UserAdmin {
    private String username;
    private String password;
    private String Id;
    private String role;


    public UserAdmin(){

    }

    public UserAdmin(String Id, String username, String password, String role){
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
