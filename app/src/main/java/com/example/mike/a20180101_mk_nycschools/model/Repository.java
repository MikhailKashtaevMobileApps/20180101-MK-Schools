package com.example.mike.a20180101_mk_nycschools.model;

public class Repository {

    public interface Callback<T>{
        void onSuccess(T o);
        void onError( Throwable e );
    }

}
