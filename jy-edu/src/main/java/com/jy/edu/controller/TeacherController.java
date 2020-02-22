package com.jy.edu.controller;


import com.jy.edu.entity.Teacher;
import com.jy.edu.service.TeacherService;
import com.jy.edu.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 炘爷
 * @since 2020-02-21
 */
@RestController
@RequestMapping("/edu/teacher")
@Api(description="讲师管理")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    @ApiOperation(value = "所有讲师列表")
    public PageResult list() {
        List<Teacher> teacherList = teacherService.list(null);
        return PageResult.ok().setData("list", teacherList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除讲师")
    public boolean deleteTeacherById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable("id") String id) {
        return teacherService.removeById(id);
    }
}

