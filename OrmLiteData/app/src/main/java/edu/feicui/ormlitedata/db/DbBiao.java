package edu.feicui.ormlitedata.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by MMQ on 2016/8/3.
 */
 @DatabaseTable (tableName = "my_table")
public class DbBiao {

    //主键的创建
    @DatabaseField (id = true)
    private int id;

    /**表中的其他属性*/

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "sex")
    private String sex;

    public DbBiao() {
    }

    public DbBiao(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "DbBiao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
