package com.wmm.ketangpai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StuHomework {
    private String studentId;
    private String homeworkId;
    private String submitDate;
    private String message;
    private String submitState;
    private Integer submitCount;
    private String score;
    private String path;
}
