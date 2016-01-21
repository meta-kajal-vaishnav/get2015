//function addEmployee(){
//	
//	if(empCheck()){
//	    $.ajax({
//		    type: "POST",
//		    url: "/MetaHrm/addEmployee.html",
//		    data: $('#empForm').serialize(),
//		    //dataType: 'json',
//		    success: function(response){
//		    	//var text = "";
////		    	$.each(response, function(){
////		    		text += "<b>Employee Name : </b>"+this.empName
////		    		+"<br/><b>Email : </b>"+this.email+"<br/><br/>";
////		    		text = "success";
////		    	}); 
//		    	alert(response);
//		    	console.log(response);
//		    	//$('#empList').html(text);
//		    	$('#empName').val("");
//		    	$('#email').val("");
//		    },
//		    error: function(e){
//		    	alert('Error: ');
//		    }
//	    });
//	}
//}
//
//function empCheck() {
//	var result = false;
//	if ($("#empName").val().trim() == "") {
//		$("#addEmpError").val("* Enter emp name");
//	} 
//	else if ($("#email").val().trim() == "") {
//		$("#addEmpError").val("* Enter email");
//	}
//	else {
//		result = true;
//	}
//	return result;
//}