package service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by muham on 12/12/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "http://10.15.5.150/dev/eproc/EC_API_MSD/";
//    public static final String BASE_URL = "http://int-eprocurement.semenindonesia.com/eproc/EC_API/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
