<?php


$conn = mysqli_connect("localhost","root","","crypto_bank");

if(!$conn) {
    die("Connection failed: ".mysqli_connect_errno());
}