function addSite(){
    var direName = $("#direName").val();
    var direId = $("#direId").val();
    var siteTitle = $("#siteTitle").val();
    var siteUrl = $("#siteUrl").val();
    alert("direName : "+direName) ;
    $.post("/addSite",
        {
            "direName":direName,
            "direId":direId,
            "siteTitle":siteTitle,
            "siteUrl":siteUrl
        },
        function(data,status){
            window.location.reload();
//            alert("返回数据" + data + "\n״状态" + status);
        });
}