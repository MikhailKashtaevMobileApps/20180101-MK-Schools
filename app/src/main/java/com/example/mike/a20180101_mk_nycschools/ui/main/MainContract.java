package com.example.mike.a20180101_mk_nycschools.ui.main;

import com.example.mike.a20180101_mk_nycschools.model.school_repository.school_gson.School;
import com.example.mike.a20180101_mk_nycschools.ui.base.BasePresenter;
import com.example.mike.a20180101_mk_nycschools.ui.base.BaseView;

import java.util.List;

public class MainContract {

    public interface View extends BaseView{
        void onGetSchools(List<School> schools);
        void onError( Throwable e);
    }

    public interface Presenter extends BasePresenter{

        void onAttach( View v );
        void onDetach();
        void getSchools();
    }

}
