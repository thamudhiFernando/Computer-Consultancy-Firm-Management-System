DROP DATABASE IF EXISTS CCFSYSTEM;
CREATE DATABASE CCFSYSTEM;
USE CCFSYSTEM;

CREATE TABLE Admin(
  adminId VARCHAR(15) NOT NULL,
  adminName VARCHAR(200) NOT NULL,
  adminPassword VARCHAR(200) NOT NULL,
  adminAddress VARCHAR(255) NOT NULL,
  adminContact VARCHAR(10) NOT NULL,
  PRIMARY KEY(adminId)
)ENGINE=INNODB;



CREATE TABLE Positions(
  positionsType VARCHAR(45) NOT NULL,
  paidAmountPerHour DECIMAL(10,2) NOT NULL,
  PRIMARY KEY(positionsType)
)ENGINE=INNODB;



CREATE TABLE Employee(
  employeeId VARCHAR(15) NOT NULL,
  positionsType VARCHAR(45) NOT NULL,
  employeeNIC VARCHAR(10) NOT NULL,
  employeeName VARCHAR(200) NOT NULL,
  employeeAddress VARCHAR(255) NOT NULL,
  employeeContact VARCHAR(10) NOT NULL,
  PRIMARY KEY(employeeId),
  CONSTRAINT FOREIGN KEY (positionsType) REFERENCES Positions(positionsType)
  ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;


CREATE TABLE Salary(
  salaryId INT NOT NULL AUTO_INCREMENT,
  employeeId VARCHAR(15) NOT NULL,
  employeeName VARCHAR(200) NOT NULL,
  positionsType VARCHAR(45) NOT NULL,
  totalSalary DECIMAL(10,2) NOT NULL,
  salaryDate Date NOT NULL,
  PRIMARY KEY(salaryId),
  CONSTRAINT FOREIGN KEY (employeeId) REFERENCES Employee(employeeId)
  ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;


CREATE TABLE Customer(
  customerNIC VARCHAR(10) NOT NULL,
  customerName VARCHAR(200) NOT NULL,
  customerAddress VARCHAR(255) NOT NULL,
  customerContact VARCHAR(10) NOT NULL,
  PRIMARY KEY(customerNIC)
)ENGINE=INNODB;


CREATE TABLE Contracts(
  contractID VARCHAR(10) NOT NULL,
  employeeId VARCHAR(15) NOT NULL,
  contractName VARCHAR(200) NOT NULL,
  descriptions VARCHAR(255) NOT NULL,
  serviceType VARCHAR(255) NOT NULL,
  employeeName VARCHAR(200) NOT NULL,
  creationDate Date NOT NULL,
  customerNIC VARCHAR(10) NOT NULL,
  customerName VARCHAR(200) NOT NULL,
  PRIMARY KEY(contractID,employeeId),
  CONSTRAINT FOREIGN KEY (customerNIC) REFERENCES Customer(customerNIC)
  ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (employeeId) REFERENCES Employee(employeeId)
  ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;



insert into admin values('1','admin','adminpw','Sri Lanka','0712356895');
insert into Customer values('965421319v','Thamudhi Fernando','Moratuwa','0713242063');
INSERT INTO Positions VALUES('Hardware Technician',230.00);
INSERT INTO Positions VALUES('Programmer',303.00);
INSERT INTO Positions VALUES('Software Installer',140.00);
INSERT INTO Employee values ('1','Programmer','9708928129','Denver Shan','Galanigama','0772771434');
INSERT INTO Employee values ('2','Software Installer','9688445452','Janitha Dhananjava','Bandaragama','0716485236');
INSERT INTO Contracts values ('1','1','name1','desc1','System Development','Denver Shan','2019-04-08','965421319v','Thamudhi Fernando');
INSERT INTO Contracts values ('1','2','name2','desc2','Data Recovery','Janitha Dhananjava','2019-04-08','965421319v','Thamudhi Fernando');
