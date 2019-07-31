<?php
 include_once './connect.php';
 
 function dispInfo(){
	$db = new dbConnect();
 
	$conn = $db->connect();
	if (!$conn) {
		die('Khong the ket noi den may chu: ' . mysqli_error($conn));
		exit();
	}
	
	// Mang JSON
	$response = array();
	$response["accounts"] = array();
 
	// Truy van du lieu	
	mysqli_set_charset($conn,'utf8');
	$result = mysqli_query($conn,"SELECT * FROM acc_tbl");
 
	// Duyet du lieu
	if (mysqli_num_rows($result) > 0) {
		while($row = mysqli_fetch_assoc($result)){ 
			$t = array();
			$t["acc_user"] = $row["acc_user"];
			$t["acc_pwd"] = $row["acc_pwd"];
 
			// Them du lieu vao mang
			array_push($response["accounts"], $t);
		}
	}
 
	// Thiet lap kieu tra ve la JSON
	header('Content-Type: application/json');
 
	// Gui ket qua ve client
	echo json_encode($response, JSON_UNESCAPED_UNICODE);
} 
dispInfo();
?>