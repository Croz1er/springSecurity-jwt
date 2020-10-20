package com.deer.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deer.entity.Visitor;
import com.deer.service.VisitorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 游客表(Visitor)表控制层
 *
 * @author lujy
 * @since 2020-10-20 13:05:33
 */
@RestController
@RequestMapping("visitor")
public class VisitorController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private VisitorService visitorService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param visitor 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Visitor> page, Visitor visitor) {
        return success(this.visitorService.page(page, new QueryWrapper<>(visitor)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.visitorService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param visitor 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Visitor visitor) {
        return success(this.visitorService.save(visitor));
    }

    /**
     * 修改数据
     *
     * @param visitor 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Visitor visitor) {
        return success(this.visitorService.updateById(visitor));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.visitorService.removeByIds(idList));
    }
}
