/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(init);

function init(){
	
	$("#fillColor").click(function(){
	    $("tr:even").css("background-color", "#FFA2C2");
	    $("tr:odd").css("background-color", "#9FC9EA");
	});
	
}