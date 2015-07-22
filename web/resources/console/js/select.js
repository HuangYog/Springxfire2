// JavaScript Document
/* +----------------------------------------------------------------------
   | FileName:common.fsnip.js
   +----------------------------------------------------------------------
   | Author:fsnip design teams
   +----------------------------------------------------------------------
   | E-mail:designteam@fsnip.com　
   +----------------------------------------------------------------------
   | Web:designteam.fsnip.com　
   +----------------------------------------------------------------------
   | Date:(据说这是一个很古老的传说了）
   +----------------------------------------------------------------------
   | UpDate:2014-09-16
   +----------------------------------------------------------------------
*/

$(document).ready(function(){	
	
// ********************************* 选择框开始 (2014-04-24) ******************************* /
	var selectArea		= $('.dropdown-select'),
		selectShow		= $('.select-show'),
		selectText		= $('.dropdown-select a'),
		selectAreaHover	= 'dropdown-select-hover',
		selectCurrent	= 'select-current',
		showDd			= 'dd';	

	// 鼠标移上去样式
	selectArea.hover(function(){
		$(this).addClass(selectAreaHover);
	},function(){
		if($(this).find(showDd).is(':visible')){
			$(this).addClass(selectAreaHover);
		}else{
			$(this).removeClass(selectAreaHover);
		}
	});
	
	// 点击显示	
	selectShow.on('click',this,function(e){
		e.stopPropagation();
		//$(this).parent().addClass(selectAreaHover);
		$(this).parent().siblings().removeClass(selectAreaHover);
		$(this).parents().siblings().find(selectArea).removeClass(selectAreaHover);
				
		if($(this).siblings(showDd).is(':hidden')){
			$(this).siblings(showDd).show();
		}else{
			$(this).siblings(showDd).hide();
		}		
		if($(this).parents().siblings().find(showDd).is(':visible')){
			$(this).parents().siblings().find(showDd).hide();
		}
	});
	
	// 取出选择文本
	selectText.on('click',this,function(){
		var text	= $(this).text();
		$(this).addClass(selectCurrent).siblings().removeClass(selectCurrent);
		$(this).parent().parent().find(selectShow).text(text);
		$(this).parent().hide();
	});
	
	//弹出之后取消事件
	$(document).click(function(){
		$(".dropdown-select dd").hide();
		//$(".AreaSelection").hide();
		selectArea.removeClass(selectAreaHover);
	});
	
});
// 鼠标移上去切
 $(function () {
	 // 鼠标移上去切换
	$('[data-css="true"]').find('li').on('mouseenter',function(){
		var linkageDom	= $(this).parent().attr('data-css-linkage');
		var index = $(this).index();
		var div = $(this).parent().parent(); //父标签
	
		
		$(this).addClass('current').siblings().removeClass('current');
		$(div).next('.' + linkageDom).children('div:eq(' + index + ')').show().siblings().hide();
	});
	
	// 鼠标点击切换
	$('[data-click-css="true"]').find('li').on('click', function () {
		var linkageDom	= $(this).parent().attr('data-css-linkage');
		var index = $(this).index();
		var div = $(this).parent(); //父标签

		$(this).addClass('current').siblings().removeClass('current');
		$(div).next('.' + linkageDom).children('div:eq(' + index + ')').show().siblings().hide();
	});
	  });
	  