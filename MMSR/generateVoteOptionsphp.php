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
		// get all from temporary table with all the necessary info (has to be imported in the end in the opinions table)
		$CompanyIDfromTemp= mysqli_query($conn,"SELECT compID, currUser, answer, opinion FROM tempCompany");   // ALL companies
		$CompanyIDFetch = mysqli_fetch_array($CompanyIDfromTemp);
		$compID =  mysqli_real_escape_string($conn,$CompanyIDFetch[0]); 
		$currUsr =  mysqli_real_escape_string($conn,$CompanyIDFetch[1]); 
		$knowOrNot =  mysqli_real_escape_string($conn,$CompanyIDFetch[2]); 
		$posOrNeg =  mysqli_real_escape_string($conn,$CompanyIDFetch[3]); 
				
		// fetch advertisement image
		$selectCompanyAdImage= mysqli_query($conn,"SELECT logo, originalname FROM company, tempCompany 
												WHERE company.companyid = tempCompany.compID 
												AND tempCompany.compID = $compID");   // ALL companies
		$CompanyAdImageFetch = mysqli_fetch_array($selectCompanyAdImage);
		$advertisementImg =  mysqli_real_escape_string($conn,$CompanyAdImageFetch[0]); 	
		$compOrigName =  mysqli_real_escape_string($conn,$CompanyAdImageFetch[1]); 
		
		echo '<b><font face="Calibri" color="#00b386">'.$compOrigName.'</font><b><br><br>';
		
		echo '<img src="data:image/jpeg;base64,' .base64_encode($CompanyAdImageFetch['logo']). '" height="250" width="350"/><br><br>';
		
		
		/* --------------------------- GENERATING TERMS ---------------------------------- */
		
		
		// create temporary table
		$query2 = mysqli_query($conn,"CREATE TABLE IF NOT EXISTS worldofi_mmsr.tempterm (
		`tempid` INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
		`termid` INT(10),
		`companyid` INT(50),
		`term` VARCHAR(50),
		`termtype` VARCHAR(10),
		`logo` BLOB(250),
		`answer` VARCHAR(20))");

		// throw error details if temp table creation not successful
		if (!$query2)
		{
		die("error in query2 temp table creation: " .mysqli_error($conn));
		}  

		// insert the current random company logo into the temporary table for further operations
		$query3 = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`tempterm` 
		VALUES ('','','$compID','','','$advertisementImg','')");

		// throw error details if temp table insertion not successful
		if (!$query3)
		{
		die("error in Insert in Temp table query3: " .mysqli_error($conn));
		}  

		/* ----------------------------- SORT TERMS BY RANK ASC & DESC ----------------------------------- */

		// create new term temporary table newtermlist
		$newtermlist = mysqli_query($conn,"CREATE TABLE IF NOT EXISTS worldofi_mmsr.newtermlist (
		`newtermid` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
		`origtermid` INT(10),
		`companyid` INT(20),
		`term` VARCHAR(50),
		`currentRank` decimal(50,0))");

		// sort terms for the random company by HIGHEST ranked values

		$highestRankTerms = mysqli_query($conn, "SELECT term, currentRank, termid FROM ranks_test 
		WHERE companyID=$compID 
		ORDER BY currentRank DESC 
		Limit 6");

		$highestRow = mysqli_fetch_array($highestRankTerms);
		// var_dump($highestRow);  // result: array
		$highestTerm =  mysqli_real_escape_string($conn,$highestRow[0]); 
		$highestCurrentRank = mysqli_real_escape_string($conn,$highestRow[1]);
		$highestTermID = mysqli_real_escape_string($conn,$highestRow[2]);


		while ($row = mysqli_fetch_array($highestRankTerms,MYSQL_ASSOC)){
			$insertInNewtermlistHIGH = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`newtermlist` (origtermid,companyid,term,currentRank)
		 VALUES ('".$row["termid"]."','$compID','".$row["term"]."','".$row["currentRank"]."')");
			
			if(!$insertInNewtermlistHIGH) {
				die("error in the insert Query above: " .mysqli_error($conn));
			}

		}




		// sort terms for the random company by LOWEST ranked values
		$lowestRankTerms = mysqli_query($conn, "SELECT term, currentRank, termid FROM ranks_test 
		WHERE companyID='$compID' 
		ORDER BY currentRank ASC 
		Limit 6");

		$lowestRow = mysqli_fetch_array($lowestRankTerms);
		$lowestTerm =  mysqli_real_escape_string($conn,$lowestRow[0]); 
		$lowestCurrentRank = mysqli_real_escape_string($conn,$lowestRow[1]);
		$lowestTermID = mysqli_real_escape_string($conn,$lowestRow[2]);


		while ($row = mysqli_fetch_array($lowestRankTerms,MYSQL_ASSOC)){
			$insertInNewtermlistLOW = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`newtermlist` (origtermid,companyid,term,currentRank) VALUES ('".$row["termid"]."','$compID','".$row["term"]."','".$row["currentRank"]."')");
			
			if(!$insertInNewtermlistLOW) {
				die("error in the insert Query above: " .mysqli_error($conn));
			}
		}


		/* ------------------------------------ TERM 1 ------------------------ */

		// select a random term 1 from db
		// $Query_term1 = mysqli_query($conn, "SELECT ranks_test.term, ranks_test.termid 
		// FROM ranks_test, tempterm 
		// WHERE ranks_test.companyID = tempterm.companyid 
		// AND tempterm.tempid = 1 
		// AND ranks_test.termid NOT IN (SELECT termid from tempterm WHERE termid != 1)
		// ORDER BY RAND() 
		// LIMIT 1");

		$Query_term1 = mysqli_query($conn, "SELECT newtermlist.term, newtermlist.origtermid
		FROM newtermlist, tempterm 
		WHERE newtermlist.companyID = tempterm.companyid 
		AND tempterm.tempid = 1 
		AND newtermlist.origtermid NOT IN (SELECT termid from tempterm WHERE termid != 1)
		AND newtermid BETWEEN 1 AND 6
		ORDER BY RAND() 
		LIMIT 1");

		// throw error details if temp table creation not successful
		if (!$Query_term1)
		{
		die("error in Temp table creation Query_term1: " .mysqli_error($conn));
		}  

		$term1Array = mysqli_fetch_array($Query_term1);

		// get the result of the query and store each value of the array in a separate variable for easy access
		// mysqli_real_escape_string is needed since otherwise the insertion in the temp table does not work. 
		$term1value =  mysqli_real_escape_string($conn,$term1Array[0]); 
		$term1id = mysqli_real_escape_string($conn,$term1Array[1]);

		// insert the current random term into the temporary table for further operations
		$term1insertInTemp = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`tempterm` 
		VALUES ('','$term1id','','$term1value','','','')");

		// throw error details if temp table insertion not successful
		if (!$term1insertInTemp)
		{
		die("error in Temp table creation: " .mysqli_error($conn));
		} 

		// $updateCompID = mysqli_query($conn, "")

		/* ------------------------------------ TERM 2 ------------------------ */

		// select a random term 2 from db
		// $Query_term2 = mysqli_query($conn, "SELECT ranks_test.term, ranks_test.termid 
		// FROM ranks_test, tempterm 
		// WHERE ranks_test.companyID = tempterm.companyid 
		// AND tempterm.tempid = 1 
		// AND ranks_test.termid NOT IN (SELECT termid from tempterm WHERE termid != 1)
		// ORDER BY RAND() 
		// LIMIT 1");

		$Query_term2 = mysqli_query($conn, "SELECT newtermlist.term, newtermlist.origtermid
		FROM newtermlist, tempterm 
		WHERE newtermlist.companyID = tempterm.companyid 
		AND tempterm.tempid = 1 
		AND newtermlist.origtermid NOT IN (SELECT termid from tempterm WHERE termid != 1)
		AND newtermid BETWEEN 1 AND 6
		ORDER BY RAND() 
		LIMIT 1");

		if (!$Query_term2)
		{
		die("error in Temp table creation Query_term2: " .mysqli_error($conn));
		} 

		$term2Array = mysqli_fetch_array($Query_term2);
		$term2value =  mysqli_real_escape_string($conn,$term2Array[0]); 
		$term2id = mysqli_real_escape_string($conn,$term2Array[1]);

		$term2insertInTemp = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`tempterm` 
		VALUES ('','$term2id','','$term2value','','','')");

		if (!$term2insertInTemp)
		{
		die("error in Temp table creation: " .mysqli_error($conn));
		} 

		/* ------------------------------------ TERM 3 ------------------------ */

		// select a random term 2 from db
		// $Query_term3 = mysqli_query($conn, "SELECT ranks_test.term, ranks_test.termid 
		// FROM ranks_test, tempterm 
		// WHERE ranks_test.companyID = tempterm.companyid 
		// AND tempterm.tempid = 1 
		// AND ranks_test.termid NOT IN (SELECT termid from tempterm WHERE termid != 1)
		// ORDER BY RAND() 
		// LIMIT 1");

		$Query_term3 = mysqli_query($conn, "SELECT newtermlist.term, newtermlist.origtermid
		FROM newtermlist, tempterm 
		WHERE newtermlist.companyID = tempterm.companyid 
		AND tempterm.tempid = 1 
		AND newtermlist.origtermid NOT IN (SELECT termid from tempterm WHERE termid != 1)
		AND newtermid BETWEEN 7 AND 12
		ORDER BY RAND() 
		LIMIT 1");

		if (!$Query_term3)
		{
		die("error in Temp table creation Query_term3: " .mysqli_error($conn));
		}

		$term3Array = mysqli_fetch_array($Query_term3);
		$term3value =  mysqli_real_escape_string($conn,$term3Array[0]); 
		$term3id = mysqli_real_escape_string($conn,$term3Array[1]);

		$term3insertInTemp = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`tempterm` 
		VALUES ('','$term3id','','$term3value','','','')");

		if (!$term3insertInTemp)
		{
		die("error in Temp table creation: " .mysqli_error($conn));
		} 

		/* ------------------------------------ TERM 4 ------------------------ */


		// select a random term 2 from db
		// $Query_term4 = mysqli_query($conn, "SELECT ranks_test.term, ranks_test.termid 
		// FROM ranks_test, tempterm 
		// WHERE ranks_test.companyID = tempterm.companyid 
		// AND tempterm.tempid = 1 
		// AND ranks_test.termid NOT IN (SELECT termid from tempterm WHERE termid != 1)
		// ORDER BY RAND() 
		// LIMIT 1");

		$Query_term4 = mysqli_query($conn, "SELECT newtermlist.term, newtermlist.origtermid
		FROM newtermlist, tempterm 
		WHERE newtermlist.companyID = tempterm.companyid 
		AND tempterm.tempid = 1 
		AND newtermlist.origtermid NOT IN (SELECT termid from tempterm WHERE termid != 1)
		AND newtermid BETWEEN 7 AND 12
		ORDER BY RAND() 
		LIMIT 1");

		if (!$Query_term4)
		{
		die("error in Temp table creation Query_term4: " .mysqli_error($conn));
		}

		$term4Array = mysqli_fetch_array($Query_term4);
		$term4value =  mysqli_real_escape_string($conn,$term4Array[0]); 
		$term4id = mysqli_real_escape_string($conn,$term4Array[1]);

		$term4insertInTemp = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`tempterm` 
		VALUES ('','$term4id','','$term4value','','','')");

		if (!$term4insertInTemp)
		{
		die("error in Temp table creation: " .mysqli_error($conn));
		} 

		/* ------------------------------------ END TERM GENERATION ------------------------ */



		/* ------------------------------------  POPULATE THE OPTIONS ON THE SCREEN OF THE USER ------------------------ */

		$option1 = mysqli_query($conn, "SELECT term FROM tempterm WHERE tempid=2");

		if (!$option1)
		{
		die("error in Temp table creation option1: " .mysqli_error($conn));
		} 

		$term1 = mysqli_fetch_row($option1);

		//------------------------------ 

		$option2 = mysqli_query($conn, "SELECT term FROM tempterm WHERE tempid=3");

		if (!$option2)
		{
		die("error in Temp table creation option2: " .mysqli_error($conn));
		} 

		$term2 = mysqli_fetch_row($option2);

		//------------------------------ 

		$option3 = mysqli_query($conn, "SELECT term FROM tempterm WHERE tempid=4");

		if (!$option3)
		{
		die("error in Temp table creation option3: " .mysqli_error($conn));
		} 

		$term3 = mysqli_fetch_row($option3);

		//------------------------------ 

		$option4 = mysqli_query($conn, "SELECT term FROM tempterm WHERE tempid=5");

		if (!$option4)
		{
		die("error in Temp table creation option4: " .mysqli_error($conn));
		} 

		$term4 = mysqli_fetch_row($option4);

		// remove form target    target="_parent"
		echo '<form class="formanswer" action="submitVoteOptionsphp.php" method="GET">';
		echo '<input type="radio" name="vote" value="'.implode(" ",$term1).'"><b><font face="Calibri" color="#00b386">'.implode(" ",$term1).'</font><b></input>';
		echo '<br><input type="radio" name="vote" value="'.implode(" ",$term2).'"><font face="Calibri" color="#00b386">'.implode(" ",$term2).'</font><b></input>';
		echo '<br><input type="radio" name="vote" value="'.implode(" ",$term3).'"><font face="Calibri" color="#00b386">'.implode(" ",$term3).'</font><b></input>';
		echo '<br><input type="radio" name="vote" value="'.implode(" ",$term4).'"><font face="Calibri" color="#00b386">'.implode(" ",$term4).'</font><b></input><br><br>';
		echo '<input type="submit" name="sendAns" value="Submit" />';
		echo '</form>';
		// NB! the radio button options NAME attr must be with the same name, like here "opt" in order for
		// NB! the user to be able to select only one option
	}
?>