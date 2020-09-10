package com.wmm.ketangpai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherCourse {
    private String teacherId;
    private String courseId;
    private String courseState;
}
