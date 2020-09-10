package com.wmm.ketangpai.dao;

import com.wmm.ketangpai.entity.Course;
import com.wmm.ketangpai.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersDao {
    void save(Users users);
    void saveS(Users users);
    void saveT(Users users);

    Users login(@Param("userId") String userId, @Param("userPassword") String userPassword);

//    查询学生课程和课程作业
    List<Users> findStudentCourse(@Param("userId") String userId);
    List<Users> findStudentCourseHomework(@Param("userId") String userId);



}
