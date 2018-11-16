package com.example.mike.a20180101_mk_nycschools.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mike.a20180101_mk_nycschools.R;
import com.example.mike.a20180101_mk_nycschools.model.school_repository.school_gson.School;
import com.example.mike.a20180101_mk_nycschools.ui.detail.DetailActivity;

import java.util.List;

public class SchoolRecyclerAdapter extends RecyclerView.Adapter<SchoolRecyclerAdapter.ViewHolder> {

    List<School> items;

    public SchoolRecyclerAdapter( List<School> items ){
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.list_item_main, viewGroup, false );
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        School s = items.get(i);

        viewHolder.schoolName.setText( s.getSchoolName() );

        final String schoolId = s.getDbn();
        viewHolder.schoolID.setText( String.format("ID:%s", schoolId) );
        viewHolder.schoolAddress.setText( String.format("%s, %s, %s", s.getPrimaryAddressLine1(), s.getStateCode(), String.valueOf(s.getZip())) );
        viewHolder.schoolPhoneNumber.setText( s.getPhoneNumber() );

        // Setting website link
        final String websiteUrl = s.getWebsite();
        viewHolder.schoolWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Intent.ACTION_VIEW );
                if (!websiteUrl.startsWith("http://") && !websiteUrl.startsWith("https://")){
                    intent.setData(Uri.parse("http://"+ websiteUrl ) );
                }else{
                    intent.setData(Uri.parse( websiteUrl ) );
                }
                v.getContext().startActivity( intent );
            }
        });

        // Setting detail page redirect
        viewHolder.schoolDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( v.getContext(), DetailActivity.class);
                intent.putExtra("schoolId", schoolId);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView schoolName;
        TextView schoolID;
        TextView schoolAddress;
        TextView schoolPhoneNumber;
        Button schoolWebsite;
        Button schoolDetail;
        View daddyView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            daddyView = itemView;
            schoolName = itemView.findViewById( R.id.schoolName );
            schoolID = itemView.findViewById( R.id.schoolID );
            schoolAddress = itemView.findViewById( R.id.schoolAddress );
            schoolPhoneNumber = itemView.findViewById( R.id.schoolPhoneNumber );
            schoolWebsite = itemView.findViewById( R.id.schoolWebsite );
            schoolDetail = itemView.findViewById( R.id.schoolDetail );
        }
    }

}
