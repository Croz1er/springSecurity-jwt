package com.deer;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deer.base.Result;
import com.deer.dao.AdminDao;
import com.deer.entity.Admin;
import com.deer.service.AdminService;
import com.deer.service.WebVisitService;
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
    private WebVisitService webVisitService;

    @Test
    void contextLoads() throws Exception {
        List<String> visWeek = webVisitService.getWebVisWeek();
        System.out.println(visWeek);
        List<String> webVisPV = webVisitService.getWebVisPV();
        System.out.println(webVisPV);
        List<String> webVisUV = webVisitService.getWebVisUV();
        System.out.println(webVisUV);
    }

}
