package database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by yosep on 1/22/2018.
 */

public class User extends RealmObject {

    @PrimaryKey
    private int id;
    private String username;
    private String password;

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
}
