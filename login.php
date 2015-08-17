<?php

  // Code based on tutorial at: 
  // http://www.mybringback.com/android-sdk/12924/android-tutorial-using-remote-databases-php-and-mysql-part-1/
  
  require("config.login.inc.php");

  if (!empty($_POST)) {
    //initial query 
    $posted_username = $_POST['researcher_username'];
    $posted_password = $_POST['researcher_password'];
    
    if (($posted_username == $researcher_username) && ($posted_password == $researcher_password)) {
      $response["success"] = 1;
      $response["message"] = "correct credentials";
      echo json_encode($response);
    } else {
      $response["success"] = 0;
      $response["message"] = "incorrect credentials";
      echo json_encode($response);
    }
  }
?> 
