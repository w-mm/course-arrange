
layui.use(['form','layer','jquery','element'],function () {
    var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer
    var $ = layui.jquery;
    var element = layui.element;

    element.on('nav(demo)', function(elem){
        //console.log(elem)
        layer.msg(elem.text());
    });

    //加入课程按钮
    $(".Addbutton").click(function () {
        $(".StuBody2").css("display","block");
    })
    //取消按钮
    $(".cancelBtn").click(function () {
        $(".StuBody2").css("display","none");
    })

    //更多
    $(".gd").each(function(){

        $(this).click(function () {
            var cl=this.id;

            $(".cancelCourse").each(function () {
                var di=this.id
                if (cl==di){
                    $(this).css("display","block");
                }
            })
        })
    });
    document.addEventListener('click',function(e){
        if(e.target.className!='gd' && e.target.className!='cancelCourse'){
            $(".cancelCourse").css("display","none")
        }
    })
});


