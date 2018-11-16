package com.example.mike.a20180101_mk_nycschools.di;

import com.example.mike.a20180101_mk_nycschools.ui.detail.DetailActivity;

import javax.inject.Inject;

import dagger.Component;

@Component( modules = DetailActivityModule.class)
public interface DetailActivityComponent {


    void inject(DetailActivity detailActivity);

}
