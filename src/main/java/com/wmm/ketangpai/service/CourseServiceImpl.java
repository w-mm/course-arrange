package com.wmm.ketangpai.service;

import com.wmm.ketangpai.dao.CourseDao;

import com.wmm.ketangpai.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    //学生通过课程号添加课程
    @Override
    public void saveCourse(Stucourse stucourse) {
        courseDao.saveCourse(stucourse);
    }

    //学生退课
    @Override
    public void cancelCourse(String studentId, String courseId) {
        courseDao.cancelCourse(studentId,courseId);
    }
    //学生通过作业号在提交作业页面查看作业信息
    @Override
    public List<Course> lookCourseInfo(String homeworkId) {
        return courseDao.lookCourseInfo(homeworkId);
    }


    //通过老师ID查询该老师的所有课程查询老师的所有课
    @Override
    public List<Course> findTeacherCourse(String teacherId) {
        return courseDao.findTeacherCourse(teacherId);
    }
    //通过老师ID查询该老师的所有课程查询老师的所有课的作业
    @Override
    public List<Course> findTeacherCourseHomework(String teacherId) {
        return courseDao.findTeacherCourseHomework(teacherId);
    }
    //查出选择该课程的人数
    @Override
    public List<CourseSelectCount> selectCount() {
        return courseDao.selectCount();
    }
    //老师创建课程
    @Override
    public void creatCourse(Course course) {
        courseDao.creatCourse(course);
    }
    @Override
    public void insertTeacherCourse(TeacherCourse teacherCourse) {
        courseDao.insertTeacherCourse(teacherCourse);
    }

    //老师编辑课程
    @Override
    public Course findCourseInfo(String courseId) {
        return courseDao.findCourseInfo(courseId);
    }

    @Override
    public void editCourse(Course course) {
        courseDao.editCourse(course);
    }

    //老师删除课程
    @Override
    public void deleteCourse(String courseId) {
        courseDao.deleteCourse(courseId);
    }
    @Override
    public void deleteCourseFromTeacher(String courseId) {
        courseDao.deleteCourseFromTeacher(courseId);
    }

    //老师发布作业
    @Override
    public void publishHomework(Course course) {
        courseDao.publishHomework(course);
    }

    @Override
    public void insertCouHomework(Course course) {
        courseDao.insertCouHomework(course);
    }
    //学生提交作业
    @Override
    public void sendHomework(StuHomework stuHomework) {
        courseDao.sendHomework(stuHomework);
    }
    //学生在提交作业页面查看是否已经提交作业
    @Override
    public List<StuHomeworkDis> lookHomework(String homeworkId,String studentId) {
        return courseDao.lookHomework(homeworkId,studentId);
    }


    //老师点击课程作业查询所有学生的提交情况
    @Override
    public List<CjInfo> selectCj(String homeworkId) {
        return courseDao.selectCj(homeworkId);
    }

    //在老师批改作业页面对学生的作业进行展示
    @Override
    public List<StuHomeworkDis> StuHomeworkDis(String homeworkId) {
        return courseDao.StuHomeworkDis(homeworkId);
    }

    //查询一个班级有多少人
    @Override
    public List<StuHomeworkDis> personCount(String homeworkId) {
        return courseDao.personCount(homeworkId);
    }

    //更新学生分数
    @Override
    public void updateScore(StuHomeworkDis stuHomeworkDis) {
        courseDao.updateScore(stuHomeworkDis);
    }

}
