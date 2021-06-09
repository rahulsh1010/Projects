var Username=document.getElementById("login")
var password=document.getElementById("Password")
var form=document.getElementById("myform")

form.addEventListener('submit', (e) =>{
	e.preventDefault();
	checkInputs();
});

function checkInputs(){
	//get values 
	const Username=document.getElementById("login");
var password=document.getElementById("Password");
var form=document.getElementById("myform");
	const usernameValue=Username.value.trim();
	const passwordValue=password.value.trim();
	if(usernameValue=="" || usernameValue==null){
		alert('Enter Username');
		return false;
	}
	if(passwordValue=="" || passwordValue==null){
		alert('Enter Password');
		return false;
	}
	
}