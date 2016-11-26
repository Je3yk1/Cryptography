<?php
    include 'header.php';

    if(!isset($_SESSION['id'])) {
        echo 'Welcome on bank page! <br>';
        echo 'Log in or sign up to make transfer';
    } else {

        echo '<form action="submit_transfer.php" method="POST">
            <input type="text" name="benName" placeholder="Nazwa odbiorcy">
            <input type="text" name="benNumber" placeholder="Numer rachunku">
            <input type="text" name="title" placeholder="Tytul platnosci">
            <input type="text" name="amount" placeholder="Kwota">
            <button type="submit">Make transfer</button>
        </form>';
    } ;
?>  
    </article>
    </body>
</html>