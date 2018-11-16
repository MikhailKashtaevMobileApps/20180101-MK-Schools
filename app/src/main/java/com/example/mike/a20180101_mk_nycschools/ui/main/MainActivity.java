package com.example.mike.a20180101_mk_nycschools.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mike.a20180101_mk_nycschools.R;
import com.example.mike.a20180101_mk_nycschools.di.DaggerMainActivityComponent;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.school_gson.School;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainPresenter presenter;
    private SchoolRecyclerAdapter adapter;
    private RecyclerView rvSchools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainActivityComponent.create().inject(this);

        rvSchools = findViewById( R.id.rvSchools );
        adapter = new SchoolRecyclerAdapter( new ArrayList<School>() );
        rvSchools.setLayoutManager( new LinearLayoutManager(this));
        rvSchools.setAdapter(adapter);

        presenter.onAttach(this);
        presenter.getSchools();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void onGetSchools(List<School> schools) {
        adapter.items = schools;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
