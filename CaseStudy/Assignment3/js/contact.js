		function validate()
		{
			var msg = "";
			msg += validateName()+validateEmail()+validatePhone();
			
			if (msg.length>0)
			{
				alert(msg);
				return false;
			}	
			else
			{
				alert("Submitted successfully");
				window.location ="Home.html";
				return true;
			}
		}
	
	
		function validateName()  
		{  
			var txt = document.getElementById("name").value;
			var letters = /^[A-Za-z]+$/; 
			// checks if name is empty or not
			if ( txt == "")  /* txt == "" || txt.length == 0 || txt == null */
			{  
				return "Please enter Name\n";
			}
			// checks that name should contain only alphabets 
			else if( !txt.match(letters) )  
			{  
				return "Only alphabets are allowed in name\n";
			}
			else 
				return "";
		} 

		function validateEmail()   
		{  
			var txt = document.getElementById("email").value;
			// checks if email is valid or not
			if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(txt))  
			{  
				return "";  
			}
			else
			{
				return "You have entered an invalid email address!\n" ;   
			} 
		}
		
		
		function validatePhone()  
		{  
			var phone = document.getElementById("phone").value;
			var numbers = /^[0-9]+$/; 
			// checks if phone is empty or not
			if ( phone == "")
			{  
				return "Please enter phone number\n";			
			}
			//checks that phone number should have only numbers
			else if( !phone.match(numbers) )
			{  
				return "Only numbers are allowed in phone\n";
			}
			else 
				return "";
		}