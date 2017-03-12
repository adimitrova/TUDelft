<?php
session_start();

	if(!isset($_SESSION['userid'])){
		echo "You're not logged in";
	} else {
		require 'config.php';
		//saving the input data in variables
		$userquery = mysqli_query($conn,'SELECT userid FROM usernames WHERE userid="'.$_SESSION['userid'].'"');
		$fetchUserID = mysqli_fetch_row($userquery);
		$userID =  mysqli_real_escape_string($conn,$fetchUserID[0]); 

		$edu = $_POST['edu'];
		$profstatus = $_POST['profstatus'];
		$yearsexperience = $_POST['yearsexperience'];
		
		$addInfoInsert = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`adduserinfo` 
											VALUES ('','$userID','$edu','$profstatus','$yearsexperience')");
		if(!$addInfoInsert){
			die("Insert in AdditionalInfo UNSUCCESSFUL! Error:" .mysqli_error($conn));
		} else {
			//header('Location: mathproblemhtml.php');
			header('Location: matchApphtml.php');
		}	
	}

// if(isset($_SESSION['userid'])) checkes whether the user is logged in or not 
// which is written in the startsession.php file which creates the initial session

?>