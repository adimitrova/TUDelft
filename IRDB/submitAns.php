<?php
$conn=mysqli_connect("localhost","worldofi_irdb","FAKEPASS");
$db_select=mysqli_select_db($conn,"worldofi_irdb");

// get the option, chosen by the user in the radio button form
$answer = $_GET['opt'];

// echo $answer;

// add additional col to the temp table for the answer
// $addAnsCol = mysqli_query($conn, "ALTER TABLE `tempterm` ADD `answer` VARCHAR(20);");

// save the answer into that column
$answerSave = mysqli_query($conn,"INSERT INTO `worldofi_irdb`.`tempterm` 
VALUES ('','','','','','','$answer')");

// get the termid of the answer given by the user and save it in variable termID 
$fetchAnsTermID = mysqli_query($conn, "SELECT termid FROM tempterm
WHERE tempterm.term = (SELECT answer from tempterm WHERE tempid=6)");

$fetchTermfromQuery = mysqli_fetch_row($fetchAnsTermID);
$termID =  mysqli_real_escape_string($conn,$fetchTermfromQuery[0]); 
// echo $termID;

// update the rank of that term in ranks_test
$updRank = mysqli_query($conn, "UPDATE ranks_test
SET currentRank=currentRank+1
WHERE termid = ".$termID);

if(!$updRank){
	echo "error: ".mysqli_error($conn);
} else {
	echo '<b><font face="Calibri" color="white">Thanks for voting.<br><br>To vote again, click on "Show a logo".</font><b>';
}
	

// DROP TEMP TABLE
$dropTable = mysqli_query($conn,"drop table tempterm");

// note: query to return all ranks to the default value 2000, after testing:
// $backtoDefRank = mysqli_query($conn,"UPDATE ranks_test SET currentrank = 2000 WHERE currentrank > 2000");

?>