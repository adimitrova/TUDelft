<?php
session_start();
	if(!isset($_SESSION['userid'])){
		// if user is not logged in, notify them
		echo "You're not logged in or you entered a wrong username or password.";
	} else {
?>
<!doctype html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="refresh" content="10000"> 
	<title>Web app</title>
	<link rel="stylesheet" href="mathproblem.css">
	<link href='https://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
	
	<!------------------------------------------
		Google Webfonts 
		Kaushan Script - typewrite
		Raleway 500 and 900 - for the BIG TITLES
		Pompiere - narrow fornt for descriptions
		------------------------------------------->
		<link href='https://fonts.googleapis.com/css?family=Kaushan+Script|Raleway:500,900|Pompiere' rel='stylesheet' type='text/css'>
</head>

<body>

	<div class="container">

		<header>
			<hr>
					
			<!-- <a href="index.html" target="_parent"> -->
			<nav class="top_nav">
				<ul>
					<li> <a href="index.html" target="_parent"> HOME </a> </li>
					<li> <a href="login.html" target="_parent"> LOGIN </a> </li>
					<li> <a href="reguser.html" target="_parent"> USER REGISTRATION </a> </li>
					<li> <a href="regcomp.html" target="_parent"> COMPANY REGISTRATION </a> </li>
					<li> <a href="login.html?action=logout" target="_parent"> LOG OUT </a> </li>
				</ul>
			</nav>
			<div class="clear"></div>
			<hr>
		</header> <!-- Header end -->
		
		<div class ="content">
			
			<!-- <div class="banner">
				<img src="wall.jpg" alt="logo" width="960">
			</div> -->
		
			<div class="mainpage"> 
				<p> Please answer the math problem =) </p><br>
				
				<!-- CHANGE TARGET TO openLink or openLink2 for the second form -->
				<div id="mathcaptcha"> <!--- Math problem begin --->
					<form class="question" action="captchaQuestion.php" method="GET" target="openLink">
						<button type="submit" name="mathprob" id="submit">Let's do this!</button><br><br>
						<center><iframe src="emptyFrame.html" name="openLink" height="50" width="100"></iframe></center>
					</form><br><br>
					
					<form class="formanswer" action="captchaAnswer.php" method="GET" target="openLink2">
						<p>Answer:</p> <input type="text" name="answer" /> <br><br>
						<button type="submit" name="submitAnswer" id="submit">Submit</button><br><br>
						<center><iframe src="emptyFrame.html" name="openLink2" height="80" width="120"></iframe></center>
					</form>
				</div> <!--- Math problem end --->
			</div> <!--- main page problem end --->
		</div> <!-- Content end -->
	</div> <!-- container end -->

</body>

</html>
<?php } ?>