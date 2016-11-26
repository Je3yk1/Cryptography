<?php
 session_start();

include '../dbhandler.php';

$first = $_POST['first'];
$last = $_POST['last'];
$uid = $_POST['uid'];
$pwd = $_POST['pwd'];
$account = $_POST['account'];

if (empty($first)) {
	header("Location: ../signup.php?error=empty");
	exit();
} 
if (empty($last)) {
	header("Location: ../signup.php?error=empty");
	exit();
}
if (empty($uid)) {
	header("Location: ../signup.php?error=empty");
	exit();
}
if (empty($pwd)) {
	header("Location: ../signup.php?error=empty");
	exit();
}
else {
	$sql = "SELECT uid FROM users WHERE uid='$uid'";
	$result = $conn->query($sql);

	$uid_check = mysqli_num_rows($result);
	
	
	if ($uid_check > 0) {
		header("Location: ../signup.php?error=username");
		exit();
	} else {
		$enc_pwd = password_hash($pwd, PASSWORD_DEFAULT);
		$sql = "INSERT INTO users (first,last,uid,pwd) 
		VALUES ('$first','$last','$uid','$enc_pwd')";
		$result = $conn->query($sql);

		$id = mysqli_insert_id($conn);
		$sql = "INSERT INTO users_accounts(userID,account_number) VALUES ($id,$account)";

		$result = $conn->query($sql);

		header("Location: ../index.php");
	}
}
?>