<?php
//$conn=mysqli_connect("localhost","root");
//$db_select=mysqli_select_db($conn,"worldofi_mmsr");
session_start();

if(isset($_POST['submit'])){
	require 'config.php';
	$username = $_POST['username'];
	$password = $_POST['password'];
	$userquery = mysqli_query($conn,'SELECT userid FROM usernames WHERE username="'.$username.'" and password="'.$password.'"');
	$fetchUserID = mysqli_fetch_row($userquery);
	$userID =  mysqli_real_escape_string($conn,$fetchUserID[0]); 

	$rowcount = mysqli_num_rows($userquery);
	
	// login
	if ($rowcount == 1){
		$_SESSION['userid'] = $userID;
		header('Location: checkForAddData.php'); //add the html page where to bring user after login. It should be w/ php extension_loaded
		// startsession.php
	} else {
		echo "Please log in or register";
	}
	//logout
	if (isset($_GET['logout'])){
		session_unregister('username');
	}
}
?>