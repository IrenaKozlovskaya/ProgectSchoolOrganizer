package com.myapp.service.impl;

import com.myapp.model.Role;
import com.myapp.repository.RoleDao;
import com.myapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void setUpDefaultUserRole(Long id) {
        try {
            roleDao.setUpDefaultRole(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> getRolesByUser(String email) {
        try {
            return roleDao.getRolesByUserEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Role getRole(String name) {
        try {
            return roleDao.getRoleByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
