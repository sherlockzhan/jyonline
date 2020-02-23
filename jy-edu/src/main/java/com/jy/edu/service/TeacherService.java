package com.jy.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.edu.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 炘爷
 * @since 2020-02-21
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 根据条件进行分页查询
     * @param param
     * @param teacherQuery
     */
    void pageQuery(Page<Teacher> param, TeacherQuery teacherQuery);
}
