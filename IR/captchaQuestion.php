<?php

$conn=mysqli_connect("localhost","worldofi_irdb","FAKEPASS");
$db_select=mysqli_select_db($conn,"worldofi_irdb");

//select a random math problem from db
$query = mysqli_query($conn,"SELECT mathprob AS Question, prob_id AS ID, mathans as ANS
							FROM mathprob 
							ORDER BY RAND() 
							LIMIT 1");
							
$row = mysqli_fetch_row($query);

$ques =  $row[0]; 
$ans = $row[2];
$prob_id = $row[1];

echo '<b><font face="Calibri" color="white">'.$ques.'</font><b>';

// create temporary table
$query2 = mysqli_query($conn,"CREATE TABLE IF NOT EXISTS worldofi_irdb.temp (
`id_temp` INT( 5 ) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`prob_id` INT( 50 ),
`mathprob` varchar( 50 ),
`mathans` INT(50),
`userans` INT(50))");


// insert the retrieved query result in the temp table, 
// leaving the user answer blank

//check db connection status
if (!$query)
{
die("error:" .mysqli_error($conn));
}  

// populate result on the screen of the user in a table
if(isset($_GET['mathprob'])){
echo "<table>";
while ($result=mysqli_fetch_array($query))
{
echo "<tr><td>".$result['Question']," </td></tr>";
}
echo "</table>";
}

// insert math problem into the temporary table

$query3 = mysqli_query($conn,"INSERT INTO `worldofi_irdb`.`temp` 
VALUES ('','$prob_id','$ques','$ans','')");

//$sql_InsertInTemp = mysqli_query($conn,$query3);

if (!$query3)
{
die("error:" .mysqli_error($query3));
} 
	
mysqli_close($conn);	
?>



