package io.goorm.mini.service;


import io.goorm.mini.mapper.AdminMapper;
import io.goorm.mini.domain.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@org.springframework.stereotype.Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


    public List<Admin> findAll() {

        return adminMapper.selectAll();
    }

    public Admin find(Long adminSeq) {

        return adminMapper.selectById(adminSeq);
    }

    public int save(Admin admin) {

        return adminMapper.insert(admin);
    }

    public int update(Admin admin) {

        return adminMapper.update(admin);
    }

    public int remove(Admin admin) {

        return adminMapper.updateUseYn(admin);
    }

    public int updatePublishYn(Admin admin) {

        return adminMapper.updateUseYn(admin);
    }

}
