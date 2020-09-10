package com.wmm.ketangpai.controller;


import com.wmm.ketangpai.controller.UsersController;
import com.wmm.ketangpai.entity.*;
import com.wmm.ketangpai.service.CourseService;
import org.hibernate.Session;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/referHk")
    public String lookCourseInfo(String homeworkId,String studentId,HttpSession session){
        List<Course> stucourseInfo = courseService.lookCourseInfo(homeworkId);
        session.setAttribute("stucourseIfo",stucourseInfo);
        List<StuHomeworkDis> seeH = courseService.lookHomework(homeworkId, studentId);
        session.setAttribute("seeH",seeH);
        return "redirect:/referHomework";
    }
    @PostMapping("/uploadHomework")
    public String sendHomework(@RequestParam("file")MultipartFile file,StuHomework stuHomework) throws Exception{
        courseService.sendHomework(stuHomework);
        String filePath=file.getOriginalFilename();
        BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(filePath));
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();
        return "redirect:/student";
//        return "";
    }

    @GetMapping("/teacherLook")
    public String selectCj(String homeworkId,HttpSession session){
        List<CjInfo> cjInfos = courseService.selectCj(homeworkId);
        session.setAttribute("cjInfos",cjInfos);
        List<StuHomeworkDis> stuHomeworkDis = courseService.StuHomeworkDis(homeworkId);
        session.setAttribute("stuHomeworkDis",stuHomeworkDis);
        List<StuHomeworkDis> personCount = courseService.personCount(homeworkId);
        session.setAttribute("personCount",personCount);
        return "redirect:/teacherLh";
    }
//    更新学生分数
    @RequestMapping("/updateScore")
    public String updateScore(StuHomeworkDis stuHomeworkDis, HttpServletResponse response){
        courseService.updateScore(stuHomeworkDis);
       String msg="123123";
       return "3";
    }
}
