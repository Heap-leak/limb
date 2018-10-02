package com.limb.domain.queries;

public class SqlQueries {
    public static final String GET_USER_Q = "select username, password, active " +
            "from usr " +
            "where username=?";
    public static final String GET_USERS_AND_ROLES_Q = "select u.username, ur.roles " +
            "from usr u inner join user_roles ur " +
            "on u.id = ur.user_id " +
            "where u.username=?";
}
