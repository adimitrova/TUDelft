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
	<link rel="stylesheet" href="advertisementcss.css">
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
				
			<center>
				<h1>Time to vote!</h1>
				<h4>Based on the advertisement you see and on your opinion, select the most appropriate term:</h4> <br>
				<h4>DO NOT CLICK ON THE GREEN BUTTON AFTER VOTING<br>If something goes terribly wrong, please navigate to <br> 
				<font color="red">http://worldofinspiration.net/mmsr/matchApphtml.php</font> or scroll down and submit an empty vote</h4> <br>
				
			<div id="mathcaptcha">
			
			<center>
			<!--- CHANGE TARGET OF THE FORM BACK TO "openLink" WHEN IT'S DONE --->
			<!--- <form class="question" action="matchApp_showCompInfo.php" method="GET" target="openLink"> --->
			<form class="question" action="generateVoteOptionsphp.php" method="GET" target="openLink">
				<button type="submit" name="mathprob" id="submit"> Got it </button><br><br>
			<iframe src="emptyFrame.html" name="openLink" height="270" width="510"></iframe>
			</form>
			
			</div> <!--- main page problem end --->
		</div> <!-- Content end -->
	</div> <!-- container end -->

</body>

</html>
<?php } ?>