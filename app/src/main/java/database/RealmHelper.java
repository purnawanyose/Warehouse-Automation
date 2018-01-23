package database;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import model.UsersModel;

/**
 * Created by yosep on 1/23/2018.
 */

public class RealmHelper {

    private static final String TAG = "RealmHelper";
    private Realm realm;
    private RealmResults<Users> realmUsersResult;
    public Context context;

    /**
     * constructor untuk membuat instance realm
     *
     * @param context
     */
    public RealmHelper(Context context) {
        realm = Realm.getDefaultInstance();
        this.context = context;
    }

    /**
     * menambah data
     *
     * @param title
     * @param password
     * @param ad
     * @param role
     */
    public void addUser(String title, String password, String ad, String role) {
        Users users = new Users();
        users.setId((int) (System.currentTimeMillis() / 1000));
        users.setUsername(title);
        users.setPassword(password);
        users.setAd(ad);
        users.setRole(role);

        realm.beginTransaction();
        realm.copyToRealm(users);
        realm.commitTransaction();
        
        Log.wtf(TAG,"Added ; " + title);
        Log.wtf(TAG, title + " berhasil disimpan.");
    }

    /**
     * mencari semua user
     *
     * @return
     */
    public ArrayList<UsersModel> findAllUsers() {
        ArrayList<UsersModel> data = new ArrayList<>();


        realmUsersResult = realm.where(Users.class).findAll();
        realmUsersResult.sort("id", Sort.DESCENDING);
        if (realmUsersResult.size() > 0) {
            showLog("Size : " + realmUsersResult.size());


            for (int i = 0; i < realmUsersResult.size(); i++) {
                String username, ad,role,password;
                int id = realmUsersResult.get(i).getId();
                username = realmUsersResult.get(i).getUsername();
                password = realmUsersResult.get(i).getPassword();
                ad = realmUsersResult.get(i).getAd();
                role = realmUsersResult.get(i).getRole();
                data.add(new UsersModel(id, username,password, role,ad));
            }

        } else {
            showLog("Size : 0");
            showToast("Database Kosong!");
        }

        return data;
    }

    /**
     * delete yser
     *
     * @param id
     */
    public void deleteData(int id) {
        RealmResults<Users> dataDesults = realm.where(Users.class).equalTo("id", id).findAll();
        realm.beginTransaction();
        dataDesults.remove(0);
        dataDesults.deleteLastFromRealm()   ;
        dataDesults.clear();
        realm.commitTransaction();

        showToast("Hapus data berhasil.");
    }

    /**
     * membuat log
     *
     * @param s
     */
    private void showLog(String s) {
        Log.d(TAG, s);

    }

    /**
     * Membuat Toast Informasi
     */
    private void showToast(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

}
