<?php
    include 'header.php';
?>
   
    
    

    <?php

        $url =  "http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];

        if (strpos($url, 'error=empty') !== false) {
            echo "Fill out all fields!";
        }  elseif (strpos($url, 'error=username') !== false) {
            echo "Username already exists!";
        }
       

        if(isset($_SESSION['id'])) {
            echo "You are already log in!";
        } else {
            echo "<br>Hi! sign up to our transfer system<br><br>";
            echo '<form action="includes/signup.inc.php" method="POST">
            <input type="text" id="first" name="first" placeholder="Firstname"><br>
            <input type="text" id="last" name="last" placeholder="Lastname"><br>
            <input type="text"  id="uid" name="uid" placeholder="Username"><br>
            <input type="password" id="pwd" name="pwd" placeholder="Password"><br>
            <input type="text" id="account" name="account" placeholder="Account number"><br>
            <button type="submit">SIGN UP</button>
        </form>';
        }
    ?>

        
    </article>
    
    </body>
</html>