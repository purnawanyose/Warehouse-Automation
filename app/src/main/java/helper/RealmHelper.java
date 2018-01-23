package helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import model.UserModel;


public class RealmHelper {


    private static final String TAG = "RealmHelper";


    private Realm realm;
    private RealmResults<User> realmResult;
    public Context context;

    /**
     * constructor untuk membuat instance realm
     *
     * @param context
     */
    public RealmHelper(Context context) {
//        realm = Realm.getInstance(context);
        this.context = context;
    }


    /**
     * menambah data
     *
     * @param username
     * @param password
     */
    public void addArticle(String username, String password) {
        User article = new User();
        article.setId((int) (System.currentTimeMillis() / 1000));
        article.setUsername(username);
        article.setPassword(password);


        realm.beginTransaction();
        realm.copyToRealm(article);
        realm.commitTransaction();


        showLog("Added ; " + username);
        showToast(username + " berhasil disimpan.");
    }


    /**
     * method mencari semua article
     */
    public ArrayList<UserModel> findAllArticle() {
        ArrayList<UserModel> data = new ArrayList<>();


        realmResult = realm.where(User.class).findAll();
        realmResult.sort("id", Sort.DESCENDING);
        if (realmResult.size() > 0) {
            showLog("Size : " + realmResult.size());


            for (int i = 0; i < realmResult.size(); i++) {
                String username, password;
                int id = realmResult.get(i).getId();
                username = realmResult.get(i).getUsername();
                password = realmResult.get(i).getPassword();
                data.add(new UserModel(id, username, password));
            }

        } else {
            showLog("Size : 0");
            showToast("Database Kosong!");
        }

        return data;
    }


    /**
     * method update article
     *
     * @param id
     * @param username
     * @param password
     */
    public void updateArticle(int id, String username, String password) {
        realm.beginTransaction();
        User article = realm.where(User.class).equalTo("id", id).findFirst();
        article.setUsername(username);
        article.setPassword(password);
        realm.commitTransaction();
        showLog("Updated : " + username);

        showToast(username + " berhasil diupdate.");
    }


    /**
     * method menghapus article berdasarkan id
     *
     * @param id
     */
    public void deleteData(int id) {
        RealmResults<User> dataDesults = realm.where(User.class).equalTo("id", id).findAll();
        realm.beginTransaction();
        dataDesults.remove(0);
//        dataDesults.removeLast();
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