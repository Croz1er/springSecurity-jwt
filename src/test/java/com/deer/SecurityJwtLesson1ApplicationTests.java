package com.deer;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deer.base.Result;
import com.deer.dao.AdminDao;
import com.deer.entity.Admin;
import com.deer.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = {SecurityJwtLesson1Application.class})
@RunWith(SpringRunner.class)
class SecurityJwtLesson1ApplicationTests {


    @Resource
    private AdminDao adminDao;

    @Test
    void contextLoads() {
//        List<Admin> list = adminService.list(null);
//        System.out.println(list);

//        Admin one = adminService.getOne(new QueryWrapper<Admin>().eq("user_name", "mogu2018"));
//        System.out.println(one);

        Admin admin = adminDao.selectOne(new QueryWrapper<>(new Admin()).eq("user_name", "admin"));
        Result success = Result.success(admin);
        System.out.println("=======");
        System.out.println(success);
//        System.out.println(admin);
    }

}
