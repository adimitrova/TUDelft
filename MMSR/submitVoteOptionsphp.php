<?php
//COMMENT OUT ERROR REPORING TO TROUBLESHOOT
error_reporting(0);
include 'compFunctions.php';
session_start();

	if(!isset($_SESSION['userid'])){
		echo "You're not logged in";
	} else {
		require 'config.php';
		$currUser = $_SESSION['userid'];
		$votedTerm = $_GET['vote'];

		$finalMessage = "Thanks for voting! <br>To VOTE again, click on VOTE AGAIN.<br><br>";
		echo '<center> <b><font face="Calibri" color="#00b386">'.$finalMessage.'</font></b> </center>';

		$CompanyIDfromTemp= mysqli_query($conn,"SELECT compID, answer, opinion FROM tempCompany");   // ALL companies
		$CompanyIDFetch = mysqli_fetch_array($CompanyIDfromTemp);
		$compID =  mysqli_real_escape_string($conn,$CompanyIDFetch[0]); 
		//$currUsr =  mysqli_real_escape_string($conn,$CompanyIDFetch[1]); 
		$knowOrNot =  mysqli_real_escape_string($conn,$CompanyIDFetch[1]); 
		$posOrNeg =  mysqli_real_escape_string($conn,$CompanyIDFetch[2]); 
		
		if (!$CompanyIDfromTemp) {
			// UNCOMMENT ERROR REPORTING BELOW
			//printf("Error in CompanyIDfromTemp: %s\n", mysqli_error($conn));
			echo '<style> a:link, a:visited, a:hover {color: #00b386; font-family: Calibri;font-size: 40px;} </style>';
			echo '<center><a rel="external" href="advertisementhtml.php" target="_parent" style="color:#8c0046">NEXT</a></center>';
			//exit();
		}
		
		$insertIntoOpinions = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`opinions` 
												  VALUES ('','$currUser','$compID','$knowOrNot','$posOrNeg')");
												  
		$insertIntoVotes = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`votes` 
												  VALUES ('','$currUser','$compID','$votedTerm')");
				
	
		if (!$insertIntoOpinions)
		{
		die("error in insertIntoOpinions temp table creation: " .mysqli_error($conn));
		} 
		
		if (!$insertIntoVotes)
		{
		die("error in insertIntoVotes temp table creation: " .mysqli_error($conn));
		}

		$dropTableTempTerm = mysqli_query($conn,"drop table tempterm");
		$dropTableNewTermList = mysqli_query($conn,"drop table newtermlist");
		$dropTableTempCompany = mysqli_query($conn,"drop table tempCompany");

		echo '<form class="formanswer" action="matchApphtml.php" method="GET" target="_parent">';
		echo '<center><input type="submit" name="voteagain" value="Vote again!" /> </center>';
		echo '</form>';
		// SHOW THAT IT WORKS (statistics) UNCOMMENT BELOW	
		// print all elo parts
		// echo "<font color='#00b386'>SUMMARY:<br>WINNER: ".$answer;
		// echo "<br> WINNER CurrRank: ".$AnswerCurrRank; 
		// echo "<br>WINNER NewRank: ".number_format((float)$winnerNewRank, 2, '.', ''); 
		// echo "<br> LOSERS AveRank: ".$losersAveCurrRank; 
		// echo "<br>winningProb".number_format((float)$winningProb, 2, '.', ''); // 0.09
		// echo "<br> LOSERS NewRank: ".number_format((float)$loserNewRank, 2, '.', '')."<br><br>"; 
		// alter table votes auto_increment = 5;
		// alter table opinions auto_increment = 5;	
	}
?>