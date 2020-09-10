package com.wmm.ketangpai.controller;


import com.wmm.ketangpai.controller.CourseController;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.wmm.ketangpai.Utils.CommonUtil;
import com.wmm.ketangpai.entity.*;
import com.wmm.ketangpai.service.CourseService;
import com.wmm.ketangpai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class UsersController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Resource
    private DefaultKaptcha captchaProducer;


    //登陆方法

    @PostMapping("/login1")
    public String login(@RequestParam("userId") String userId, @RequestParam(value = "userPassword",required=false) String userPassword, HttpSession session){
        Users login=userService.login(userId,userPassword);

        if (login!=null &&  "学生".equals(login.getUserRole())){
            session.setAttribute("users",login);
            return findStudentAll(session,userId);
        }else if(login!=null &&  "老师".equals(login.getUserRole())){

            session.setAttribute("users",login);
            return findTeacherAll(session,userId);
//            return "redirect:/findTeacherAll"; //登陆失败后跳转到登陆页面   redirect: 重定向
        }else {
            return "redirect:/login";
        }
    }
    //注册方法

    @PostMapping("/register1")
    public String register(Users users){
        if (users.getUserId()!=null&&users.getUserPassword()!=null&&users.getUserName()!=null&&users.getUserSchool()!=null&&users.getUserId()!=""&&users.getUserPassword()!=""&&users.getUserName()!=""&&users.getUserSchool()!=""){
            userService.register(users);
            if ("老师".equals(users.getUserRole())){
                userService.registerT(users);
                return "redirect:/login"; //跳转到登陆页面
            }else if ("学生".equals(users.getUserRole())){
                userService.registerS(users);
                return "redirect:/login"; //跳转到登陆页面
            }else {
                return "redirect:/register";//注册失败返回注册页面
            }
        }
        else {
            return "redirect:/register";//注册失败返回注册页面
        }
    }

    //生成验证码
    /**
     * 验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";
    /**
     * 验证码图片
     */
    @RequestMapping(value = {"/loginValidateCode"})
    public void loginValidateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        CommonUtil.validateCode(request,response,captchaProducer,LOGIN_VALIDATE_CODE);
    }

    /**
     * 检查验证码是否正确
     */
    @RequestMapping("/checkLoginValidateCode")
    @ResponseBody
    public HashMap checkLoginValidateCode(HttpServletRequest request, @RequestParam("validateCode")String validateCode) {
        String loginValidateCode = request.getSession().getAttribute(LOGIN_VALIDATE_CODE).toString();
        HashMap<String,Object> map = new HashMap<String,Object>();
        if(loginValidateCode == null){
            map.put("status",null);//验证码过期
        }else if(loginValidateCode.equals(validateCode)){
            map.put("status",true);//验证码正确
        }else if(!loginValidateCode.equals(validateCode)){
            map.put("status",false);//验证码不正确
        }
        map.put("code",200);
        return map;
    }

    //老师创建课程
    @PostMapping("/creatCourse")
    public String creatCourse(Course course, TeacherCourse teacherCourse,HttpSession session){
        System.out.println(teacherCourse);
        courseService.insertTeacherCourse(teacherCourse);
        courseService.creatCourse(course);
        return findTeacherAll(session,teacherCourse.getTeacherId());
    }


    //更新课程信息
    @PostMapping("/editCourse")
    public String editCourse(Course course,HttpSession session){
        courseService.editCourse(course);
        return findTeacherAll(session,course.getTeacherId());
    }


    //老师删除课程
    @PostMapping("/deleteCourse")
    public String deleteCourse(String courseId,HttpSession Session,String teacherId){
        courseService.deleteCourse(courseId);
        courseService.deleteCourseFromTeacher(courseId);
        return findTeacherAll(Session,teacherId);

    }

    //学生添加课程
    @PostMapping("/saveCourse")
    public String saveCourse( Stucourse stucourse,HttpSession session){

        if(stucourse.getCourseId()!=""){
            courseService.saveCourse(stucourse);
            System.out.println(stucourse);
            return findStudentAll(session,stucourse.getStudentId());
        }
        else {
            return "";
        }

    }
    //老师添加课程
    @PostMapping("/saveCourseT")
    public String saveCourseT( Stucourse stucourse,HttpSession session){

        if(stucourse.getCourseId()!=""){
            courseService.saveCourse(stucourse);
            System.out.println(stucourse);
            return findTeacherAll(session,stucourse.getStudentId());
        }
        else {
            return "";
        }

    }

    //学生退课
    @GetMapping("/cancelCourse")
    public String cancelCourse(String studentId,String courseId,HttpSession session){
        courseService.cancelCourse(studentId,courseId);
        return findStudentAll(session,studentId);
    }


    //查询老师所有课程
    public String findTeacherAll(HttpSession session, String userId){
        List<Course> teacherCourse=courseService.findTeacherCourse(userId);
        session.setAttribute("teacherCourse",teacherCourse);
        List<Course> teacherCourseHomework=courseService.findTeacherCourseHomework(userId);
        session.setAttribute("teacherCourseHomeWork",teacherCourseHomework);

        List<CourseSelectCount> selectCounts=courseService.selectCount();
        session.setAttribute("selectCounts",selectCounts);

        return "redirect:/teacher";
    }

    //查询学生所有课程
    public String findStudentAll(HttpSession session, String userId){
        //查询学生课程
        List<Users> studentCourse = userService.findStudentCourse(userId);
        session.setAttribute("studentCourse", studentCourse);
        //查询学生课程作业
        List<Users> studentCourseHome=userService.findStudentCourseHomework(userId);
        System.out.println(studentCourseHome);
        session.setAttribute("studentCourseHome", studentCourseHome);

        return "redirect:/student";  //登陆成功跳转到主页面
    }

    //发布作业
    @PostMapping("/publishHomework")
    public String publishHomework(Course course,HttpSession session){
        courseService.publishHomework(course);
        courseService.insertCouHomework(course);
        return findTeacherAll(session,course.getTeacherId());
    }
}
