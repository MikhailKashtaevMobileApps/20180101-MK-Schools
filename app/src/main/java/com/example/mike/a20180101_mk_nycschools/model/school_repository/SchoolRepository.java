package com.example.mike.a20180101_mk_nycschools.model.school_repository;


import com.example.mike.a20180101_mk_nycschools.model.Repository;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.remote_data_source.SchoolRemoteDataSource;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.school_gson.School;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SchoolRepository {

    public void getSchools(final Repository.Callback<List<School>> callback ){

        SchoolRemoteDataSource.getListOfSchools()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<School>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(List<School> schools) {
                        callback.onSuccess(schools);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onComplete() {}
                });

    }

}
