package com.example.mike.a20180101_mk_nycschools.ui.main;

import com.example.mike.a20180101_mk_nycschools.di.DaggerMainPresenterComponent;
import com.example.mike.a20180101_mk_nycschools.model.Repository;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.SchoolRepository;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.school_gson.School;

import java.util.List;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    @Inject
    SchoolRepository schoolRepository;

    public MainPresenter(){
        //DaggerCollections
        DaggerMainPresenterComponent.create().inject(this);
    }

    @Override
    public void onAttach(MainContract.View v) {
        view = v;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    @Override
    public void getSchools() {

        schoolRepository.getSchools(new Repository.Callback<List<School>>() {
            @Override
            public void onSuccess(List<School> o) {
                view.onGetSchools(o);
            }

            @Override
            public void onError(Throwable e) {
                view.onError(e);
            }
        });

    }
}
