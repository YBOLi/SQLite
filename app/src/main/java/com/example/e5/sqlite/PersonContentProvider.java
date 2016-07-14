package com.example.e5.sqlite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by E5 on 2016/7/13.
 */
public class PersonContentProvider extends ContentProvider{
    private static final int QUEYSUCESS = 0;  // ctrl + shift + X(变大写)   变小写  + y
    private static final int INSERTSUCESS = 1;

    private static final int UPDATESUCESS  = 2;

    private static final int DELSUCESS  = 3;

    //1 想使用内容提供者 必须定义 匹配规则   code:定义的匹配规则 如果 匹配不上  有一个返回码  -1
    static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    private PersonSQLiteOpenHelper helper;

    //2 我要添加匹配规则

    static{
        //开始添加匹配规则
        /**
         * authority   主机名  通过主机名来访问我暴露的数据
         * path   你也可以随意 写 com.itheima.contentprovider/query
         * code 匹配码
         */
        matcher.addURI("com.example.e5.sqlite.persondb", "query", QUEYSUCESS);
        //添加插入匹配规则
        matcher.addURI("com.example.e5.sqlite.persondb", "insert", INSERTSUCESS);
        //添加更新匹配规则
        matcher.addURI("com.example.e5.sqlite.persondb", "update", UPDATESUCESS);
        //添加删除匹配规则
        matcher.addURI("com.example.e5.sqlite.persondb", "delete", DELSUCESS);


    }

    @Override
    public boolean onCreate() {
        helper = new PersonSQLiteOpenHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int match = matcher.match(uri);

        if (match == QUEYSUCESS ) {
            //说明匹配成功
            SQLiteDatabase db = helper.getReadableDatabase();  //获取数据库对象
            Cursor cursor = db.query("F", projection, selection, selectionArgs, null, null, sortOrder);



            return cursor;

        }else{

            throw new IllegalArgumentException("路径匹配失败");

        }
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
