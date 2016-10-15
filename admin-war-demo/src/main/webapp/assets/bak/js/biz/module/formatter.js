    function formatExpertState(cellvalue, options, rowObject){
        if("10" == cellvalue){
            return "正常";
        } else if("20" == cellvalue){
            return "停用";
        } else { //3
            return "冻结";
        }
    }

    function formatExpertType(cellvalue, options, rowObject){
        if("2000" == cellvalue){
            return "习悦";
        } else if("2001" == cellvalue){
            return "全通";
        }
    }