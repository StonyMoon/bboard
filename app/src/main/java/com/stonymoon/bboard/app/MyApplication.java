package com.stonymoon.bboard.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.stonymoon.bboard.bean.SingerBean;
import com.stonymoon.bboard.dao.DaoMaster;
import com.stonymoon.bboard.dao.DaoSession;
import com.tencent.bugly.Bugly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplication extends Application {

    //静态单例
    public static MyApplication instances;
    private static Map<Integer, String> singers = new HashMap<>();
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static MyApplication getInstances() {
        return instances;
    }

    public static String getSinger(int id) {
        return singers.get(id);
    }

    public static String putSinger(int id, String des) {
        return singers.put(id, des);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
        Bugly.init(getApplicationContext(), "ee3f639d67", true);
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "sport-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}