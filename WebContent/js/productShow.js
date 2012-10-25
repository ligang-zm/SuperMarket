$(function() {
		
		$("input.count").keyup(function(){
			this.value=this.value.replace(/^0/g,'');
			this.value=this.value.replace(/\D/g,'');									
		});
		$("input.count").change(function(){
			var store=$("#store").attr("value");
			if(1*$("input.count").attr("value")>1*store){				
				$("div.list").addClass("display");
			}
		});
		$("input.count").focus(function(){
			$(this).attr("value",1);
			$("div.list").removeClass("display");
			});		
		$("form").submit(function() {
			var store=$("#store").attr("value");
			if($("input.count").val()==""){
				alert("数量不能为空  !!!");
				return false;
			}
			if(1*$("input.count").attr("value")>1*store){				
				$("div.list").addClass("display");		
				return false;							
			}
			else{
				$("form").submit();
				window.location.href = "/SuperMarket/Cart";				 	
			}
			
		});
		$("input.btn-buy").click(function() {
			if($("input.count").attr("value")<store){
			$("form").submit();
			window.location.href = "/SuperMarket/Buy";
			}
			else{
				$("input.count").attr("value",'1');
				return false;
				}
		});
		$("div.reduce").click(function(){
			var countP=$("input.count").attr("value");
			if(countP==1){
				return;
			}
			else{
				$("input.count").attr("value",--countP);
			}
		});
		$("div.add").click(function(){
			var countP=$("input.count").attr("value");
			var store=$("#store").attr("value");
			if(countP==store){
				return;
			}
			else{
				$("input.count").attr("value",++countP);
			}
			
		});
		if($("#no-show-info").text()=='true'){
			$("div.cart-info").addClass("display");
			$("div.cart-info").fadeOut(5000);
			
		}
		
	});