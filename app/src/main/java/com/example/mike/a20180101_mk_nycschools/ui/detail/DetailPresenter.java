package com.example.mike.a20180101_mk_nycschools.ui.detail;

import com.example.mike.a20180101_mk_nycschools.di.DaggerDetailPresenterComponent;
import com.example.mike.a20180101_mk_nycschools.model.Repository;
import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.SatScoresRepository;
import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.sat_scores_gson.SatScore;

import java.util.List;

import javax.inject.Inject;

public class DetailPresenter implements DetailContract.Presenter {

    DetailContract.View view;
    @Inject
    SatScoresRepository satScoresRepository;

    public DetailPresenter(){
        DaggerDetailPresenterComponent.create().inject(this);
    }

    @Override
    public void onAttach(DetailContract.View v) {
        view = v;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    @Override
    public void getSatScoreBySchoolId(final String schoolId) {
        satScoresRepository.getSatScores(new Repository.Callback<List<SatScore>>() {
            @Override
            public void onSuccess(List<SatScore> o) {
                for (SatScore satScore : o) {
                    if (satScore.getDbn().equals(schoolId)){
                        view.onGetSatScoreBySchoolId( satScore );
                        return;
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                view.onError( e );
            }
        });
    }
}
