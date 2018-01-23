package database;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by yosep on 1/22/2018.
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration config = new
                RealmConfiguration.Builder()
                .build();
        Realm.setDefaultConfiguration(config);

    }
}
