package com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository;

import com.example.mike.a20180101_mk_nycschools.model.Repository;
import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.remote_data_source.SatScoreRemoteDataService;
import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.sat_scores_gson.SatScore;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SatScoresRepository {

    public void getSatScores( final Repository.Callback<List<SatScore>> callback ){

        SatScoreRemoteDataService.getSatScores()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<SatScore>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<SatScore> satScores) {
                        callback.onSuccess( satScores );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
