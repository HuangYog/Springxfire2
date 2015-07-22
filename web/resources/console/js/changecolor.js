var Table = {};

//变量定义
Table.bgcolorSelected = "#c5dfe9"; //行选中背景色
Table.bgcolorMouseover = "#e4f0f5"; //行经过背景色
Table.mouseOutBGColor = "#ffffff"; //鼠标移除背景色
Table.selectID = "";
Table.actor = "";


//select one row
Table.row = function(i, obj){
    if (this.actor != "") {
        this.actor.style.backgroundColor = this.mouseOutBGColor;
        this.actor.selectFlag = "false";
    }
    obj.style.backgroundColor = this.bgcolorSelected;
    obj.selectFlag = "true";
    this.actor = obj;
    //document.getElementsByName("selectButton")[i].checked = true;
    //this.selectID = document.getElementsByName("selectButton")[i].value;
};


Table.out = function(objTR){
    if (objTR.selectFlag != "true") {
        objTR.style.backgroundColor = this.mouseOutBGColor;
    }
};

Table.over = function(objTR){
    if (objTR.selectFlag != "true") {
        objTR.style.backgroundColor = this.bgcolorMouseover;
    }
};
