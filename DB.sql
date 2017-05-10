CREATE database BookshopPOS;

use BookshopPOS; 

CREATE TABLE Users(
	username varchar(10) PRIMARY KEY NOT NULL,
	passwrd varchar(256) NOT NULL,
	fname varchar(50),
	lname varchar(50),
	phone varchar(15),
	utype int
);

CREATE TABLE Supplier(
	supid varchar(20) PRIMARY KEY,
	fname varchar(50),
	lname varchar(50),
	phone int,
	address varchar(100)
);

CREATE TABLE Stationary(
	itemid varchar(20) PRIMARY KEY,
	description varchar(50),
	buyingp float,
	sellingp float,
	qty int
);

CREATE TABLE Orders(
	orderid varchar(20) PRIMARY KEY,
	orderdate varchar(20),
	tot float,
	cashier varchar(20),
	CONSTRAINT FOREIGN KEY(cashier) REFERENCES Users(username)
);

CREATE TABLE OrderDetails(
	orderid varchar(20),
	itemid varchar(20),
	qty int,
	itemtot float,
	CONSTRAINT FOREIGN KEY(itemid) REFERENCES Stationary(itemid),
	CONSTRAINT FOREIGN KEY(orderid) REFERENCES Orders(orderid)
);

CREATE TABLE Purchases(
	purchid varchar(20) PRIMARY KEY,
	pdate varchar(20),
	tot float
);

CREATE TABLE PurchaseDetails(
	purchid varchar(20),
	itemid varchar(20),
	qty int,
	itemtot float,
	CONSTRAINT FOREIGN KEY(itemid) REFERENCES Stationary(itemid),
	CONSTRAINT FOREIGN KEY(purchid) REFERENCES Purchases(purchid)
);

insert into stationary values('S001','Pencil','8.00','10.00',50);
insert into stationary values('S002','Eraser','3.00','5.00',50);
insert into stationary values('S003','80 Pages Book','20.00','22.00',50);
insert into stationary values('S004','120 Pages Book','38.00','40.00',50);
insert into stationary values('S005','Pen','10.00','12.00',50);

insert into users values('janiya','1234','Janith','Ganewatta','0772921081',1);
insert into users values('sachiya','1234','Sachith','Silva','07777777',1);
insert into users values('poshiya','1234','Poshitha','Adhikari','07777777',1);
insert into users values('adiya','1234','Adithya','Wijethunga','07777777',1);
