		function validate()
		{
			var msg = "";
			msg += validateUserName()+validatePassword();
			
			if (msg.length>0)
			{
				alert(msg);
				return false;
			}	
			else
			{
				alert("Login success");
				window.location ="AdminHome.html";
				return true;
			}
		}
	
	
		function validateUserName()  
		{  
			var userName = document.getElementById("userName").value;
			// checks if name is empty or not
			if ( userName == "") 
			{  
				return "Please enter User Name\n";
			}
			else if(userName.match("kajal"))
				return "";
			else
				return "Incorrect username\n";
		} 


		function validatePassword()  
		{  
			var passwd = document.getElementById("passwd").value;
			// checks if name is empty or not
			if ( passwd == "") 
			{  
				return "Please enter Password\n";
			}
			else if ( passwd.length<5) 
			{  
				return "Please enter Password of minimum 5 characters\n";
			}
			else if(passwd.match("kajal5"))
				return "";
			else
				return "Incorrect Password\n";
		} 