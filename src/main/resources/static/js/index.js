layui.use(['carousel','form','layer','jquery','element'],function () {
    var form = layui.form,
    layer = parent.layer === undefined ? layui.layer : top.layer
    var $ = layui.jquery;
    var element = layui.element;
    var carousel = layui.carousel;


    element.on('nav(demo)', function(elem){
        //console.log(elem)
        layer.msg(elem.text());
    });

    //常规轮播
    carousel.render({
        elem: '#test1'
        ,width: '100%'
        ,height: '520px'
        ,interval: 5000
    });



});


