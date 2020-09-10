
layui.use(['form','layer','jquery','element'],function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
    var $ = layui.jquery;
    var element = layui.element;

    element.on('nav(demo)', function (elem) {
        //console.log(elem)
        layer.msg(elem.text());
    });

    //点击显示是否显示学生成绩的下拉列表
    $(".span-forStudent").click(function () {
        $(".student-score-dispaly-div").css("display","block");
    })

    $(".xianshi").click(function () {
        $(".span-forStudent").html("对学生显示成绩");
        $(".student-score-dispaly-div").css("display","none");
    })

    $(".yingc").click(function () {
        $(".span-forStudent").html("对学生隐藏成绩");
        $(".student-score-dispaly-div").css("display","none");
    })
    

});
