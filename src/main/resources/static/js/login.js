



layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    $(".loginBody .seraph").click(function(){
        layer.msg("",{
            time:5000
        });
    })

    // 登录按钮
    form.on("submit(login)",function(data){
        $(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        UN="123123213";
        console.log(UN);
        setTimeout(function(){
            console.log("qweqwe");
            window.location.href = "../../templates/index.html";
        },100);
        return false;
    })


})




