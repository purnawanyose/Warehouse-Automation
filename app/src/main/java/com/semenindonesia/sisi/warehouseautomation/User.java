package com.semenindonesia.sisi.warehouseautomation;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by muham on 1/29/2018.
 */
@IgnoreExtraProperties
public class User {

        public String name;
        public String email;

        // Default constructor required for calls to
        // DataSnapshot.getValue(User.class)
        public User() {
        }

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
}
