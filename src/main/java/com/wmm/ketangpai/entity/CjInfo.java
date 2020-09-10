package com.wmm.ketangpai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CjInfo {
    private String courseId;
    private String courseName;
    private String homeworkName;
    private String deadline;
}
