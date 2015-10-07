		// makes table of min and max according to value of column entered by user
		function makeTable()  
		{  
			var rowCount = document.getElementById("rowCount").value;
			var numbers = /^[0-9]+$/; 
			if ( rowCount == "")  
				alert("Please enter count");
			else if (!rowCount.match(numbers))  
				alert("Please enter numeric value"); 	
			else
				document.getElementById("box").innerHTML = showData(rowCount);
		} 
		
		
		// makes table according to row count and return it
		function showData(rowCount)
		{
			var str ;
			str = "<form><table width='300' cellspacing='0' cellpadding='5' align='left' id='table1'><tr><th>Name</th><th>Min</th><th>Max</th></tr>";
			for (i=0; i<rowCount; i++)
			{	
				str += "<tr><td><input type='text' class='Name' placeholder='Enter Name'/></td><td><input type='text' class='min' placeholder='Enter min value'/></td><td><input type='text' class='max' placeholder='Enter max value'/></td></tr>";
			}
			str += "</table><br/><br/><input id='submitForm' type='button' value='OK' onclick='rangeRepresentation();'/><br/><br/><br/></form><div id='box1' style='width:500px;height:500px;'></div><br/><br/>";
			return str;
		}

		
		// validates name
		function validateName(inputName)  
		{  
			var letters = /^[A-Za-z]+$/; 
			// checks if name is empty or not
			if ( inputName.value == "")  /* txt == "" || txt.length == 0 || txt == null */
				return "Please enter Name\n"; 
			// checks that name should contain only alphabets 
			else if( !inputName.value.match(letters) )  
				return "Only alphabets are allowed in name\n";
			else
				return "";
		} 
		
		
		// validates min
		function validateMin(inputMin)
		{
			var numbers = /^[+-]?[0-9]+$/; 
			// checks if min is empty or not
			if ( inputMin.value == "" )
				return "Please enter min value\n"; 
			// checks if min contains only numbers
			else if ( !inputMin.value.match(numbers) )  
				return "Please enter numeric value in min field\n"; 
			else if ( inputMin.value<=0 || inputMin.value>=10 )
				return "Please enter min value between 0 and 10\n";  
			else
				return "";
		}
		
		
		// validates max
		function validateMax(inputMax,inputMin)
		{
			var numbers = /^[+-]?[0-9]+$/; 
			// checks if max is empty or not
			if ( inputMax.value == "" )
				return "Please enter max value\n"; 
			// checks if max contains only numbers
			else if ( !inputMax.value.match(numbers) )  
				return "Please enter numeric value in max field\n"; 
			else if ( inputMax.value<=0 || inputMax.value>=10 )
				return "Please enter max value between 0 and 10\n";
			else if ( inputMax.value < inputMin.value )
				return "Max value should be greater than min value\n";
			else
				return "";
		}
		
		
		// // validates name, min, max
		function validate(rowCount,inputName,inputMin,inputMax)
		{
			var msg = "";
			for ( i = 0; i < rowCount; i++ ) 
			{
				msg += validateName(inputName[i]) + validateMin(inputMin[i]) + validateMax(inputMax[i],inputMin[i]);
				// if any validation fails for any row
				if(msg.length>0)
				{
					alert(msg);
					return false;
				}
				else
					continue;
			}
			return true;
		}
		
		
		// creates range table
		function rangeRepresentation()
		{
			var rowCount = document.getElementById("rowCount").value;
			var inputName = document.getElementsByClassName("Name");
			var inputMin = document.getElementsByClassName("min");
			var inputMax = document.getElementsByClassName("max");
			if(validate(rowCount,inputName,inputMin,inputMax))
			{
				document.getElementById("box1").innerHTML = makeRangeTable(rowCount,inputName,inputMin,inputMax);
				return true;
			}
			else
				return false;
		}
		

		// creates range table and returns it
		function makeRangeTable(rowCount,inputName,inputMin,inputMax)
		{
			var str ;
			str = "<table width='300' cellspacing='0' cellpadding='5' align='left' class='rangeTable'>";
			for ( i=0; i<rowCount; i++ )
			{	
				str += "<tr><td id='nameCol'>"+inputName[i].value+"</td>";
				// draws range boxes
				for ( j=1; j<=11; j++ )
				{
					if( j>=inputMin[i].value && j<=inputMax[i].value )
						str += "<td style='background-color:red;'></td>";	
					else 
						str += "<td></td>";
				}
				str += "</tr>";
			}
			str += "</table><br/><br/>";
			return str;
		}