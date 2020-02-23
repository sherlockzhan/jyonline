package com.jy.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.edu.entity.Teacher;
import com.jy.edu.mapper.TeacherMapper;
import com.jy.edu.query.TeacherQuery;
import com.jy.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author 炘爷
 * @since 2020-02-21
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    /**
     * 根据条件进行分页查询
     *
     * @param param
     * @param teacherQuery
     */
    @Override
    public void pageQuery(Page<Teacher> param, TeacherQuery teacherQuery) {

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        //判断teacher是否为空
        if (null == teacherQuery) {
            baseMapper.selectPage(param, queryWrapper);
            return;
        }
        //判断查询条件是否为空
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        if (!StringUtils.isEmpty(level)) {
            queryWrapper.eq("level", level);
        }

        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("begin", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("end", end);
        }
        //根据条件查询
        baseMapper.selectPage(param, queryWrapper);
    }
}
