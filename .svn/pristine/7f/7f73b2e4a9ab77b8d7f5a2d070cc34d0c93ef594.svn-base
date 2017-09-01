//登录
function checkLog(form) {

      if(form.SStudentID.value=='') {
            alert("请输入用户帐号!");
            form.SStudentID.focus();
            return false;
           }
       if(form.SPwd.value==''){
            alert("请输入登录密码!");
            form.SPwd.focus();
            return false;
         }
         return true;
    }
   function del(){
   
     if(confirm("确定要退出吗？"))
       location="";
       return;
  }
 function showlog(targetid){
	   
	   var target=document.getElementById(targetid);
	   
	   if (target.style.display=="block"){
		   
	       target.style.display="none";
	               
	    } else {
	          
	       target.style.display="block";
	                
	      }
 }
 
 //注册
 function checkReg(form) {
	
     if(form.SStudentID1.value=='') {
           alert("请输入帐号!");
           form.SStudentID1.focus();
           return false;
          }
      if(form.SPwd1.value==''){
           alert("请输入密码!");
           form.SPwd1.focus();
           return false;
        } 
      
     /* if(form.SPwd1.value.length>20|| form.SPwd1.value.length<6){
          alert("密码长度必须在6~20位之间");
          form.SPwd1.value="";
          form.SPwd1.focus();
          return false;
         }
       return true; 
     */
       if(form.SPwd1.value!=form.SPwdConfirm1.value){

          alert("两次密码不一样,请重新输入");
          form.SPwdConfirm1.value="";
          form.SPwdConfirm1.focus();
             return false; 
         }
         return true;
         
         
        
}
   function checkPass(){
	 var ele2=document.getElementById("SPwd1");
	 if(ele2.value.length>20|| ele2.value.length<6){
         alert("密码长度必须在6~20位之间");
         ele2.value="";
         ele2.focus();
         return false;
        }
      return true; 
 }

 
 function showreg(targetid){
  
     var target=document.getElementById(targetid);
    

           if (target.style.display=="block"){
               target.style.display="none";
              
            } else {
               target.style.display="block";
        
               
           }
 }


function changeColor(){

   

  var mychar = document.getElementById("txt");

  mychar.style.color="black";

  mychar.style.backgroundColor="lightgray";

}
function changeColor1(){

	   

	  var mychar1 = document.getElementById("txt1");

	  mychar1.style.color="black";

	  mychar1.style.backgroundColor="lightgray";

	}

   
 