package ro.gov.httpithub.infotransport.data.repository;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

abstract class BaseRepository {
    private String mBaseUrl;

    BaseRepository(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    <T> T getContract(Class<T> repositoryClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(mBaseUrl)
                .build();

        return (T) retrofit.create(repositoryClass);
    }
}
