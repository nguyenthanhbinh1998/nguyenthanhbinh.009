-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th7 31, 2019 lúc 02:38 AM
-- Phiên bản máy phục vụ: 5.7.26
-- Phiên bản PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `androiddeft`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `password_hash` varchar(256) NOT NULL,
  `salt` varchar(256) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `member`
--

INSERT INTO `member` (`user_id`, `username`, `full_name`, `password_hash`, `salt`, `created_date`) VALUES
(1, 'binhcute', 'thanhbinh', '$2y$10$nn7ASxPg1xX2RBAfsXLcXeXR9A8vzlxFphCAUbGQaK0lKzgdJweoS', 'e628b39cad23403fd9290f5aab24ea8a7b632df659e3f55f8f550ee83d835c83', '2019-07-05 10:16:26'),
(4, 'binhvipcute', 'nguyenthanhbinh', '$2y$10$ZyiZdPQIjkpJVy230hdUweQzo2K9MrJCYGi2K1YZKd5f.4waNe0x.', 'e7203eec7db89c30b2617c0796dafea6790f97663df666dd31fa30b5f439449b', '2019-07-05 14:54:58'),
(5, 'binh1998', 'NGUYEN THANH BINH', '$2y$10$NY4xoIn7HqBQfAAO7M5bJu1ahcoHMvXfnYdxK1QTbMLZ/9nLvc0Iu', 'ab9db33ec354d9bf2667a34283ddd8729797d9f26a6156a4445f00d84ce60ec3', '2019-07-05 15:37:38'),
(7, 'binhcute113', 'THANH BINH', '$2y$10$28d5W8ntHei6pGMBtf0IXezeKd6PyC4pwEO1yeHUBIaAu6Tffmk8m', '9cae0f729fc48944f144ed20a8ece6a1633761334fab8b0de3cc7b43c20cc419', '2019-07-09 09:08:30');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
