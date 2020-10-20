package com.deer.controller;

import com.deer.base.Result;
import com.deer.service.*;
import com.deer.utils.enums.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/20 12:31
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private BlogService blogService;
    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;
    @Resource
    private WebVisitService webVisitService;


    @GetMapping("/init")
    public Result init() {
        Map<String, Integer> map = new HashMap<>();
      /*this.blogTotal = response.data.blogCount;
        this.commentTotal = response.data.commentCount;
        this.userTotal = response.data.userCount;
        this.visitAddTotal = response.data.visitCount;*/
        System.out.println("进来了!");
        int status = 1;
        try {
            Integer blogTotal = blogService.getBlogTotal(status);
            Integer commentTotal = commentService.getCommentTotal(status);
            Integer userTotal = userService.getUserTotal(status);

            Integer visitorTotal = webVisitService.getWebVisitorTotal();


            map.put("blogCount",blogTotal);
            map.put("commentCount",commentTotal);
            map.put("userCount",userTotal);
            map.put("visitCount",visitorTotal);
        } catch (Exception e) {
            map = null;
            e.printStackTrace();
        }
        return new Result(ResultCode.SUCCESS, map);
    }


    @GetMapping("/getVisitByWeek")
    public Result getVisitByWeek() throws Exception {
        /*this.lineChartData = {
          date: visitByWeek.date,
          expectedData: visitByWeek.pv,
          actualData: visitByWeek.uv
        };*/

        List<String> webVisWeek = webVisitService.getWebVisWeek();
        List<String> webVisPV = webVisitService.getWebVisPV();
        List<String> webVisUV = webVisitService.getWebVisUV();

        Map<String, List<String>> map = new HashMap<>();

        map.put("date",webVisWeek);
        map.put("pv",webVisPV);
        map.put("uv",webVisUV);


        return new Result(ResultCode.SUCCESS,map);
    }


}
