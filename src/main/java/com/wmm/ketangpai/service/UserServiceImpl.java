package com.wmm.ketangpai.service;

import com.wmm.ketangpai.dao.UsersDao;
import com.wmm.ketangpai.entity.Course;
import com.wmm.ketangpai.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UsersDao usersDao;

//    登陆
    @Override
    public Users login(String userId, String userPassword) {
        return usersDao.login(userId,userPassword);

    }
//注册
    @Override
    public void register(Users users) {
        usersDao.save(users);
    }

    @Override
    public void registerT(Users users) {
        usersDao.saveT(users);
    }

    @Override
    public void registerS(Users users) {
        usersDao.saveS(users);
    }

//    查询学生课程
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Users> findStudentCourse(String userId) {
        return usersDao.findStudentCourse(userId);
    }
    //    查询学生课程作业
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Users> findStudentCourseHomework(String userId) {
        return usersDao.findStudentCourseHomework(userId);
    }


}
