package com.example.mike.a20180101_mk_nycschools.di;

import com.example.mike.a20180101_mk_nycschools.ui.detail.DetailPresenter;

import javax.inject.Inject;

import dagger.Component;

@Component(modules = PresenterModule.class)
public interface DetailPresenterComponent {


    DetailPresenter inject (DetailPresenter detailPresenter);

}
