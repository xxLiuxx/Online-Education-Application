package com.xxLiuxx.eduservice.service;

import com.xxLiuxx.commonutils.entity.PageResult;
import com.xxLiuxx.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxLiuxx.eduservice.entity.bo.TeacherQuery;

import java.util.List;

/**
 * <p>
 * Teacher Service
 * </p>
 *
 * @author Yuchen Liu
 * @since 2021-01-12
 */
public interface EduTeacherService extends IService<EduTeacher> {
    /**
     * query teacher (with conditions) with pagination
     * @param pageNumber
     * @param limit
     * @param teacherQuery
     * @return PageResult
     */
    PageResult<EduTeacher> queryTeacherByPage(Long pageNumber, Long limit, TeacherQuery teacherQuery);

    /**
     * query teacher with limit
     * @return
     */
    List<EduTeacher> queryTeacherWithLimit();

    /**
     * get front teacher list with pagination
     * @param page
     * @param limit
     * @return
     */
    PageResult<EduTeacher> getFrontTeacherList(Long page, Long limit);
}
