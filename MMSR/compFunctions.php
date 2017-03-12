<?php

		function variables(){
			require 'config.php';
			//select a random logo from db
			$selectCompanyLogo = mysqli_query($conn,"SELECT logo, companyid FROM company ORDER BY RAND() LIMIT 1");   // ALL companies
			$row = mysqli_fetch_array($selectCompanyLogo);
			$image =  mysqli_real_escape_string($conn,$row[0]); 
			$compID = mysqli_real_escape_string($conn,$row[1]); //opcompanyid
			//echo '<img src="data:image/jpeg;base64,' .base64_encode($row['logo']). '" />';
		}
		
		//CompanyOpinion #1
		function knowOrNot() {
			require 'config.php';
			$selectCompanyLogo = mysqli_query($conn,"SELECT logo, companyid, originalname FROM company ORDER BY RAND() LIMIT 1");   // ALL companies
			$row = mysqli_fetch_array($selectCompanyLogo);
			$image =  mysqli_real_escape_string($conn,$row[0]); 
			$compID = mysqli_real_escape_string($conn,$row[1]); //opcompanyid
			$compName = mysqli_real_escape_string($conn,$row[2]); // company name
			
			//$userKnowsCompany = "Yes";
			//$userKnowsCompanyNOT = "No";
			
			echo $compName;
			//echo '<img src="data:image/jpeg;base64,' .base64_encode($row['logo']). '" height="250" width="350"/>';
			
			// create temporary table
			$tempTableCreate = mysqli_query($conn,"CREATE TABLE IF NOT EXISTS worldofi_mmsr.tempCompany (
			`tempid` INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			`currUser` INT(50),
			`compID` INT(50),
			`answer` VARCHAR(20),
			`opinion` VARCHAR(20))");

			// throw error details if temp table creation not successful
			if (!$tempTableCreate)
			{
			die("error in tempTableCreate temp table creation: " .mysqli_error($conn));
			}  

			// insert the current random company id into the temporary table for further operations
			$updateCompID = mysqli_query($conn,"INSERT INTO `worldofi_mmsr`.`tempCompany` 
			VALUES ('','','$compID','','')");
			
			// throw error details if insert not successful
			if (!$updateCompID)
			{
			die("error in updateCompID temp table creation: " .mysqli_error($conn));
			}  
			
			/* action="sendOpiniontoDB.php */
			// remove form target    target="_parent"
			echo '<form class="formanswer" action="companyOpinion2php.php" method="GET" target="_self">';
			echo '<br><input type="radio" name="opt" value="Yes"><b><font face="Calibri" color="#00b386">Yes</font><b></input>';
			echo '<br><input type="radio" name="opt" value="No"><font face="Calibri" color="#00b386">No</font><b><br><br></input>';
			echo '<input type="submit" name="sendknowsornot" value="Submit"/>';
			echo '<input type="submit" name="skip" value="Skip"/>';
			echo '</form>';
			// NB! the radio button options NAME attr must be with the same name, like here "opt" in order for
			// NB! the user to be able to select only one option
		}
		
		//CompanyOpinion #1
		function posOrNeg() {
			require 'config.php';
			$answer = $_GET['opt'];

			if ($answer == "Yes"){	

				// update answer=Yes into the temporary table for further operations
				$updateAnswerY = mysqli_query($conn,"UPDATE worldofi_mmsr.tempCompany
													SET tempCompany.answer = '$answer'
													WHERE tempid = 1");
				
				// throw error details if insert not successful
				if (!$updateAnswerY)
				{
				die("error in updateAnswer temp table creation: " .mysqli_error($conn));
				}  
				
				// as it gives error that it can not update the header, we fix that by providing user with link to manually go to next page
				if (headers_sent()) {
					die('<br><br><a href="http://localhost/mmsrproj2/askopinionhtml.html">NEXT</a>');
				}
				else{
					//echo "Success! Now it has to send you to compOpinion3";
					header("Location: askopinionhtml.html");
				}

			} else {
				// setting answer of Know company or Not to the answer and setting the opinion to "---" as company is unknown
				$unknownComp = "---"; 
				// update answer=No into the temporary table for further operations
				$updateAnswerN = mysqli_query($conn,"UPDATE worldofi_mmsr.tempCompany
													SET tempCompany.answer = '$answer',tempCompany.opinion = '$unknownComp'
													WHERE tempid = 1");
				
				// throw error details if insert not successful
				if (!$updateAnswerN)
				{
				die("error in updateAnswer temp table creation: " .mysqli_error($conn));
				} 

				// header('Location: mathproblemhtml.php'); sends error
				// echo "<br> <br> Oooh, how sad :(";
				
				// Provide link to go to the term voting page (skipping the opinion page)
				echo '<style> a:link, a:visited, a:hover {color: #00b386; font-family: Calibri;font-size: 40px;} </style>';
				echo '<center><a rel="external" href="advertisementhtml.php" target="_parent" style="color:#8c0046">NEXT</a></center>';
			}
		}
		
		function updateOpinion() {
			require 'config.php';
			//$opinion = $_GET['opin'];
			variables();
			$opinion = $_GET['opin'];
			
			// update answer=Yes into the temporary table for further operations
			$updateOpinion = mysqli_query($conn,"UPDATE worldofi_mmsr.tempCompany
												SET tempCompany.opinion = '$opinion'
												WHERE tempid = 1");
			
			// throw error details if insert not successful
			if (!$updateOpinion)
			{
			die("error in updateAnswer temp table creation: " .mysqli_error($conn));
			}  
			
			//header ('Location: ');
		}
	//}
?>