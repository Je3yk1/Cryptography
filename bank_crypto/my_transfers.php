<?php
include 'header.php';
include 'dbhandler.php';
	
	 if(isset($_SESSION['id'])) {
	 		$id = $_SESSION['id'];
	 		$stmt = "SELECT * FROM transfers WHERE userID=$id";

	 		$result = $conn->query($stmt);

	 		echo "<table>
	 				<tr>
	 					<th>TO</th>
	 					<th>ACCOUNT NUMBER</th>
	 					<th>TITLE</th>
	 					<th>AMOUNT</th>
	 				</tr>";
	 		while($row = mysqli_fetch_assoc($result)) {
	 			echo "<tr id='info'>
						<td>".$row['benName']."</td>
						<td>".$row['benNumber']."</td>
						<td>".$row['title']."</td>
						<td>".$row['amount']."</td>
					 </tr>";
	 			
	 		}
			echo "</table>";
	} else {
		echo "You have to log in or sign up";
	}

?>


</article>
    
    </body>
</html>