$(function(){
		var select=$(".select");
		$(".select-all").click(function(){
				if(this.checked){
					for(var i=0;i<select.length;i++){
						select[i].checked=true;		
					}
				}
				else{
					for(var i=0;i<select.length;i++){
						select[i].checked=false;		
					}
				}
		});
		
//			for(var i=0;i<count.length;i++){
//					alert(count[i]);
//			}
			
			$("div.reduce-cart").click(function(){
				var reduceid=$(this).attr("dataR");
				var countR=$("#"+reduceid).attr("value");
				if(countR==1){
					return;
				}
				else{
					$("#"+reduceid).attr("value",--countR);
				}
				var countCid=$(this).attr("dataC");
				var	Count=countR; 
				var contTid=$(this).attr("dataT");
				var Price = $("#"+countCid).attr("value");
				$("#"+contTid).attr("value",Price*Count);
				var totalFinal=0;
				$("input.total-s").each(function(){
					var t=$(this);
					totalFinal=totalFinal+1*t.val();
				});
				$("#totalFinal").val(totalFinal);
			});
			$("div.add-cart").click(function(){
				var addid=$(this).attr("dataP");
				var storeid=$(this).attr("dataS");
				var countP=$("#"+addid).attr("value");
				var store=$("#"+storeid).attr("value");
				if(countP==store){
					return;
				}
				else{
					$("#"+addid).attr("value",++countP);
				}
				var countCid=$(this).attr("dataC");
				var	Count=countP; 
				var contTid=$(this).attr("dataT");
				var Price = $("#"+countCid).attr("value");
				$("#"+contTid).attr("value",Price*Count);
				var totalFinal=0;
				$("input.total-s").each(function(){
					var t=$(this);
					totalFinal=totalFinal+1*t.val();
				});
				$("#totalFinal").val(totalFinal);
			});
			$("input.count-cart").change(function(){
				var countCid=$(this).attr("dataC");
				var	Count=$(this).attr("value"); 
				var contTid=$(this).attr("dataT");
				var Price = $("#"+countCid).attr("value");
				var totalFinal=0;
				$("#"+contTid).attr("value",Price*Count);				
				$("input.total-s").each(function(){
					var t=$(this);
					totalFinal=totalFinal+1*t.val();
				});
				$("#totalFinal").val(totalFinal);
			});
			$("#buy-cart").click(function(){
				$("#form1").attr("action","/SuperMarket/Buy.jsp");
				$("#form1").submit();
			});
			$("#delete").click(function(){
				$("#form1").attr("action","/SuperMarket/CartInfoDelete");
				$("#form1").submit();	
			});
//			$("#cal").click(function(){
//				var totalFinal=0;
//				$("input.total-s").each(function(){
//					var t=$(this);
//					totalFinal=totalFinal+1*t.val();
//				});
//				
//				$("#totalFinal").text(totalFinal);
//			});
			
//			$("div.count-cart").focus(function(){
//				alert($(this).attr("id"));
//			})
			
			
});