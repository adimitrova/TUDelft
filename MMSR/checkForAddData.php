<?php
session_start();

// check if user is logged in
	if(!isset($_SESSION['userid'])){
			// if user is not logged in, notify them
			echo "You're not logged in or you entered a wrong username or password.";		
	} else {
		require 'config.php';
		// check if there's already a record with that id
		$checkAddInfoTableForRec = mysqli_query($conn,'SELECT addinfouserid FROM adduserinfo, usernames WHERE usernames.userid = adduserinfo.addinfouserid AND usernames.userid = "'.$_SESSION['userid'].'"');
		// inserting into additional info table
		$rowcount = mysqli_num_rows($checkAddInfoTableForRec);
		
		$getUserTypeQuery = mysqli_query($conn,'SELECT usertype FROM usernames WHERE usernames.userid = "'.$_SESSION['userid'].'"');
		$FetchUserTypeResult = mysqli_fetch_array($getUserTypeQuery);
		$userType =  mysqli_real_escape_string($conn,$FetchUserTypeResult[0]); 
		// inserting into additional info table
		
		//if yes: skip and bring to mathproblem directly.
		//if not: insert in table and bring to mathproblem
		
		// if there's no record, bring user to additional info page
		if ($rowcount == 0){
			// check if the user is type "user" and send them to addidional page. If it's "admin" or "company" we skip the add info page
			if($userType == 'user' || $userType == 'admin'){
				// echo "Type user or admin w/o info => Bringing to additional info page";
				header('Location: additionalinfohtml.php'); 
			}
			else{
				// meaning if everything else, i.e. type = company
				// so if it is a company, we skip the additional page options, cause we've got the most important info for the companies from the reg form
				header('Location: matchApphtml.php');
				//echo "Type Company => Bringing to mathproblem";
			}
		} else {
			// if there is record, send user to mathproblem page
			header('Location: matchApphtml.php');
			//echo "Found a record => Bringing to mathproblem";
		}
	}
?>