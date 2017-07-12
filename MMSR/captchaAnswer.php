<?php
session_start();

	if(!isset($_SESSION['userid'])){
		echo "You're not logged in";
	} else {
		require 'config.php';
		$usrAns = $_GET['answer'];

		$dbAnsCheck = mysqli_query($conn,"SELECT mathans FROM `temp` WHERE id_temp = 1");
		$fetchAns=mysqli_fetch_array($dbAnsCheck);
		$corrAns = $fetchAns['mathans'];

		// check if the answer field is empty and update the answer of the user in the temp table 
		if(!empty($usrAns)){
			$sql_updWithUsrAns = mysqli_query($conn,"UPDATE `worldofi_mmsr`.`temp` SET `userans` = '$usrAns' WHERE `id_temp` = 1");
		} elseif (empty($usrAns)){
			echo '<b><font face="Calibri" color="#00b386">Empty answer field</font><b>';
			exit;
		}

		// check if the given user answer is the same like the pre-set mathprob answer in the mathprob table 
		// where the id of the question in temp table equals the id of the math question in the mathprob table
		// IMPORTANT: Escape the html tags - use SINGLE QUOTES at the beginning and at the end, NOT double!
		if($usrAns==$corrAns){
			echo '<b><font face="Calibri" color="#00b386">CORRECT! Go to the </font><b>';
			echo '<a rel="external" href="matchApphtml.php" target="_parent" style="color:#8c0046">NEXT</a>';
			echo '<b><font face="Calibri" color="#00b386"> page.</font><b>';
		} else {
			echo '<b><font face="Calibri" color="#00b386">Wrong answer! Try again</font><b>';
		}

		$delTempTable = mysqli_query($conn,"DROP TABLE `temp`");

		mysqli_close($conn);
	}
?>



