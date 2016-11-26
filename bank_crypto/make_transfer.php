<?php

include 'header.php';
include 'dbhandler.php';



if(isset($_SESSION['id'])) {
	$_POST = $_SESSION['POST'];
	
	$userID = $_SESSION['id'];

	$stmt = "SELECT first,last FROM users WHERE id=$userID";
	$user = $conn->query($stmt)->fetch_assoc();

	$user_name = $user['first']." ".$user["last"];
	
	$benName = $_POST['benName'];
	$benNumber = $_POST['benNumber'];
	$title = $_POST['title'];
	$amount = $_POST['amount'];

	$sql = "INSERT INTO transfers (userID,benName,benNumber,title,amount) 
			VALUES ('$userID','$benName','$benNumber','$title','$amount')";

	$result = $conn->query($sql);

	$ret = mysqli_insert_id($conn);

	$stmt = "SELECT * FROM transfers WHERE id=$ret";
	$result = $conn->query($stmt);
	$row = $result->fetch_assoc();
	echo "<table id='summary'>
			<tr>
				<th>From:</th>
				<td>".$user_name."</td>
			</tr>
			<tr>
				<th>To:</th>
				<td>".$row['benName']."</td>
			</tr>
			<tr>
				<th>Beneficient Account number:</td>
				<td>".$row['benNumber']."</td>
			</tr>
			<tr>
				<th>Title:</th>
				<td>".$row['title']."</td>
			</tr>
			<tr>
				<th>Amount:</th>
				<td>".$row['amount']."</td>
			</tr>
		</table>";

	echo "<br><br>Transfer is complete!<br>"; 
	
} else {
	echo "You have to log in or sign up";
}
?>

	