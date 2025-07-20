CREATE DATABASE MG_PALESTINE_BRANCH;
USE MG_PALESTINE_BRANCH;

-- Customers table: 
CREATE TABLE Customers(
customarID int, 
customarName varchar (100), 
email varchar(100) unique not null, 
NIN bigint unique not null,
PRIMARY KEY (customarID)
);



describe Customers;

-- Customers phone table (phone is multivalued attribute)
CREATE TABLE CustomersPhone(
customarID int not null,
phone bigint not null,
FOREIGN KEY (customarID) REFERENCES Customers(customarID) 
	on delete cascade on update cascade,
CONSTRAINT Cphone PRIMARY KEY (customarID,phone)
); 



-- Cars table: 
CREATE TABLE Cars(
carID int, 
carType varchar (50) not null, 
carModel varchar(50) not null, 
carColor varchar(50) not null,
carStatus varchar(50) not null,
PRIMARY KEY (carID)
);


-- Services table:
CREATE TABLE Services(
serviceID int,
customarID int not null, 
carID int,
ServiceDescription varchar(200) not null,
PRIMARY KEY (serviceID),
FOREIGN KEY (customarID) REFERENCES Customers(customarID) 
	on delete cascade on update cascade,
FOREIGN KEY (carID) REFERENCES Cars(carID) 
	on delete cascade on update cascade
); 



-- Employees table: 
CREATE TABLE Employees(
employeeID int,
employeeName varchar(100) not null,
salary DECIMAL(5,3) not null,
dateOfEmployment date not null,
PRIMARY KEY (employeeID)
);
ALTER TABLE Employees
MODIFY COLUMN salary double;


-- Advertisers table
CREATE TABLE Advertisers(
employeeID int not null,
points int not null,
FOREIGN KEY (employeeID) REFERENCES Employees(employeeID) 
	on delete cascade on update cascade,
CONSTRAINT advertiserID PRIMARY KEY (employeeID,points)
);


-- Managers table
CREATE TABLE Managers(
employeeID int not null,
MonthlyReport varchar(100) not null,
FOREIGN KEY (employeeID) REFERENCES Employees(employeeID) 
	on delete cascade on update cascade,
CONSTRAINT managerID PRIMARY KEY (employeeID,MonthlyReport)
);


-- Salesmans table
CREATE TABLE Salesmans(
employeeID int not null,
employeeTarget int not null,
FOREIGN KEY (employeeID) REFERENCES Employees(employeeID) 
	on delete cascade on update cascade,
CONSTRAINT salesmanID PRIMARY KEY (employeeID,employeeTarget)
);

-- Sales table:
CREATE TABLE Sales(
saleID int,
saleDescription varchar(200) not null,
customarID int not null, 
carID int,
employeeID int,
PRIMARY KEY (saleID),
FOREIGN KEY (customarID) REFERENCES Customers(customarID) 
	on delete cascade on update cascade,
FOREIGN KEY (carID) REFERENCES Cars(carID) 
	on delete cascade on update cascade,
FOREIGN KEY (employeeID) REFERENCES Employees(employeeID) 
	on delete cascade on update cascade
);


-- Cash table
CREATE TABLE Cashs(
saleID int not null,
processNumber int not null,
bankCash DECIMAL(10,6) not null,
directCash DECIMAL(10,6) not null,
discounts float not null,
FOREIGN KEY (saleID) REFERENCES Sales(saleID) 
	on delete cascade on update cascade,
CONSTRAINT cashID PRIMARY KEY (saleID,processNumber)
);
ALTER TABLE Cashs
MODIFY COLUMN bankCash double;

ALTER TABLE Cashs
MODIFY COLUMN directCash double;

describe  Cashs;

-- InstallmentPayment table
CREATE TABLE InstallmentPayments(
saleID int not null,
processNumber int not null,
totalCost DECIMAL(10,6) not null,
firstPayment DECIMAL(10,6) not null,
monthlyInstallment DECIMAL(10,6) not null,
NumberOfMonths int not null,
FOREIGN KEY (saleID) REFERENCES Sales(saleID) 
	on delete cascade on update cascade,
CONSTRAINT paymentID PRIMARY KEY (saleID,processNumber)
);

ALTER TABLE InstallmentPayments
MODIFY COLUMN totalCost double;

ALTER TABLE InstallmentPayments
MODIFY COLUMN firstPayment double;

ALTER TABLE InstallmentPayments
MODIFY COLUMN monthlyInstallment double;


-- inserting a dummy data: 

-- Inserting records into Customers table
INSERT INTO Customers (customarID, customarName, email, NIN) VALUES
(1, 'John Doe', 'john.doe@example.com', 1234567890123456),
(2, 'Jane Smith', 'jane.smith@example.com', 2345678901234567),
(3, 'Alice Johnson', 'alice.johnson@example.com', 3456789012345678),
(4, 'Bob Brown', 'bob.brown@example.com', 4567890123456789),
(5, 'Charlie Davis', 'charlie.davis@example.com', 5678901234567890),
(6, 'Diana Evans', 'diana.evans@example.com', 6789012345678901),
(7, 'Edward Garcia', 'edward.garcia@example.com', 7890123456789012),
(8, 'Fiona Harris', 'fiona.harris@example.com', 8901234567890123),
(9, 'George Lee', 'george.lee@example.com', 9012345678901234),
(10, 'Helen King', 'helen.king@example.com', 1234567890123451),
(11, 'Irene Lopez', 'irene.lopez@example.com', 2345678901234562),
(12, 'Jack Martin', 'jack.martin@example.com', 3456789012345673),
(13, 'Karen Nelson', 'karen.nelson@example.com', 4567890123456784),
(14, 'Larry Oliver', 'larry.oliver@example.com', 5678901234567895),
(15, 'Monica Perez', 'monica.perez@example.com', 6789012345678906),
(16, 'Nathan Quinn', 'nathan.quinn@example.com', 7890123456789017),
(17, 'Olivia Roberts', 'olivia.roberts@example.com', 8901234567890128),
(18, 'Paul Scott', 'paul.scott@example.com', 9012345678901239),
(19, 'Quincy Turner', 'quincy.turner@example.com', 1234567890123450),
(20, 'Rachel Adams', 'rachel.adams@example.com', 2345678901234561);

-- Inserting records into CustomersPhone table
INSERT INTO CustomersPhone (customarID, phone) VALUES
(1, 1234567890),
(2, 2345678901),
(3, 3456789012),
(4, 4567890123),
(5, 5678901234),
(6, 6789012345),
(7, 7890123456),
(8, 8901234567),
(9, 9012345678),
(10, 1234567891),
(11, 2345678902),
(12, 3456789013),
(13, 4567890124),
(14, 5678901235),
(15, 6789012346),
(16, 7890123457),
(17, 8901234568),
(18, 9012345679),
(19, 1234567892),
(20, 2345678903);

-- Inserting records into Cars table
INSERT INTO Cars (carID, carType, carModel, carColor, carStatus) VALUES
(1, 'Sedan', 'Toyota Camry', 'Red', 'Available'),
(2, 'SUV', 'Honda CR-V', 'Blue', 'Sold'),
(3, 'Truck', 'Ford F-150', 'Black', 'Available'),
(4, 'Sedan', 'Tesla Model 3', 'White', 'Available'),
(5, 'SUV', 'Chevrolet Tahoe', 'Gray', 'Sold'),
(6, 'Truck', 'Ram 1500', 'Red', 'Available'),
(7, 'Sedan', 'BMW 3 Series', 'Blue', 'Available'),
(8, 'SUV', 'Nissan Rogue', 'Black', 'Sold'),
(9, 'Truck', 'Toyota Tundra', 'White', 'Available'),
(10, 'Sedan', 'Mercedes-Benz C-Class', 'Gray', 'Available'),
(11, 'SUV', 'Ford Explorer', 'Red', 'Available'),
(12, 'Truck', 'Chevrolet Silverado', 'Blue', 'Sold'),
(13, 'Sedan', 'Audi A4', 'Black', 'Available'),
(14, 'SUV', 'Jeep Grand Cherokee', 'White', 'Available'),
(15, 'Truck', 'GMC Sierra', 'Gray', 'Sold'),
(16, 'Sedan', 'Lexus ES', 'Red', 'Available'),
(17, 'SUV', 'Toyota Highlander', 'Blue', 'Available'),
(18, 'Truck', 'Nissan Titan', 'Black', 'Sold'),
(19, 'Sedan', 'Honda Accord', 'White', 'Available'),
(20, 'SUV', 'Mazda CX-5', 'Gray', 'Available');

-- Inserting records into Services table
INSERT INTO Services (serviceID, customarID, carID, ServiceDescription) VALUES
(1, 1, 1, 'Oil Change'),
(2, 2, 2, 'Tire Rotation'),
(3, 3, 3, 'Brake Inspection'),
(4, 4, 4, 'Battery Replacement'),
(5, 5, 5, 'Engine Tune-Up'),
(6, 6, 6, 'Transmission Service'),
(7, 7, 7, 'Wheel Alignment'),
(8, 8, 8, 'Air Filter Replacement'),
(9, 9, 9, 'Coolant Flush'),
(10, 10, 10, 'Fuel System Cleaning'),
(11, 11, 11, 'Spark Plug Replacement'),
(12, 12, 12, 'Suspension Inspection'),
(13, 13, 13, 'Timing Belt Replacement'),
(14, 14, 14, 'Exhaust System Repair'),
(15, 15, 15, 'AC Service'),
(16, 16, 16, 'Brake Fluid Flush'),
(17, 17, 17, 'Steering System Inspection'),
(18, 18, 18, 'Tire Replacement'),
(19, 19, 19, 'Clutch Repair'),
(20, 20, 20, 'Headlight Replacement');

-- Inserting records into Employees table
INSERT INTO Employees (employeeID, employeeName, salary, dateOfEmployment) VALUES
(1, 'Michael Johnson', 5000.123, '2020-01-15'),
(2, 'Sarah Williams', 5200.456, '2019-03-20'),
(3, 'David Brown', 5400.789, '2018-07-10'),
(4, 'Emily Davis', 5600.321, '2021-05-05'),
(5, 'Daniel Miller', 5800.654, '2017-11-25'),
(6, 'Sophia Wilson', 6000.987, '2020-09-30'),
(7, 'James Moore', 6200.123, '2019-02-18'),
(8, 'Olivia Taylor', 6400.456, '2018-06-22'),
(9, 'Benjamin Anderson', 6600.789, '2021-04-17'),
(10, 'Mia Thomas', 6800.321, '2017-08-12'),
(11, 'Alexander Jackson', 7000.654, '2020-12-28'),
(12, 'Amelia White', 7200.987, '2019-05-09'),
(13, 'William Harris', 7400.123, '2018-10-14'),
(14, 'Ella Martin', 7600.456, '2021-02-27'),
(15, 'Henry Thompson', 7800.789, '2017-07-06'),
(16, 'Isabella Garcia', 8000.321, '2020-11-19'),
(17, 'Jackson Martinez', 8200.654, '2019-03-15'),
(18, 'Charlotte Rodriguez', 8400.987, '2018-09-26'),
(19, 'Lucas Clark', 8600.123, '2021-01-23'),
(20, 'Ava Lewis', 8800.456, '2017-06-08');

-- Inserting records into Advertisers table
INSERT INTO Advertisers (employeeID, points) VALUES
(1, 100),
(2, 200),
(3, 300),
(4, 400),
(5, 500);

-- Inserting records into Managers table
INSERT INTO Managers (employeeID, MonthlyReport) VALUES
(16, 'Monthly report 1'),
(17, 'Monthly report 2'),
(18, 'Monthly report 3'),
(19, 'Monthly report 4'),
(20, 'Monthly report 5');

-- Inserting records into Salesmans table
INSERT INTO Salesmans (employeeID, employeeTarget) VALUES
(6, 60),
(7, 70),
(8, 80),
(9, 90),
(10, 100),
(11, 110),
(12, 120),
(13, 130),
(14, 140),
(15, 150);

-- Inserting records into Sales table
INSERT INTO Sales (saleID, saleDescription, customarID, carID, employeeID) VALUES
(1, 'Sale description 1', 1, 1, 6),
(2, 'Sale description 2', 2, 2, 7),
(3, 'Sale description 3', 3, 3, 8),
(4, 'Sale description 4', 4, 4, 9),
(5, 'Sale description 5', 5, 5, 10),
(6, 'Sale description 6', 6, 6, 11),
(7, 'Sale description 7', 7, 7, 12),
(8, 'Sale description 8', 8, 8, 13),
(9, 'Sale description 9', 9, 9, 14),
(10, 'Sale description 10', 10, 10, 15),
(11, 'Sale description 11', 11, 11, 6),
(12, 'Sale description 12', 12, 12, 7),
(13, 'Sale description 13', 13, 13, 8),
(14, 'Sale description 14', 14, 14, 9),
(15, 'Sale description 15', 15, 15, 10),
(16, 'Sale description 16', 16, 16, 11),
(17, 'Sale description 17', 17, 17, 12),
(18, 'Sale description 18', 18, 18, 13),
(19, 'Sale description 19', 19, 19, 14),
(20, 'Sale description 20', 20, 20, 15);

-- Inserting records into Cashs table
INSERT INTO Cashs (saleID, processNumber, bankCash, directCash, discounts) VALUES
(1, 1001, 5000.123, 1000.123, 5.0),
(2, 1002, 5200.456, 1200.456, 4.5),
(3, 1003, 5400.789, 1400.789, 4.0),
(4, 1004, 5600.321, 1600.321, 3.5),
(5, 1005, 5800.654, 1800.654, 3.0),
(6, 1006, 6000.987, 2000.987, 2.5),
(7, 1007, 6200.123, 2200.123, 2.0),
(8, 1008, 6400.456, 2400.456, 1.5),
(9, 1009, 6600.789, 2600.789, 1.0),
(10, 1010, 6800.321, 2800.321, 0.5);

-- Inserting records into InstallmentPayments table
INSERT INTO InstallmentPayments (saleID, processNumber, totalCost, firstPayment, monthlyInstallment, NumberOfMonths) VALUES
(11, 2011, 14000.654, 6000.654, 1400.654, 10),
(12, 2012, 14400.987, 6400.987, 1440.987, 10),
(13, 2013, 14800.123, 6800.123, 1480.123, 10),
(14, 2014, 15200.456, 7200.456, 1520.456, 10),
(15, 2015, 15600.789, 7600.789, 1560.789, 10),
(16, 2016, 16000.321, 8000.321, 1600.321, 10),
(17, 2017, 16400.654, 8400.654, 1640.654, 10),
(18, 2018, 16800.987, 8800.987, 1680.987, 10),
(19, 2019, 17200.123, 9200.123, 1720.123, 10),
(20, 2020, 17600.456, 9600.456, 1760.456, 10);
