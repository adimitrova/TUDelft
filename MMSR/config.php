<?php
	$mysql_host = 'localhost';
	$mysql_user = 'worldofi_mmsr';
	$mysql_pass = 'FAKEPASS';
	$mysql_db = 'worldofi_mmsr';
	
	$conn = mysqli_connect($mysql_host, $mysql_user, $mysql_pass);
	$dbconn = mysqli_select_db($conn,$mysql_db);
	
	// to make sure that cyrillic will insert in phpMyAdmin, the fields collation has to be set to utf8_unicode_ci 
	// and the following $encode variable should be called
	$encode = mysqli_set_charset($conn, 'utf8');
	
	if (!$conn || !$dbconn || !$encode){
		echo "Error in config";
		die(mysqli_error($conn));
	}
?>