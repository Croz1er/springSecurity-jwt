package com.deer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deer.dao.VisitorDao;
import com.deer.entity.Visitor;
import com.deer.service.VisitorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 游客表(Visitor)表服务实现类
 *
 * @author lujy
 * @since 2020-10-20 13:05:33
 */
@Service("visitorService")
@Transactional(readOnly = true)
public class VisitorServiceImpl extends ServiceImpl<VisitorDao, Visitor> implements VisitorService {

}
