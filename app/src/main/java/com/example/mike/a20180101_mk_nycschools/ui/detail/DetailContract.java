package com.example.mike.a20180101_mk_nycschools.ui.detail;

import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.sat_scores_gson.SatScore;
import com.example.mike.a20180101_mk_nycschools.ui.base.BasePresenter;
import com.example.mike.a20180101_mk_nycschools.ui.base.BaseView;

public class DetailContract {

    interface View extends BaseView{
        void onGetSatScoreBySchoolId(SatScore satScore);
        void onError( Throwable e );
    }

    interface Presenter extends BasePresenter{
        void onAttach(View v);
        void onDetach();
        void getSatScoreBySchoolId( String schoolId );
    }

}
