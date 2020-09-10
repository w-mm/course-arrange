package com.wmm.ketangpai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseSelectCount {
    private String courseId;
    private String studentId;
    private String count;
    private String score;
}
