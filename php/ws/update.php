<?php
	// Mang JSON
	$response = array();

	// Kiem tra nhung field bat buoc
	if (isset($_POST['acc_user'])) { 
		$acc_user = $_POST['acc_user']; 
		$acc_pwd = $_POST['acc_pwd'];
		require_once __DIR__ . '/connect.php';

		 // Tạo kết nối đến máy chủ
		 $db = new dbConnect();
		 $conn = $db->connect();
		 // Thêm tài khoản
		 $result = mysqli_query($conn,"UPDATE acc_tbl SET acc_pwd = '$acc_pwd' WHERE acc_user = '$acc_user'");

		 if ($result) {
			// Mật khẩu đã được thay đổi
			$response["success"] = 1;
			$response["message"] = "Thay đổi mật khẩu thành công.";

			// Trả kết quả
			echo json_encode($response);
		 } else {
			$response["success"] = 0;
			$response["message"] = "Thay đổi mật khẩu thất bại.";
		 
			// Tra ket qua
			echo json_encode($response);
		}
	} else {
		// Thong bao loi
		$response["success"] = 0;
		$response["message"] = "Bạn chưa nhập thông tin bắt buộc.";

		// Tra ket qua
		echo json_encode($response);
}
?>