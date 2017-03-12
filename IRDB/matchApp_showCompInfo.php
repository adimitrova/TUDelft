<?php

$conn=mysqli_connect("localhost","worldofi_irdb","FAKEPASS");
$db_select=mysqli_select_db($conn,"worldofi_irdb");

//select a random logo from db
$query = mysqli_query($conn,"SELECT logo, companyid FROM company ORDER BY RAND() LIMIT 1");

$row = mysqli_fetch_array($query);

// get the result of the query and store each value of the array in a separate variable for easy access
// mysqli_real_escape_string is needed since otherwise the insertion in the temp table does not work. 
$image =  mysqli_real_escape_string($conn,$row[0]); 
$compID = mysqli_real_escape_string($conn,$row[1]);

//show the company logo on the screen
echo '<img src="data:image/jpeg;base64,' .base64_encode($row['logo']). '" />';

// for control show company id to compare with the inserted value in the temp table (for debugging purposes only)
// echo '<br>'; echo $compID;


// create temporary table
$query2 = mysqli_query($conn,"CREATE TABLE IF NOT EXISTS worldofi_irdb.tempterm (
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
die("error in Temp table creation: " .mysqli_error($conn));
}  

// insert the current random company logo into the temporary table for further operations
$query3 = mysqli_query($conn,"INSERT INTO `worldofi_irdb`.`tempterm` 
VALUES ('','','$compID','','','$image','')");

// throw error details if temp table insertion not successful
if (!$query3)
{
die("error in Insert in Temp table: " .mysqli_error($conn));
}  


/* ------------------------------------ TERM 1 ------------------------ */

//select a random term 1 from db
$Query_term1 = mysqli_query($conn, "SELECT ranks_test.term, ranks_test.termid 
FROM ranks_test, tempterm 
WHERE ranks_test.companyID = tempterm.companyid 
AND tempterm.tempid = 1 
AND ranks_test.termid NOT IN (SELECT termid from tempterm WHERE termid != 1)
ORDER BY RAND() 
LIMIT 1");

// throw error details if temp table creation not successful
if (!$Query_term1)
{
die("error in Temp table creation: " .mysqli_error($conn));
}  

$term1Array = mysqli_fetch_array($Query_term1);

// get the result of the query and store each value of the array in a separate variable for easy access
// mysqli_real_escape_string is needed since otherwise the insertion in the temp table does not work. 
$term1value =  mysqli_real_escape_string($conn,$term1Array[0]); 
$term1id = mysqli_real_escape_string($conn,$term1Array[1]);

// insert the current random term into the temporary table for further operations
$term1insertInTemp = mysqli_query($conn,"INSERT INTO `worldofi_irdb`.`tempterm` 
VALUES ('','$term1id','','$term1value','','','')");

// throw error details if temp table insertion not successful
if (!$term1insertInTemp)
{
die("error in Temp table creation: " .mysqli_error($conn));
} 

// $updateCompID = mysqli_query($conn, "")

/* ------------------------------------ TERM 2 ------------------------ */

// select a random term 2 from db
$Query_term2 = mysqli_query($conn, "SELECT ranks_test.term, ranks_test.termid 
FROM ranks_test, tempterm 
WHERE ranks_test.companyID = tempterm.companyid 
AND tempterm.tempid = 1 
AND ranks_test.termid NOT IN (SELECT termid from tempterm WHERE termid != 1)
ORDER BY RAND() 
LIMIT 1");

if (!$Query_term2)
{
die("error in Temp table creation: " .mysqli_error($conn));
} 

$term2Array = mysqli_fetch_array($Query_term2);
$term2value =  mysqli_real_escape_string($conn,$term2Array[0]); 
$term2id = mysqli_real_escape_string($conn,$term2Array[1]);

$term2insertInTemp = mysqli_query($conn,"INSERT INTO `worldofi_irdb`.`tempterm` 
VALUES ('','$term2id','','$term2value','','','')");

if (!$term2insertInTemp)
{
die("error in Temp table creation: " .mysqli_error($conn));
} 

/* ------------------------------------ TERM 3 ------------------------ */

// select a random term 2 from db
$Query_term3 = mysqli_query($conn, "SELECT ranks_test.term, ranks_test.termid 
FROM ranks_test, tempterm 
WHERE ranks_test.companyID = tempterm.companyid 
AND tempterm.tempid = 1 
AND ranks_test.termid NOT IN (SELECT termid from tempterm WHERE termid != 1)
ORDER BY RAND() 
LIMIT 1");

if (!$Query_term3)
{
die("error in Temp table creation: " .mysqli_error($conn));
}

$term3Array = mysqli_fetch_array($Query_term3);
$term3value =  mysqli_real_escape_string($conn,$term3Array[0]); 
$term3id = mysqli_real_escape_string($conn,$term3Array[1]);

$term3insertInTemp = mysqli_query($conn,"INSERT INTO `worldofi_irdb`.`tempterm` 
VALUES ('','$term3id','','$term3value','','','')");

if (!$term3insertInTemp)
{
die("error in Temp table creation: " .mysqli_error($conn));
} 

/* ------------------------------------ TERM 4 ------------------------ */


// select a random term 2 from db
$Query_term4 = mysqli_query($conn, "SELECT ranks_test.term, ranks_test.termid 
FROM ranks_test, tempterm 
WHERE ranks_test.companyID = tempterm.companyid 
AND tempterm.tempid = 1 
AND ranks_test.termid NOT IN (SELECT termid from tempterm WHERE termid != 1)
ORDER BY RAND() 
LIMIT 1");

if (!$Query_term4)
{
die("error in Temp table creation: " .mysqli_error($conn));
}

$term4Array = mysqli_fetch_array($Query_term4);
$term4value =  mysqli_real_escape_string($conn,$term4Array[0]); 
$term4id = mysqli_real_escape_string($conn,$term4Array[1]);

$term4insertInTemp = mysqli_query($conn,"INSERT INTO `worldofi_irdb`.`tempterm` 
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
die("error in Temp table creation: " .mysqli_error($conn));
} 

$term1 = mysqli_fetch_row($option1);

//------------------------------ 

$option2 = mysqli_query($conn, "SELECT term FROM tempterm WHERE tempid=3");

if (!$option2)
{
die("error in Temp table creation: " .mysqli_error($conn));
} 

$term2 = mysqli_fetch_row($option2);

//------------------------------ 

$option3 = mysqli_query($conn, "SELECT term FROM tempterm WHERE tempid=4");

if (!$option3)
{
die("error in Temp table creation: " .mysqli_error($conn));
} 

$term3 = mysqli_fetch_row($option3);

//------------------------------ 

$option4 = mysqli_query($conn, "SELECT term FROM tempterm WHERE tempid=5");

if (!$option4)
{
die("error in Temp table creation: " .mysqli_error($conn));
} 

$term4 = mysqli_fetch_row($option4);

echo '<form class="formanswer" action="submitAns.php" method="GET">';
echo '<br><input type="radio" name="opt" value="'.implode(" ",$term1).'"><b><font face="Calibri" color="white">'.implode(" ",$term1).'</font><b></input>';
echo '<br><input type="radio" name="opt" value="'.implode(" ",$term2).'"><font face="Calibri" color="white">'.implode(" ",$term2).'</font><b></input>';
echo '<br><input type="radio" name="opt" value="'.implode(" ",$term3).'"><font face="Calibri" color="white">'.implode(" ",$term3).'</font><b></input>';
echo '<br><input type="radio" name="opt" value="'.implode(" ",$term4).'"><font face="Calibri" color="white">'.implode(" ",$term4).'</font><b></input><br><br>';
echo '<input type="submit" name="sendAns" value="Submit" />';
echo '</form>';
// NB! the radio button options NAME attr must be with the same name, like here "opt" in order for
// NB! the user to be able to select only one option



mysqli_close($conn);

?>