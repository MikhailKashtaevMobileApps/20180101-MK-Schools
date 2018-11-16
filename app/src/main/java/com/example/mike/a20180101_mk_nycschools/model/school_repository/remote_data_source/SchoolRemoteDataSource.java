package com.example.mike.a20180101_mk_nycschools.model.school_repository.remote_data_source;

import com.example.mike.a20180101_mk_nycschools.model.school_repository.school_gson.School;
import com.example.mike.a20180101_mk_nycschools.util.Const;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class SchoolRemoteDataSource {

    public static Observable<List<School>> getListOfSchools(){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Const.DATA_URL)
                .build();

        return retrofit.create( Service.class ).getListOfSchools();
    }

    interface Service{

        @GET("resource/97mf-9njv.json")
        Observable<List<School>> getListOfSchools();

    }

}
