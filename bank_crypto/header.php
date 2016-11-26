<?php
    session_start();
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bank</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <script type="text/javascript" src="test.js"></script>
    </head>
    <body onload="main()">

    <header>
    	<nav>
    		<ul>
	    		<li><a href="index.php">HOME</a></li>
	    		<?php

				 
			        if(isset($_SESSION['id'])) {
			            
			            echo "<form id='logout' action='includes/logout.inc.php'>
					        	<button>LOG OUT</button>
					    	</form>";
					    echo '<li><a href="my_transfers.php">MY TRANSFERS</a></li>';
			        } else {
			            echo "<form id='login' action='includes/login.inc.php' method='POST'>
				         <input type='uid'  id='uid' name='uid' placeholder='Username'>
				         <input type='password' id='pwd' name='pwd' placeholder='Password'>
				         <button type='submit'>LOGIN</button>
    					</form>";
    					echo '<li><a href="signup.php">SIGN UP</a></li>';
			        }
    
					  			

	    		?>
	    		
	    		
    		</ul>
    	</nav>
    </header>
    	
    <article>