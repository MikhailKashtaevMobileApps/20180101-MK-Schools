package com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.remote_data_source;

import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.sat_scores_gson.SatScore;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.remote_data_source.SchoolRemoteDataSource;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.school_gson.School;
import com.example.mike.a20180101_mk_nycschools.util.Const;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class SatScoreRemoteDataService {

    public static Observable<List<SatScore>> getSatScores(){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Const.DATA_URL)
                .build();

        return retrofit.create( Service.class ).getSatScores();
    }

    interface Service{

        @GET("resource/734v-jeq5.json")
        Observable<List<SatScore>> getSatScores();

    }
}
