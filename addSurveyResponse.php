<?php

  // Code based on tutorial at: 
  // http://www.mybringback.com/android-sdk/12924/android-tutorial-using-remote-databases-php-and-mysql-part-1/

  //load and connect to MySQL database stuff
  require("config.inc.php");

  if (!empty($_POST)) {
    //initial query 
    $surveyColumnNames = json_decode($_POST['surveyColumnNames']);
    $surveyResponses = json_decode($_POST['surveyResponses']);
    
    $query = "INSERT INTO `SurveyResponses` (`ParticipantID`, `DayNumber`, `NotificationTime`, `SurveyCompletedTime`";
    
    foreach ($surveyColumnNames as $value) {
      $query .= (", `" . $value ."`"); 
    }
    
    $query .= ") VALUES (?, ?, ?, ?";
    
    
    foreach ($surveyColumnNames as $value) {
      $query .= (", ?"); 
    }
    
    $query .= (")");
    
    //execute query
    try {        
        // use prepared statement to prevent SQL injection
        $stmt = $db->prepare($query);
        
        // bind parameters
        $stmt->bindValue(1, $_POST['participantId']);
        $stmt->bindValue(2, $_POST['dayNumber']);
        $stmt->bindValue(3, $_POST['notificationTime']);
        $stmt->bindValue(4, $_POST['surveyCompletedTime']);
        
        foreach ($surveyResponses as $key=>$value) {
          $stmt->bindValue($key + 5, $value);
        }
        
        // execute query and get result
        $result = $stmt->execute();
    }
    catch (PDOException $ex) {
        // For testing, you could use a die and message. 
        //die("Failed to run query: " . $ex->getMessage());
        
        //or just use this use this one:
        $response["success"] = 0;
        $response["message"] = $ex->getMessage();
        die(json_encode($response));
    }

    $response["success"] = 1;
    $response["message"] = "record successfully added";
    echo json_encode($response);
   
  }
?> 
