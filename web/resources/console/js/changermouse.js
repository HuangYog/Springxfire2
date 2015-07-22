// JavaScript Document
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
	  