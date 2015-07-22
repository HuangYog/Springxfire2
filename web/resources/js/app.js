//清空表单
function clearForm(objE){
    $(objE).find(':input').each(  
        function(){  
            switch(this.type){  
                case 'passsword':  
                case 'select-multiple':  
                case 'select-one':  
                case 'text':  
                case 'textarea':  
                    $(this).val('');  
                    break;  
                case 'checkbox':  
                case 'radio':  
                    this.checked = false;  
            }  
        }     
    );  
}


function text_input_num(){
	var k=event.keyCode;
	if (k<=57 && k>=48){
		return true;
	}
	else{
		return false;
	}
}


function C(obj){
	console.log(obj);
}
