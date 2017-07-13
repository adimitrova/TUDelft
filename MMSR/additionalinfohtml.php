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
	<link rel="stylesheet" href="additionalinfocss.css">
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
					<li> <a href="login.html?action=logout" target="_parent"> LOG OUT </a> </li>
				</ul>
			</nav>
			<div class="clear"></div>
			<hr>
		</header>
		
		<div class ="content">
			
			<!-- <div class="banner">
				<img src="wall.jpg" alt="logo" width="960">
			</div> -->
		
			<div class="mainpage">
			<p> First, please fill in the details below </p><br>
				<div class="form">
					<form class="form" action="additionalinfophp.php" method="POST" target="_self">
					<hr>
					<p> Additional Information </p>
					<input type="text" name="edu" placeholder="Еducation Field (Medicine / IT / Finance etc.)" required><br>
					<select name="profstatus" required> 
					  <option name="---" value="---">PROFESSIONAL STATUS</option>
					  <option name="bsc" value="bsc">Bachelor Student</option>
					  <option name="msc" value="msc">Master Student</option>
					  <option name="phd" value="phd">Graduate Student / Postdoc</option>
					  <option name="intern" value="intern">Intern</option>
					  <option name="junior" value="junior">Industry (Junior Level)</option>
					  <option name="senior" value="senior">Industry (Senior Level)</option>
					  <option name="management" value="management">Management</option>
					  <option name="unemployed" value="unemployed">Unemployed</option>
					  <option name="freelancer" value="freelancer">Freelance Software Developer</option>
					  <option name="ownbusiness" value="ownbusiness">Own Business</option>
					  <option name="other" value="other">Other</option>
					</select>
					<input type="text" name="yearsexperience" placeholder="Years of work experience" required><br>
					<input type="submit" name="submit" id="submit" value="Send">
					</form>
				</div>
			</div>
		</div>
		
		
	</div>

</body>

</html>
<?php } ?>