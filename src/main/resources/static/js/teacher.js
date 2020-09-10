layui.use(['layer','jquery','element','form', 'layedit', 'laydate'],function () {

    var layer = layui.layer
         ,$ = layui.jquery
        , element = layui.element
         ,form = layui.form
        ,layedit = layui.layedit
        ,laydate = layui.laydate;


    element.on('nav(demo)', function(elem){
        //console.log(elem)
        layer.msg(elem.text());
    });



    //   创建/加入课程的下拉列表 点击事件
    $("#addCourseBtn").click(function () {
        $(".Addbutton-low-div").css("display","block");
        $(".Addbutton-low-div").focus();
    })

    // $(document).bind("click",function(e){
    //     var target  = $(e.target);
    //     if(target.closest(".Addbutton-low-div").length == 1 ){
    //         $(".Addbutton-low-div").css("display","none")
    //     }
    // })
    //点击其他地方页面消失
    document.addEventListener('click',function(e){
        if(e.target.className!='Addbutton' && e.target.className!='Addbutton-low-div'){
            $(".Addbutton-low-div").css("display","none")
        }
    })

        //创建课程
    $(".a-creatButton").click(function () {
        radomCode();
        $(".StuBody1").css("display","block");
    })

    $(".creatClose-Btn").click(function () {

        $(".StuBody1").css("display","none");
    })
    $(".close-icon").click(function () {
        $(".StuBody1").css("display","none");
    })

        //加入课程按钮
    $(".a-Addbutton").click(function () {
        $(".StuBody2").css("display","block");
    })
        //取消按钮
    $(".cancelBtn").click(function () {
        $(".StuBody2").css("display","none");
    })

    //快速发布活动事件
    $("#fast-publish").click(function () {

        $(".StuBody3").css("display","block");
    })
    $(".close-img").click(function () {
        $(".StuBody3").css("display","none");
    })

    //点击作业打开发布作业页面

    $("#zuoye").click(function () {
        $(".StuBody5").css("display","block")
        //生成随机6位数作业号
        var Num="";
        for(var i=0;i<6;i++)
        {
            Num+=Math.floor(Math.random()*10);
        }
        $(".homeworkId").attr("value",Num)
    })

    //生成随机数
    function radomCode() {
        var randomcode = "";
        // 用字符数组的方式随机
        // var model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // var m = model.toCharArray();
        var m=['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
        for (var j = 0; j < 6; j++) {
            console.log(Math.floor(Math.random() * 36));
            var code = m[Math.floor(Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            // if (randomcode.indexOf(code)) {
            //     j--;
            //     // continue;
            // }
            console.log(code)
            randomcode = randomcode + code;
        }

        $(".courseId-input").val(randomcode);
    }

    //点击更多

    $(".more-span").each(function(){

        $(this).click(function () {
            var cl=this.id.slice(2)
            // console.log(this.id.slice(2))
            // if (this.id.slice(2))
            $(".more-div").each(function () {
                var di=this.id
                if (cl==di){
                   $(this).css("display","block");
                   $(".deleteCourseId").attr("value",di);

                }
            })
        })
    });
    document.addEventListener('click',function(e){
        if(e.target.className!='more-span' && e.target.className!='more-div'){
            $(".more-div").css("display","none")
        }
    })

    //编辑课程
    $(".edit").on("click",function(){

        $(".StuBody4").css("display","block");
        var ed=this.id;
        $(".courseId-input").attr("value",ed);



    });


    $(".close-edit").click(function () {
        $(".StuBody4").css("display","none")
    })
    $("#cancel-edit").click(function () {
        $(".StuBody4").css("display","none")
    })

    //删除课程按钮
    $(".delete-li").click(function () {
        $(".delete-div").css("display","block")
    })
    //取消删除
    $("#cancelDelete").click(function () {
        $(".delete-div").css("display","none")
    })


    //发布作业面板----------------------------------------

    //获取当前发布时间
    var now = new Date();
    var time = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
    $(".publishDate").attr("value",time)

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');
    //设置编辑器的高度
    layedit.build('LAY_demo_editor', {
        height: 100 //设置编辑器高度
    });

    //设置截至时间的前后若干天可选，
    laydate.render({
        elem: '#test-limit2'
        ,min: 0
        ,max: 14
    });

    //是否查重
    form.on('switch(switchTest)', function(data){
        if (this.checked){
            $(".jiexian").css("display","block")
            $(".dahui").css("display","block")
        }else {
            $(".jiexian").css("display","none")
            $(".dahui").css("display","none")
        }

        // layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
        //     offset: '6px'
        // });
        // layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
    });

    //点击x和取消按钮关闭页面
    $(".publish-guanbi-img").click(function () {
        $(".StuBody5").css("display","none")
    })
    $(".quxiao").click(function () {
        $(".StuBody5").css("display","none")
    })
});


