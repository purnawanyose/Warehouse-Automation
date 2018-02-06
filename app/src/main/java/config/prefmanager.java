package config;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

/**
 * Created by yosep on 2/2/2018.
 */

public class prefmanager {

    private static String TAG = prefmanager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "Warehouse Automation";

    private static final String KEY_CART = "cart";

    public  static  int qtyCart[];

    public prefmanager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void cart(boolean cartOn){

        editor.putBoolean(KEY_CART,cartOn);



        editor.commit();

    }

    

}
