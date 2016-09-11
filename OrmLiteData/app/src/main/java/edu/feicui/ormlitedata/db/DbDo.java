package edu.feicui.ormlitedata.db;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MMQ on 2016/8/3.
 */
public class DbDo {

    private Dao<DbBiao,Long> dao;//这个就是数据库的操作类对象

    /**调用这个类就需要传入一个openHelper对象，所以要先实例化创建表*/
    public DbDo(DbOrmLiteHelper dbOrmLiteHelper) {

        try {
            //创建出仓库类别表的Dao,也就是能操作的对象
             dao=dbOrmLiteHelper.getDao(DbBiao.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** 添加和更新 仓库列表和数据*/
    public void createOrUpdate(DbBiao dbBiao){
        try {
            //里面传入自定义创建的一个表的属性对象
            dao.createOrUpdate(dbBiao);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** 查询制定Id,返回自定义的表的对象*/
    public void findForId(Long id){
        try {
            dao.queryForId(id);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** 删除*/
    public void deleteforId(Long id){
        try {
            dao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** 查找所有，用list<自定义的表的类>来接受所有的*/
    public List<DbBiao> findAll(){
        List<DbBiao> list=new ArrayList<>();
        try {
            list=dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
