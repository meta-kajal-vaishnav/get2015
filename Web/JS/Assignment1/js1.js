		
		function validate()
		{
			var msg = "";
			msg += validateFname();
			msg += validateLname();
			msg += validatePassword();
			msg += validateReEnterPassword();
			msg += validateAge();
			if (msg.length>0)
			{
				alert(msg);
				return false;
			}	
			else
			{
				alert("User created successfully");
				return true;
			}
		}
	
	
		function validateFname()  
		{  
			var txt = document.getElementById("fName").value;
			var letters = /^[A-Za-z]+$/; 
			// checks if first name is empty or not
			if ( txt == "")  /* txt == "" || txt.length == 0 || txt == null */
			{  
				return "Please enter First Name\n";
			}
			// checks that firstname should contain only alphabets 
			else if( !txt.match(letters) )  
			{  
				return "Only alphabets are allowed in first name\n";
			}
			else 
				return "";
		} 

		
		function validateLname()  
		{  
			var txt = document.getElementById("lName").value;
			var letters = /^[A-Za-z]+$/;  
			// checks if last name is empty or not
			if ( txt == "") 
			{  
				return "Please enter Last Name\n";
			}
			// checks that last name should contain only alphabets
			else if( !txt.match(letters) )  
			{  
				return "Only alphabets are allowed in last name\n";
			}
			else 
				return "";
		}
		
		
		function validatePassword()  
		{  
			var passwd = document.getElementById("passwd").value;
			// checks if password is empty or not
			if ( passwd == "")
			{  
				return "Please enter password\n";			
			}
			//checks that password should have minimum 8 characters
			else if( passwd.length < 8 )
			{  
				return "Password should be of minimum 8 characters\n";
			}
			else 
				return "";
		}
		
		
		function validateReEnterPassword()  
		{  
			var passwd = document.getElementById("passwd").value;
			var reEnterPasswd = document.getElementById("reEnterPasswd").value;
			// checks if re enter password field is empty or not
			if ( reEnterPasswd == "")  
			{  
				return "Please enter password in re enter passwd field\n";
			}
			// checks if password matches re entered password
			else if( passwd != reEnterPasswd )
			{  
				return "Password doesnot match\n";
			}
			else 
				return "";
		}
		
		
		function validateAge()
		{
			var age = document.getElementById("age").value;
			var numbers = /^\d*\.?\d*$/; 
			// checks if age is empty or not
			if ( age == "")
			{  
				return "Please enter age\n";
			}
			// checks if age contains only numbers and dot
			else if(!age.match(numbers))  
			{  
				return "Please enter numeric value in age\n";
			}
			else 
				return "";
		}

		
		function fillCity()
		{
			var stateID = document.getElementById("State");
			var stateValue = stateID.options[stateID.selectedIndex].value;
			var city = document.getElementById("City");
			var noStateSelected = ["Enter state first"];
			var Rajasthan = ["Jaipur","Ajmer","Kota","Jodhpur"];  
			var Maharashtra = ["Mumbai","Pune","Nagpur","Thane"];  
			var UP = ["Kanpur","Meerut","Lucknow","Varanasi"];  
			var MP = ["Indor","Mandsor","Bhopal"];  
			document.myform.City.options.length = 0;
			var stateArr = new Array();
			switch(stateValue)
			{
				case '-1' : stateArr = noStateSelected;
							break;
				case '1' : stateArr = Rajasthan;
						   break;
				case '2' : stateArr = MP;
						   break;
				case '3' : stateArr = UP;
						   break;
				case '4' : stateArr = Maharashtra;
						   break;
			}
		
			for( j = 0; j < stateArr.length; j++ )
			{
				var newOption = document.createElement("option");
				newOption.text = stateArr[j];
				newOption.value = j;
				city.add(newOption);
			}
		}
				
		function enableButton()
		{
			var submitButton = document.getElementById("submitButton");
			var acceptCondition = document.getElementById("acceptCondition");

			if (acceptCondition.checked == true)
			{
				submitButton.disabled = false;
			}
			else
			{
				submitButton.disabled = true;
			}
		}
		
