package com.northgatecode.hellossm.controllers.mappers;

/**
 * Created by user on 2016/12/3.
 */
public class DynamicSQLProvider {
public String getsearch(String name, Integer genderId, int offest, int limit){
   String sql = "SELECT * FROM student ";
    String and = "WHERE ";
    if (name != null && name.length() > 0) {
        sql += and + "(student.name LIKE '%" + name + "%' " +
                "OR student.mobile LIKE '%" + name + "%' " +
                "OR student.email LIKE '%" + name + "%') ";
        and = "AND ";
    }
    if (genderId != null && genderId != 0) {
        sql += and + "student.gender_id = " + genderId + " ";
        and = "AND ";
    }
    sql += "ORDER BY student.id ";
    sql += "LIMIT " + offest + ", " + limit + " ";
    System.out.println(sql);
    return sql;
}
    public String getUsersByCriteria(String searchText, int offset, int limit) {
        String sql = "SELECT * FROM user ";
        String and = "WHERE ";
        if (searchText != null && searchText.length() > 0) {
            sql += and + "(name LIKE '%" + searchText + "%' " +
                    "OR mobile LIKE '%" + searchText + "%' " +
                    "OR email LIKE '%" + searchText + "%') ";
            and = "AND ";
        }
        sql += "ORDER BY id ";
        sql += "LIMIT " + offset + ", " + limit + " ";
        System.out.println(sql);
        return sql;
    }
}
