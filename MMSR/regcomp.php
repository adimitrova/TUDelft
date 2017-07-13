<?php
require 'config.php';

$companyname = $_POST['companyname'];
$caddress = $_POST['address'];
$cfield = $_POST['field'];
$repfname = $_POST['fname']; //company representative
$replname = $_POST['lname'];
$repphone = $_POST['phone'];
$repemail = $_POST['email'];
$repusername = $_POST['username'];
$reppassword = $_POST['pwd'];

//$gender = $_POST['genger'];
/*$logo = $_FILES['logo'];
$image = file_get_contents($logo);
$image = base64_encode($image); */

// other variables for the email that will be sent to the user
$regarding = "Thank you for registering in Wake & Match";
$date = date('Y-m-d H:i:s');

// insert data in db
$insertIntoCompanies = mysqli_query($conn, "INSERT INTO `worldofi_mmsr`.`companies` 
	VALUES ('','$companyname','$caddress','$cfield','$repfname','$replname','$repphone','$repemail','')");

// fetching the register id in order to insert it in the usernames table to connect tables
$selectCompRegID = mysqli_query($conn,"SELECT companiesid FROM companies WHERE comprepemail='$repemail'");   // ALL companies
$fetchCompRegID = mysqli_fetch_array($selectCompRegID);
$compRegId =  mysqli_real_escape_string($conn,$fetchCompRegID[0]);

if(!$selectCompRegID){
	echo "error: ".mysqli_error($conn);
	exit();
}

$insertIntoUsernames = mysqli_query($conn, "INSERT INTO `worldofi_mmsr`.`usernames` 
	VALUES ('','company','$repusername','$reppassword','$date','$compRegId')");

if(!$insertIntoCompanies){
	echo "error: ".mysqli_error($conn);
	exit();
} 

if(!$insertIntoUsernames){
	echo "error: ".mysqli_error($conn);
	exit();
} else {
	echo "Thank you for registering. Please go back and log in.";
}
/*
// send an email to user with username and password
$to = $repemail;
$subject = 'Thank you for registering in Wake & Match';
$regarding = $_POST['regarding'];
$message = 'Thank you for registering in Wake & Match Your username is '.$repusername.' and your password is: '.$reppassword;

$header = "---- Contact Details: ----
Name: $repfname." ".$replname
Email: $repemail 
Date: $date
Regarding: $regarding

$body = <<<EMAIL
From: $name
Regarding: $regarding

$message

ATTENTION: DO NOT REPLY TO THIS EMAIL"

if($_POST){
	mail($to, $subject, $header, $body);
	$feedback = 'An email was sent with yout details'; 
}
*/

?>