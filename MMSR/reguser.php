<?php
require 'config.php';

$fname = $_POST['fname'];
$lname = $_POST['lname'];
$phone = $_POST['phone'];
$email = $_POST['email'];
$age = $_POST['age'];
$gender = $_POST['genger'];
$username = $_POST['username'];
$password = $_POST['pwd'];
$passwordRepeat = $_POST['pwdRepeat'];

$date = date('Y-m-d H:i:s');

if ($password != $passwordRepeat){
	echo "Password mismatch";
} else {
	$insertIntoUsers = mysqli_query($conn, "INSERT INTO `worldofi_mmsr`.`users` 
		VALUES ('','$fname','$lname','$phone','$email','$age','$gender','$date')");
		
	// fetching the register id in order to insert it in the usernames table to connect tables
	$selectRegID = mysqli_query($conn,"SELECT personid FROM users WHERE email='$email'");   // ALL companies
	$fetchRegID = mysqli_fetch_array($selectRegID);
	$userRegId =  mysqli_real_escape_string($conn,$fetchRegID[0]);
	
	if(!$selectRegID){
		echo "error: ".mysqli_error($conn);
		exit();
	}
	
	$insertIntoUsernames = mysqli_query($conn, "INSERT INTO `worldofi_mmsr`.`usernames` 
		VALUES ('','user','$username','$password','$date','$userRegId')");
	
	if(!$insertIntoUsers){
		echo "error: ".mysqli_error($conn);
		exit();
	} else if(!$insertIntoUsernames){
		echo "error: ".mysqli_error($conn);
		exit();
	} else {
		echo "Thank you for registering. Please login with your username and password";
	}
}

?>