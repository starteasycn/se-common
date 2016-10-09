<script>
    function buildRules() {
        var parentId = $('#parentId').val();
        var status = $('#status option:selected').val();;
        var name = $('#name').val();
        var rules = [];
        if (parentId != ''&&parentId!=null&&parentId!=undefined&&parentId!="请选择") {
            var rule = {
                'field': 'parentId',
                'op': 'eq',
                'data': parentId
            }
            rules.push(rule);
        }
        if (status != ''&&status!=null&&status!=undefined) {
            var rule = {
                'field': 'status',
                'op': 'lk',
                'data':status
            }
            rules.push(rule);
        }
        if (name != ''&&name!=null&&name!=undefined) {
            var rule = {
                'field': 'name',
                'op': 'lk',
                'data': name
            }

            rules.push(rule);
        }
        return rules;
    }


    $("#search").click(function () {
        searchLoad(1);

    });

    var getOptionParents = function(param, domId){
        $.ajax({
            url:"/admin/ucm/resourceParents",
            type:'get',
            success:function(res){
                var data = res.bizData;
                $("#"+domId + " option:gt(1)").remove();
                for(var i = 0,len = data.length;i < len;i++){
                    (function(i){
                        if(!i){
                            $("#"+domId).append("<option value=\'" + data[i].id + "\' selected>" + data[i].name + "</option>");
                        }
                        else{
                            $("#"+domId).append("<option value=\'" + data[i].id + "\'>" + data[i].name + "</option>");
                        }
                        console.log(data[i]);
                    })(i)
                }
                $("#"+domId).trigger("change");
            },
            error : function(){
                console.log("error",res);
            }
        })
    };
    getOptionParents("0","parentId");
</script>