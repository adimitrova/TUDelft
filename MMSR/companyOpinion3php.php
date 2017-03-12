<?php
include 'compFunctions.php';
session_start();

	if(!isset($_SESSION['userid'])){
		echo "You're not logged in";
	} else {
		$opinion = $_GET['opin'];
		//echo $opinion;
		updateOpinion();
		echo '<style> a:link, a:visited, a:hover {color: #00b386; font-family: Calibri;font-size: 40px;} </style>';
		echo '<center><a rel="external" href="advertisementhtml.php" target="_parent" style="color:#8c0046">NEXT</a></center>';
		//echo '<head><meta http-equiv="refresh" content="0; url="advertisementhtml" /></head>';
		//echo '<script>window.open("advertisementhtml.php");</script>';
		//header('Location: advertisementhtml.php');
	}
?>