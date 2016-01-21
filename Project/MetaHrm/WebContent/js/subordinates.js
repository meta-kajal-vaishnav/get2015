function addEmployee(){
	alert("dd");
	if(true){
		alert("hellllo");
	    $.ajax({
	    	
		    type: "POST",
		    url: "/MetaHrm/addEmployee.html",
		    data: $('#empForm').serialize(),
		    success: function(response){
		    	alert("gggg");
		    	var text = "";
		    	$.each(response, function(){
		    		text += "<b>Employee Name : </b>"+this.employeeName
		    		+"<br/><b>User Name : </b>"+this.username+"<br/><br/>";
		    	}); 
		    	alert(response);
		    	console.log(response);
		    	$('#empList11').html(text);
		    	$('#employeeName').val("");
		    	$('#userName').val("");
		    },
		    error: function(e){
		    	alert('Error: ');
		    }
	    });
	}
	   
}

function empCheck() {
	alert("A");
	var result = false;
	if ($("#empName").val().trim() == "") {
		$("#addEmpError").val("* Enter employee name");
	} 
	else if ($("#userName").val().trim() == "") {
		$("#addEmpError").val("* Enter user name");
	}
	else {
		result = true;
	}
	alert("B");
	return result;
}