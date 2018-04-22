
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `admin` VALUES (1,'david@gmail.com','password','2018-02-26 06:33:36');

CREATE TABLE `booking` (
  `BookingId` varchar(20) NOT NULL,
  `userid` varchar(128) DEFAULT NULL,
  `BusId` varchar(20) DEFAULT NULL,
  `DepartureDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DepartureTime` time DEFAULT NULL,
  PRIMARY KEY (`BookingId`),
  KEY `UserId` (`userid`),
  KEY `BusId` (`BusId`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`BusId`) REFERENCES `bus` (`BusId`) ON DELETE CASCADE
);

INSERT INTO `booking` VALUES ('booking1','user1','bus1','2018-11-29 18:30:00','19:00:00'),('booking2','user1','bus1','2018-11-29 18:30:00','19:00:00'),('booking3','user1','bus4','2018-12-04 18:30:00','04:45:00');


CREATE TABLE `bus` (
  `BusId` varchar(20) NOT NULL,
  `BusName` varchar(128) DEFAULT NULL,
  `BusType` varchar(128) DEFAULT NULL,
  `DepartureTime` time DEFAULT NULL,
  `TravelTime` time DEFAULT NULL,
  `DepartureCity` varchar(128) DEFAULT NULL,
  `ArrivalCity` varchar(128) DEFAULT NULL,
  `cost` double NOT NULL,
  `OperatorId` varchar(20) DEFAULT NULL,
  `TotalSeats` int(3) DEFAULT NULL,
  PRIMARY KEY (`BusId`),
  KEY `OperatorId` (`OperatorId`),
  CONSTRAINT `bus_ibfk_1` FOREIGN KEY (`OperatorId`) REFERENCES `busoperator` (`OperatorId`) ON DELETE CASCADE
);

INSERT INTO `bus` VALUES ('bus1','Hashem Travels','Chevrolet','12:00:00','19:00:00','alex','Sharm',2100,'busoperator1',50),('bus2','Hashem Travels','Chevrolet','18:00:00','08:00:00','Suez','Cairo',1300,'busoperator1',50),('bus3','Hashem Travels','Chevrolet','06:00:00','16:15:00','Alex','Cairo',650,'busoperator2',56),('bus4','Hashem travels','Chevrolet','21:00:00','04:45:00','Shebin','Suez',2600,'busoperator2',38);


CREATE TABLE `busoperator` (
  `OperatorId` varchar(20) NOT NULL,
  `OperatorName` varchar(128) DEFAULT NULL,
  `Address` varchar(128) DEFAULT NULL,
  `email` varchar(128) NOT NULL,
  `City` varchar(128) DEFAULT NULL,
  `PhoneNumber` varchar(20) DEFAULT NULL,
  `Password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`OperatorId`),
  UNIQUE KEY `email` (`email`)
);

INSERT INTO `busoperator` VALUES ('busoperator1','Ahmed','Alex','Ahmed@gmail.com','alex','908978675','01254522'),('busoperator2','ashraf','Shebin','ashraf@gmail.com','Shebin','9182736451','02481581'),('busoperator3','akram','Cairo','akram@gmail.com','Cairo','8562256252','5550000123'),('busoperator4','Salem','Alex','Salem@gmail.com','Alex','7644112324','0555714000');
CREATE TABLE `seatallocation` (
  `SeatId` varchar(20) NOT NULL,
  `BookingId` varchar(20) DEFAULT NULL,
  `SeatType` varchar(10) DEFAULT NULL,
  `BusId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SeatId`),
  KEY `BusId` (`BusId`),
  KEY `BookingId` (`BookingId`),
  CONSTRAINT `seatallocation_ibfk_1` FOREIGN KEY (`BusId`) REFERENCES `bus` (`BusId`) ON DELETE CASCADE,
  CONSTRAINT `seatallocation_ibfk_2` FOREIGN KEY (`BookingId`) REFERENCES `booking` (`BookingId`) ON DELETE CASCADE
);
INSERT INTO `seatallocation` VALUES ('seatallocation1','booking1',NULL,'bus1'),('seatallocation2','booking1',NULL,'bus1'),('seatallocation3','booking1',NULL,'bus1'),('seatallocation4','booking1',NULL,'bus1'),('seatallocation5','booking2',NULL,'bus1'),('seatallocation6','booking2',NULL,'bus1'),('seatallocation7','booking3',NULL,'bus4');


CREATE TABLE `payment` (
  `PaymentId` varchar(20) NOT NULL,
  `BookingId` varchar(20) DEFAULT NULL,
  `TotalAmount` int(6) DEFAULT NULL,
  `PaymentDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `OperatorId` varchar(20) DEFAULT NULL,
  `TotalSeats` int(3) DEFAULT NULL,
  `Status` varchar(10) DEFAULT 'NOT PAID',
  PRIMARY KEY (`PaymentId`),
  KEY `BookingId` (`BookingId`),
  KEY `OperatorId` (`OperatorId`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`BookingId`) REFERENCES `booking` (`BookingId`) ON DELETE CASCADE,
  CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`OperatorId`) REFERENCES `busoperator` (`OperatorId`) ON DELETE CASCADE
);

INSERT INTO `payment` VALUES ('payment1','booking1',8400,'2018-11-26 09:48:55','busoperator1',4,'NOT PAID'),('payment2','booking2',200,'2018-11-26 09:49:14','busoperator1',2,'NOT PAID'),('payment3','booking3',600,'2018-11-26 09:50:10','busoperator2',1,'NOT PAID');


CREATE TABLE `user` (
  `userid` varchar(128) NOT NULL DEFAULT '',
  `FirstName` varchar(64) DEFAULT NULL,
  `LastName` varchar(64) DEFAULT NULL,
  `Address` varchar(128) DEFAULT NULL,
  `City` varchar(128) DEFAULT NULL,
  `email` varchar(128) NOT NULL,
  `PhoneNumber` varchar(50) DEFAULT NULL,
  `Password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `email` (`email`)
);

INSERT INTO `user` VALUES ('user1','ahmed','nasser','cairo','cairo','ahmed@gmail.com','9021154414','12345'),('user2','kareem','tawfeek','alex','alex','kareem@gmail.com','9158817142','asdasd'),('user3','mona','ramezy','alex','alex','monaramezy@gmail.com','9090909090','zxczxc'),('user4','akram','elbasha','alex','alex','akram@gmail.com','9243456743','mujju'),('user5','nabil','magdy','alex','alex','nabil@gmail.com','7876571234','nilzpaapa'),('user6','magdy','saad','alex','alex','magdy@gmail.com','8989786786','madhuama');

