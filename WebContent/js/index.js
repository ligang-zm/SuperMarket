$(function(){
	var choose=$("div.choose");
	var search=$("input.search-i");
	var myM=$("div.myMarket");
	
	var inter=false;
	 choose.mouseover(function(e){
		var tabChoose=$(this);
		var targetTab =$(".tab-"+tabChoose.attr("data-tab"));
		 
		if(tabChoose.hasClass("bac-change"))
			{
			return;
			}
		$(".bac-change").removeClass("bac-change");
		$(".display").removeClass("display");
		tabChoose.addClass("bac-change");
		targetTab.addClass("display");
	});
	 myM.mouseover(function(){
		 $(this).addClass("bac-white");
		 $(this).removeClass("bac-normal");
		 $("div.tool").addClass("display");
		 $("div.myMarket>div.trangle").addClass("border_color_white");
	 });
	 myM.mouseleave(function(){			
		 $(this).removeClass("bac-white");
		 $(this).addClass("bac-normal");
		 $("div.tool").removeClass("display");
		 $("div.myMarket>div.trangle").removeClass("border_color_white");
 });
	 $("div.tool").mouseover(function(){
			$(this).addClass("display");
			myM.addClass("bac-white");
			myM.removeClass("bac-normal");
			$("div.myMarket>div.trangle").addClass("border_color_white");
		});
	 $("div.tool").mouseout(function(){
			$(this).removeClass("display");
			myM.removeClass("bac-white");
			myM.addClass("bac-normal");
			$("div.myMarket>div.trangle").removeClass("border_color_white");
		});
	 
	 $("div.tool").mouseover(function(){
			$(this).addClass("display");
			myM.addClass("bac-white");
			myM.removeClass("bac-normal");
			$("div.cart>div.trangle").addClass("border_color_white");
		});
	 $("div.tool").mouseout(function(){
			$(this).removeClass("display");
			myM.removeClass("bac-white");
			myM.addClass("bac-normal");
			$("div.cart>div.trangle").removeClass("border_color_white");
		});
	
	
		
	
	 
});