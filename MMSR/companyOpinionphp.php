<?php
include 'compFunctions.php';
session_start();

	if(!isset($_SESSION['userid'])){
		echo "You're not logged in";
	} else {
		$currUser = $_SESSION['userid']; //opuserid
		knowOrNot();
	}
?>