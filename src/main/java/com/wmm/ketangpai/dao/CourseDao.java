package com.wmm.ketangpai.dao;

import com.wmm.ketangpai.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseDao {

    //学生通过课程号添加课程
    void saveCourse(Stucourse stucourse);
    //老师通过课程号添加课程
    void saveCourseT(TeacherCourse teacherCourse);
    // 学生退课
    void cancelCourse(String studentId,String courseId);

    //学生通过作业号在提交作业页面查看作业信息
    List<Course> lookCourseInfo(String homeworkId);
    //学生在提交作业页面查看是否已经提交作业
    List<StuHomeworkDis> lookHomework(String homeworkId,String studentId);

    //通过老师ID查询该老师的所有课程查询老师的所有课
    List<Course> findTeacherCourse( String teacherId);
    //通过老师ID查询该老师的所有课程查询老师的所有课的作业
    List<Course> findTeacherCourseHomework( String teacherId);
    //查询所选该老师课的人数
    List<CourseSelectCount> selectCount();
    //老师创建课程
    void creatCourse(Course course);
    void insertTeacherCourse(TeacherCourse teacherCourse);
    //编辑课程
        //将课程写入编辑表单
    Course findCourseInfo(String courseId);
        //将课程表更新
    void editCourse(Course course);

    //删除老师选择的课
    void deleteCourse(String courseId);
    void deleteCourseFromTeacher(String courseId);

    //老师发布作业
    void publishHomework(Course course);
    void insertCouHomework(Course course);

    //学生提交作业
    void sendHomework(StuHomework stuHomework);


    //老师点击课程作业查询所有学生的提交情况
    List<CjInfo> selectCj(String homeworkId);
        //在老师批改作业页面对学生的作业进行展示
    List<StuHomeworkDis> StuHomeworkDis(String homeworkId);

    //查询一个班级有多少人
    List<StuHomeworkDis> personCount(String homeworkId);

    //更新学生分数
    void updateScore(StuHomeworkDis stuHomeworkDis);
}
