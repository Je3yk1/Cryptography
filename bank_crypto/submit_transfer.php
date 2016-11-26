<?php

include 'header.php';
include 'dbhandler.php';



if(isset($_SESSION['id'])) {
	$id = $_SESSION['id'];
	$sql = "SELECT first,last FROM users where id=$id";
	$result = $conn->query($sql);
	$row = $result->fetch_assoc();

	$user_name = $row['first']." ".$row['last'];
	
	$sql = "SELECT account_number FROM users_accounts WHERE userID = $id";

	$user_account = $conn->query($sql)->fetch_assoc();
	
	$benName = $_POST['benName'];
	$benNumber = $_POST['benNumber'];
	$title = $_POST['title'];
	$amount = $_POST['amount'];

	$_POST['userName'] = $user_name;
	$_POST['user_account'] = $user_account['account_number'];

	echo "<table id='summary'>
			<tr>
				<th>From:</th>
				<td>".$user_name."</td>
			</tr>
			<tr>
				<th>Account:</th>
				<td>".$user_account['account_number']."</td>
			</tr>
			<tr>
				<th>To:</th>
				<td>".$benName."</td>
			</tr>
			<tr>
				<th>Beneficient Account number:</td>
				<td>".$benNumber."</td>
			</tr>
			<tr>
				<th>Title:</th>
				<td>".$title."</td>
			</tr>
			<tr>
				<th>Amount:</th>
				<td>".$amount."</td>
			</tr>
		</table>";
	

	$_SESSION['POST'] = $_POST;
}
?>

	<form action="make_transfer.php" method="POST">
		<button type="submit">Confirm</button>
	</form>