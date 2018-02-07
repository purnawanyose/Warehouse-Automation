package config;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import model.Cart;

/**
 * Created by yosep on 2/2/2018.
 */

public class prefmanager {

    private static String TAG = prefmanager.class.getSimpleName();

    List<Cart> cart = new ArrayList<Cart>();

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

    public void fillcart(String PSTNG_DATE, String DOC_DATE, String HEADER_TXT, String PR_UNAME, String PLANT, String MOVE_TYPE,
                         String ENTRY_QNT, String RESERV_NO, String RES_ITEM, String STGE_LOC, String VAL_TYPE, String SPEC_STOCK,
                         String WBS_ELEM){

        Cart fill = new Cart();

        fill.setDOC_DATE(DOC_DATE);
        fill.setPLANT(PLANT);
        fill.setPSTNG_DATE(PSTNG_DATE);
        fill.setHEADER_TXT(HEADER_TXT);

    }

}
