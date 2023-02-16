<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="https://abs.twimg.com/favicons/twitter.2.ico" type="image/x-icon">
    <script>
           document.title="Login";
    </script>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Red+Hat+Mono:wght@300;378&family=Source+Sans+Pro:ital@1&family=Zen+Antique&display=swap');
        *{
          font-family: 'Red Hat Mono', monospace;
        }
        :root{
          --First-color:#161624;
          --Second-color:#f2363c;
          --third-color:#573b8a;
        }
        body{
          margin: 0;
          padding: 10;
          display: flex;
          justify-content: right;
          align-items: center;
          min-height: 100vh;
          background-image: url(https://cdn.dribbble.com/users/2652449/screenshots/14764078/twitter.gif);
          background-size:cover ;
          background-position:right;
        }
        .main{
          width: 350px;
          background-color: #161624aa;
          height: 400px;
          overflow: hidden;
          border-radius: 10px;      //C:\Users\HP\IdeaProjects\helix\helix\src\main\webapp\WEB-INF\pages\signup.jsp
          box-shadow: 5px 20px 50px #000;
        }
        #chk{
          display: none;
        }
        .signup{
          position: relative;
          width:100%;
          height:100%;
        }
        .user-box {
          position: relative;
          width :60%;
          margin:0px auto;
        }
        button{
        	width: 60%;
        	height: 40px;
        	margin: 10px auto;
        	justify-content: center;
        	display: block;
        	color: #fff;
        	background: #00acee;
        	font-size: 1em;
        	font-weight: bold;
        	margin-top: 10px;
        	outline: none;
        	border: none;
        	border-radius: 99px;
        	transition: .2s ease-in;
        	cursor: pointer;
        }
        button:hover{
          background: #6d44b8;
        }
        .login{
          height: 470px;
          background: #eee;
          border-radius: 60% / 10%;
          transform: translateY(-180px);
          transition: .8s ease-in-out;
        }
        #chk:checked ~ .login{
          transform: translateY(-530px);
        }
        #chk:checked ~ .login label{
          transform: scale(1);
        }
        #chk:checked ~ .signup .sig{
          transform: scale(.6);
          margin-top:10px;
        }
        .user-box label {
          position: absolute;
          top:0px;
          left: 0px;
          font-size: 16px;
          color: #fff;
          pointer-events: none;
          transition: .5s;
        }
        .user-box input {
          padding: 10px 0;
          font-size: 16px;
          color: #fff;
          margin-bottom: 30px;
          border: none;
          border-bottom: 1px solid #fff;
          outline: none;
          background: transparent;
        }
        .user-box input:focus ~ label,
        .user-box input:valid ~ label {
          top: -20px;
          left: 0;
          color: #f2363c;
          font-size: 12px;
          font-weight:bold;
        }
        label[for="chk"] {
        	font-size: 2.3em;
        	justify-content: center;
        	display: flex;
        	font-weight: bold;
        	cursor: pointer;
        	transition: .5s ease-in-out;
        }
        .sig{
          color:#fff;
        	margin: 40px;
        }
        .log{
        	margin: 80px;
        }
        .login label , .login input{
          color:#573b8a;
        }
        .login input{
          border-color:#573b8a;
        }
    </style>
</head>
<body>


	<div class="main">
		<input type="checkbox" id="chk">

			<div class="signup">
				<form>
					<label for="chk" class="sig">Login</label>


    <div class="user-box">
      <input id="signup-email" type="text" title="Enter email" required>
      <label>Email</label>
    </div>
    <div class="user-box">
      <input  id="signup-password" type="password" title="Enter password" required>
      <input type="checkbox" onclick="myFunction()">Show Password
      <label>Password</label>
    </div>
        <p style="color:white" id="signup-error" ></p>
					<button type = "button" id="btn-signup">Login </button>
				</form>
			</div>


    <script>
        function myFunction() {
          var x = document.getElementById("signup-password");
          if (x.type === "password") {
            x.type = "text";
          } else {
            x.type = "password";
          }
        }
    </script>
	<script>
	function validateSignupForm(){
	var email=$("#signup-email").val();
	var password=$("#signup-password").val();
	var error="";

	if(!email){
        error+="Email is Empty. ";
    	}
    if(!password){
        error+="Password is Empty. ";
       	}
    if(password.length <= 5){
            error+="Password length must be greater than 5 char. ";
        }
    $("#signup-error").html( error );

    if(error.length > 0){
        return false;
    }

    return true;
	}
	$("#btn-signup").click(function(){
      var isValidForm = validateSignupForm();
      if(isValidForm){
      $("#signup-error").hide();

        var email=$("#signup-email").val();
      	var password=$("#signup-password").val();
        var user={
             "email":email,
             "password" : password
      };
        $.ajax({
        type:"POST",
        url:"/login/welcome",
        data:JSON.stringify(user),
        success:function(response){
        if(!!response){

            if(response.is_logined === true)
            {
                location.href = "/user/welcome";
            }
            else
            {
            var password=$("#signup-password").val("");
                $("#signup-error").html( response.message );
                $("#signup-error").show();
            }
        }

        },
        contentType:'application/json'
        });

      }else{
      $("#signup-error").show();

      }
    });
	</script>
</body>
</html>