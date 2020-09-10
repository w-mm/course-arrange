
layui.use(['form','layer','jquery','element'],function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
    var $ = layui.jquery;
    var element = layui.element;

    element.on('nav(demo)', function (elem) {
        //console.log(elem)
        layer.msg(elem.text());
    });


    var obj = document.getElementById('fileupload') ;

    $(".delete-btn").click(function () {
        console.log(123123)
       $("#fileupload").val("");
        $("#filename").val("");
        $("#filename-div").css("display","none");
    })

    var now = new Date();
    var time = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
    $("#submitDate").attr("value",time);

    $(".refer-btn").click(function () {
        $(".weiwanc").text("已完成")
    })


});