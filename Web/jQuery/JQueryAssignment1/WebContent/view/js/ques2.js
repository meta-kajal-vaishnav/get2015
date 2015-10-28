/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(init);

function init(){
	$("#btn1").click(function(){
	    $("#btn3").val("Hide");
	    $("#showOrHideSpan").show();
	});
	
	$("#btn2").click(function(){
	    $("#btn3").val("Show");
	    $("#showOrHideSpan").hide();
	});
	
	$("#btn3").click(function(){
	    if($("#showOrHideSpan").css("display")== "block")
	    {
	        $("#btn3").val("Show");
	        $("#showOrHideSpan").hide();
	    }
	    else if($("#showOrHideSpan").css("display")== "none")
	    {
	        $("#btn3").val("Hide");
	        $("#showOrHideSpan").show();
	    }
	});
}


