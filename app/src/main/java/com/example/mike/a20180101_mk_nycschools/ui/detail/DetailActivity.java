package com.example.mike.a20180101_mk_nycschools.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mike.a20180101_mk_nycschools.R;
import com.example.mike.a20180101_mk_nycschools.di.DaggerDetailActivityComponent;
import com.example.mike.a20180101_mk_nycschools.model.sat_scores_repository.sat_scores_gson.SatScore;

import java.util.Objects;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    @Inject
    DetailPresenter detailPresenter;
    private TextView detailSchoolName;
    private TextView detailNumTakers;
    private TextView detailSatCriticalReading;
    private TextView detailSatMath;
    private TextView detailSatWriting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DaggerDetailActivityComponent.create().inject( this );

        detailSchoolName = findViewById( R.id.detailSchoolName );
        detailNumTakers = findViewById( R.id.detailNumTakers );
        detailSatCriticalReading = findViewById( R.id.detailSatCriticalReading );
        detailSatMath = findViewById( R.id.detailSatMath );
        detailSatWriting = findViewById( R.id.detailSatWriting );


        String schoolId = Objects.requireNonNull(getIntent().getExtras()).getString("schoolId");

        detailPresenter.getSatScoreBySchoolId(schoolId);
        detailPresenter.onAttach(this);

        detailPresenter.getSatScoreBySchoolId(schoolId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detailPresenter.onDetach();
    }

    @Override
    public void onGetSatScoreBySchoolId(SatScore satScore) {
        // Populate views
        detailSchoolName.setText( satScore.getSchoolName() );
        detailNumTakers.setText( satScore.getNumOfSatTestTakers() );
        detailSatCriticalReading.setText( satScore.getSatCriticalReadingAvgScore() );
        detailSatMath.setText( satScore.getSatMathAvgScore() );
        detailSatWriting.setText( satScore.getSatWritingAvgScore() );
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG ).show();
    }
}
