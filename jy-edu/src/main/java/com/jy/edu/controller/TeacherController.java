package com.jy.edu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.edu.entity.Teacher;
import com.jy.edu.query.TeacherQuery;
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

    @GetMapping("/one/{id}")
    @ApiOperation(value = "根据ID查询讲师")
    public PageResult one(
            @ApiParam(value = "讲师ID")
            @PathVariable("id") Long id) {
        Teacher teacher = teacherService.getById(id);
        return PageResult.ok().setData("teacher", teacher);
    }

    @GetMapping("/all")
    @ApiOperation(value = "所有讲师列表")
    public PageResult list() {
        List<Teacher> teacherList = teacherService.list(null);
        return PageResult.ok().setData("list", teacherList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除讲师")
    public boolean deleteById(
            @ApiParam(value = "讲师ID")
            @PathVariable("id") String id) {
        return teacherService.removeById(id);
    }

    @PostMapping("/{page}/{size}")
    @ApiOperation(value = "讲师列表分页")
    public PageResult pageQuery(
            @ApiParam(value = "当前页数")
            @PathVariable("page") Long page,

            @ApiParam(value = "每页记录数")
            @PathVariable("size") Long size,

            @ApiParam(value = "查询条件")
            @RequestBody
            TeacherQuery teacherQuery) {

        Page<Teacher> param = new Page<>(page,size);
        //teacherService.page(param, null);
        teacherService.pageQuery(param, teacherQuery);
        //分页列表
        List<Teacher> records = param.getRecords();
        //总记录数
        long total = param.getTotal();
        return PageResult.ok().setData("records", records).setData("total", total);
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增讲师")
    public PageResult save(
            @ApiParam(value = "讲师")
            @RequestBody Teacher teacher) {
        return teacherService.save(teacher) ? PageResult.ok():PageResult.error();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改讲师")
    public PageResult update(
            @ApiParam(value = "讲师")
            @RequestBody Teacher teacher) {
        return teacherService.updateById(teacher) ? PageResult.ok():PageResult.error();
    }
}

