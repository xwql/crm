
    $("#renyuanList").html("");
$("#ItemType").html("");
$.ajax({
    url:url+"/renyuan/listAll",
    async:false,
    type:"POST",
    success:function(data){
        for(var i=0;i<data.length;i++){
            $("#renyuanList").append("<option value='"+data[i].ID+"'>"+data[i].xingming+"</option>")
        }
    },
    error:function(){
        console.log("出错！");
    }
});
$.ajax({
    url:url+"/entryItem/listEntryItemsByType",
    async:false,
    type:"POST",
    success:function(data){
        $("#ItemType").append("<option value=''>请选择词条分类</option>")
        for(var i=0;i<data.length;i++){
            $("#ItemType").append("<option value='"+data[i]+"'>"+data[i]+"</option>")
        }
    },
    error:function(){
        console.log("出错！");
    }
});

<!--加载完数据后再加载该js-->

//给作业项目框赋值
var form = layui.form;
form.on('select(selectItem)', function(choose){
    $("#ItemInfo").html("");
    $("#ItemInfo").append("<option value=''>请选择词条项目</option>");
    $("#ItemIntegral1").val("")
    var type = choose.value;
    $.ajax({
        url:url+"/entryItem/getEntryItemByType/"+type,
        type:"POST",
        success:function(data){
            $("#ItemType").append("<option value='' score='0'>请选择词条项目</option>")
            for(var i=0;i<data.length;i++){
                $("#ItemInfo").append("<option score='"+data[i].score+"' value='"+data[i].id+"'>"+data[i].item+"</option>");
            }
            form.render();
        },
        error:function(){
            console.log("出错！");
        }
    });
});

//给分数框赋值(这里是捕获上面定义的select改变事件，choose中的value为option中的value，所以option中value不可重复！！！)
form.on('select(selectIntegralItemScore)', function(choose){
    var id = choose.value;
    var score=0;
    $("#ItemInfo option").each(function () {
        if ($(this).val() == id){
            score = $(this).attr("score");
        }
    })
    $("#ItemIntegral").val(score);
});
