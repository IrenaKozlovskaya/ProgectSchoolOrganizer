package com.myapp.repository.impl;

import com.myapp.model.Role;
import com.myapp.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final String sqlGetRolesByUser = "SELECT *  FROM roles r INNER JOIN user_roles u_r ON r.id = u_r.role_id INNER JOIN users u ON u.id=u_r.user_id WHERE u.email = ?";
    private final String sqlGetRole = "SELECT *  FROM roles r WHERE r.role = ?";

    private final JdbcTemplate jdbcTemplate;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleDaoImpl(JdbcTemplate jdbcTemplate, RoleMapper roleMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.roleMapper = roleMapper;
    }


    @Override
    public List<Role> getRolesByUserEmail(String email) {

        return jdbcTemplate.query(sqlGetRolesByUser, roleMapper, email);
    }

    @Override
    public Role getRoleByName(String name) {

        return jdbcTemplate.query(sqlGetRole, roleMapper, name)
                .stream().findAny().orElse(null);
    }


}
