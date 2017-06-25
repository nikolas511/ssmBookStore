数据库设计
//书本商品表
CREATE TABLE `books` (
  `id` varchar(50) NOT NULL,
  `bookname` varchar(30) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `books_category_id_fk` (`category_id`),
  CONSTRAINT `books_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

//书籍分类表
CREATE TABLE `category` (
  `id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//订单明细表
CREATE TABLE `orderitems` (
  `id` varchar(50) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `book_id` varchar(50) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderitems_book_id_fk` (`book_id`),
  KEY `orderitems_order_id_fk` (`order_id`),
  CONSTRAINT `orderitems_book_id_fk` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `orderitems_order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//订单表
CREATE TABLE `orders` (
  `id` varchar(50) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `totalprice` decimal(8,2) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_user_id_fk` (`user_id`),
  CONSTRAINT `orders_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//用户表
CREATE TABLE `users` (
  `id` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;