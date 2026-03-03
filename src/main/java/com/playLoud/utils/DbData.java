package com.playLoud.utils;

public class DbData {

    //connection URL - syntax: "jdbc:postgresql(mysql)://ipaddress:portnumber/db_name"
    public static final String dbUrl = "jdbc:postgresql://localhost:5433/playloud";

    //DB username
    public static final String username = "queen";

    //db password
    public static final String password = "kotikspit1";

    //query to execute
    public static final String querySelect = "select * from \"User\";";
    public static final String queryDelete = "delete from \"User\" where \"id\"=?;";

}
