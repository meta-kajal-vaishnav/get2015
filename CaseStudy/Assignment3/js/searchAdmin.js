		function fillCategory()
		{
			var cName = document.getElementsByClassName("categoryName");
			for(i=0;i<cName.length;i++)
			{
				if(cName[i].checked)
					var categoryValue = cName[i].value;
			}	
			var category1 = document.getElementById("category1");
			var category2 = document.getElementById("category2");
			category1.options.length = 0;
			category2.options.length = 0;
			
			var noCategorySelected = ["Select category first"];
			var model = ["- Select model -","Model1","Model2","Model3","Model4"];  
			var make = ["- Select make -","Make1","Make2","Make3","Make4"];
			var price = ["- Select price -","700000","800000","900000","600000"];
					
			var categoryArr1 = new Array();
			var categoryArr2 = new Array();
			
			switch(categoryValue)
			{
				case '-1' : categoryArr1 = noCategorySelected;
							categoryArr2 = null;
							break;
				case '1' : categoryArr1 = model;
						   categoryArr2 = make;
						   break;
				case '2' : categoryArr1 = price;
						   categoryArr2 = null;
						   break;
			}
		
			for( j = 0; j < categoryArr1.length; j++ )
			{
				var newOption = document.createElement("option");
				newOption.text = categoryArr1[j];
				newOption.value = j;
				category1.add(newOption);
			}
			
			if(categoryArr2!=null)
			{
				category2.style.visibility = 'visible';
				for( j = 0; j < categoryArr1.length; j++ )
				{
					var newOption = document.createElement("option");
					newOption.text = categoryArr2[j];
					newOption.value = j;
					category2.add(newOption);
				}
			}
			else
				category2.style.visibility = 'hidden';
		}

		
		var i = 0;
		var path = new Array();
		 
		// LIST OF IMAGES
		path[0] = "images/car3.jpg";
		path[1] = "images/car4.jpg";
		path[2] = "images/car5.jpg";

		function swapImage()
		{
		   document.slide.src = path[i];
		   if(i < path.length - 1) i++; else i = 0;
		   setTimeout("swapImage()",3000);
		}
		window.onload=swapImage;
		
		
		function validateCategory()
		{
			var category1 = document.getElementById("category1");
			var btn = document.getElementById("searchBtn");
			if(category1.value=="- Select category -") {
				alert('select one answer');
				return false;
			}
			else
			{
				btn.disabled = false;
				btn.style.backgroundColor= '#5B6432';
				return true;
			}
		}