package com.wmm.ketangpai.entity;

import lombok.Data;
import lombok.ToString;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {

    private String userId;

    private String userPassword;

    private String userName;

    private String userSchool;

    private String userRole;

    private String studentNumber;


    //    course表中的字段
    private String courseId;
    private String courseName;
    private String courseClass;
    private String courseYear;
    private String courseTerm;
    private Integer memberCount;
    private byte operateModel;

    //    teacherCourse表中的字段
    private String teacherId;
    //    private String courseId;
    private String courseState;  //课程状态
    private String teacherName;

    //studentCourse表中的字段
    private String studentId;
    //    private String courseId;
    private String score;  //课程状态
    private String studentName;

    //homework表
    private String homeworkId;
    private Data publishDate;
    private String homeworkName;
    private String homeworkIntroduction;
}
