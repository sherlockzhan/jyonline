package com.jy.edu.controller;


import com.jy.edu.entity.Teacher;
import com.jy.edu.service.TeacherService;
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
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> list() {
        return teacherService.list(null);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTeacherById(@PathVariable("id") String id) {
        return teacherService.removeById(id);
    }
}

