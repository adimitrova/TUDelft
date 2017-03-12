<?php
include 'compFunctions.php';
include 'config.php';
session_start();

	if(!isset($_SESSION['userid'])){
		echo "You're not logged in";
	} else {
		if(empty($_GET['opt']) && isset($_GET['skip'])){
			//echo "Skip button clicked";
			$dropTableTempTerm = mysqli_query($conn,"drop table tempterm");
			$dropTableNewTermList = mysqli_query($conn,"drop table newtermlist");
			$dropTableTempCompany = mysqli_query($conn,"drop table tempCompany");
			echo "To vote again, click on <br> SHOW COMPANY";
		} else {
			$answer = $_GET['opt'];
			//echo $answer;
			posOrNeg();
			//echo "Answer given about the company";
		}
	}
?>