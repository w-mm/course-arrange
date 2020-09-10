package com.wmm.ketangpai.service;

import com.wmm.ketangpai.entity.Course;
import com.wmm.ketangpai.entity.Users;

import java.util.List;

public interface UserService {
    Users login(String userId,String userPassword);

    void register(Users users);
    void registerT(Users users);
    void registerS(Users users);

    List<Users> findStudentCourse(String userId);
    List<Users> findStudentCourseHomework(String userId);

}
