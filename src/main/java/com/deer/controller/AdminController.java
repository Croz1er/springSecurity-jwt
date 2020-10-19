package com.deer.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deer.base.Result;
import com.deer.base.SysConf;
import com.deer.entity.Admin;
import com.deer.service.AdminService;
import com.deer.utils.enums.ResultCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * 管理员表(Admin)表控制层
 *
 * @author makejava
 * @since 2020-10-16 11:11:50
 */
@RestController
@RequestMapping("/auth")
public class AdminController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/info")
    public Result info(HttpServletRequest request, @RequestParam(name = "token", required = false) String token) {
        System.out.println("token"+token);
        return new Result();
    }

    @RequestMapping(value = "/select1", method = RequestMethod.GET)
    public String selectAll1() {
        System.out.println("okokokokok");
        return "hello aaaa";
    }


    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param admin 查询实体
     * @return 所有数据
     */
    @GetMapping("/select")
    public R selectAll(Page<Admin> page, Admin admin) {
        return success(this.adminService.page(page, new QueryWrapper<>(admin)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.adminService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Admin admin) {
        return success(this.adminService.save(admin));
    }

    /**
     * 修改数据
     *
     * @param admin 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Admin admin) {
        return success(this.adminService.updateById(admin));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.adminService.removeByIds(idList));
    }
}
