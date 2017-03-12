<?php
// connect to localhost and to the DB
$conn=mysqli_connect("localhost","worldofi_irdb","FAKEPASS");
$db_select = mysqli_select_db($conn,"worldofi_irdb");

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
} else {
	echo "term 1 inserted";
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
} else {
	echo "<br> term 2 inserted";
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
} else {
	echo "<br> term 3 inserted";
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
} else {
	echo "<br> term 4 inserted";
}

/* ------------------------------------ END TERM GENERATION ------------------------ */



?>