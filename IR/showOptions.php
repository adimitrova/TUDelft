<?php
// connect to localhost and to the DB
$conn=mysqli_connect("localhost","worldofi_irdb","FAKEPASS");
$db_select = mysqli_select_db($conn,"worldofi_irdb");

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
echo '<input type="radio" name="opt" value="'.implode(" ",$term1).'"><b><font face="Calibri" color="white">'.implode(" ",$term1).'</font><b></input>';
echo '<br><input type="radio" name="opt" value="'.implode(" ",$term2).'"><font face="Calibri" color="white">'.implode(" ",$term2).'</font><b></input>';
echo '<br><input type="radio" name="opt" value="'.implode(" ",$term3).'"><font face="Calibri" color="white">'.implode(" ",$term3).'</font><b></input>';
echo '<br><input type="radio" name="opt" value="'.implode(" ",$term4).'"><font face="Calibri" color="white">'.implode(" ",$term4).'</font><b></input><br><br>';
echo '<input type="submit" name="sendAns" value="4. Submit Answer" />';
echo '</form>';
// NB! the radio button options NAME attr must be with the same name, like here "opt" in order for
// NB! the user to be able to select only one option


// if (isset($_post['submit'])){
	// if(isset($_post['opt']))
	// {
	// echo "<br>you have selected : ".$_post['opt'];
	// }
// }


// ------------------------------------



?>