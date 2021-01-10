package net.mcamigos.petfinder.data.api;

import net.mcamigos.petfinder.data.Config;
import net.mcamigos.petfinder.data.service.PetService;
import net.mcamigos.petfinder.utils.PrefManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit getRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();

        return retrofit;
    }


    public static PetService getPetService(){
        PetService petService = getRetrofit().create(PetService.class);
        return petService;
    }


    private static OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(chain -> {
                    Request newRequest = null;
                    if(PrefManager.fetchTokenDetails() != null){
                        String token_type = PrefManager.fetchTokenDetails().getToken_type();
                        String access_token = PrefManager.fetchTokenDetails().getAccess_token();
                        newRequest = chain.request().newBuilder()
                                 .header("Authorization", "Bearer " + PrefManager.fetchTokenDetails().getAccess_token())
                                .build();
                        return chain.proceed(newRequest);
                    }else{
                        newRequest = chain.request().newBuilder()
                                .build();
                         return chain.proceed(newRequest);

                    }

                })
                .build();

        return okHttpClient;

    }

}
