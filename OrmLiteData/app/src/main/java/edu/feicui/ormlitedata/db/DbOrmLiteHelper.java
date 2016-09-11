package edu.feicui.ormlitedata.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by MMQ on 2016/8/3.
 */
public class DbOrmLiteHelper extends OrmLiteSqliteOpenHelper {
    private static final String DB_NAME="Demo.db";//创建的db文件的名字

    private static final int VERSION=1;//版本好

   public static DbOrmLiteHelper dbOrmLiteHelper;



    /* 单例 **/
    public static DbOrmLiteHelper getInstant(Context Ct){
        if(dbOrmLiteHelper==null){
            dbOrmLiteHelper=new DbOrmLiteHelper(Ct.getApplicationContext());
        }
        return dbOrmLiteHelper;
    }



    private DbOrmLiteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    /** 表的创建*/
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            //在创建好的db文件中创建表，全面传的是资源，     后面传入的是我们定义好的表中的属性。
            TableUtils.createTableIfNotExists(connectionSource, DbBiao.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** 表的更新*/
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            /**表的更新，前面传入资源，后面是自己创建好的表的属性*/
            TableUtils.dropTable(connectionSource,DbBiao.class,true);

            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
