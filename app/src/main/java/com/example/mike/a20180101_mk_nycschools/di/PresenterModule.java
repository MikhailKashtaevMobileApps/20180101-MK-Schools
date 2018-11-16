package com.example.mike.a20180101_mk_nycschools.di;

import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.SatScoresRepository;
import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.sat_scores_gson.SatScore;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.SchoolRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    SchoolRepository providesSchoolRepository(){
        return new SchoolRepository();
    }
    @Provides
    SatScoresRepository providesSatScoresRepository(){
        return new SatScoresRepository();
    }

}
