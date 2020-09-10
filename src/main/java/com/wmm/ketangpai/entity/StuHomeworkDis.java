package com.wmm.ketangpai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StuHomeworkDis {
    private String studentId;
    private String homeworkId;
    private String studentNumber;
    private String studentName;
    private String score;
    private String submitDate;
    private String path;
    private String personCount;
}
