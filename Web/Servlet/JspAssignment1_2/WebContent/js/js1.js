		
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
		