CREATE TABLE `Admin` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50),
	`email` varchar(50),
	`password` varchar(50),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Retailer` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50),
	`email` varchar(50),
	`password` varchar(50),
	`adminId` int,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50),
	`email` varchar(50),
	`password` varchar(50),
	`phone` varchar(20),
	`joinDate` DATE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Product` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50),
	`brand` varchar(50),
	`price` int,
	`colour` varchar(20),
	`availableUnits` int,
	`pictures` varchar(255),
	`retailerId` int,
	`category` varchar(50),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Order` (
	`id` int NOT NULL AUTO_INCREMENT,
	`userId` int,
	`addressId` int,
	`productId` int,
	`totalPrice` int,
	`orderDate` DATE,
	`paymentId` int,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Address` (
	`id` int NOT NULL AUTO_INCREMENT,
	`house` varchar(50),
	`city` varchar(20),
	`state` varchar(20),
	`pincode` int(20),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Payment` (
	`id` int NOT NULL AUTO_INCREMENT,
	`type` varchar(20),
	`status` BOOLEAN,
	`paymentDate` DATE,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Retailer` ADD CONSTRAINT `Retailer_fk0` FOREIGN KEY (`adminId`) REFERENCES `Admin`(`id`);

ALTER TABLE `Product` ADD CONSTRAINT `Product_fk0` FOREIGN KEY (`retailerId`) REFERENCES `Retailer`(`id`);

ALTER TABLE `Order` ADD CONSTRAINT `Order_fk0` FOREIGN KEY (`userId`) REFERENCES `User`(`id`);

ALTER TABLE `Order` ADD CONSTRAINT `Order_fk1` FOREIGN KEY (`addressId`) REFERENCES `Address`(`id`);

ALTER TABLE `Order` ADD CONSTRAINT `Order_fk2` FOREIGN KEY (`productId`) REFERENCES `Product`(`id`);

ALTER TABLE `Order` ADD CONSTRAINT `Order_fk3` FOREIGN KEY (`paymentId`) REFERENCES `Payment`(`id`);








