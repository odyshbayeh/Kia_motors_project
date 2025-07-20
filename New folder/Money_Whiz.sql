create database MoneyWhiz;
drop database moneywhiz;
use MoneyWhiz;
-- drop database moneywhiz;
-- Users
CREATE TABLE UserTable (
    TeenID INT PRIMARY KEY AUTO_INCREMENT,
    ParentID INT,
    AdminID INT,
    Username VARCHAR(100) NOT NULL,
    passwordHashed VARCHAR(255) NOT NULL,
    UserRank ENUM('admin', 'parent', 'teen') NOT NULL,
    UserSub ENUM('prime','free') NOT NULL,
    email VARCHAR(100),
    DateOfBirth DATE,
    phone VARCHAR(15),
    FOREIGN KEY (ParentID) REFERENCES UserTable(TeenID),
    FOREIGN KEY (AdminID) REFERENCES UserTable(TeenID)
);
-- budgets
CREATE TABLE Budgets (
    BudgetID INT PRIMARY KEY AUTO_INCREMENT,
    TeenID INT NOT NULL,
    BudgetFor VARCHAR(255),
    nameOFBudget VARCHAR(100),
    amount int,
    start_date DATE,
    FOREIGN KEY (TeenID) REFERENCES UserTable(TeenID)
);
-- goals
CREATE TABLE Goals (
    goalID INT PRIMARY KEY AUTO_INCREMENT,
    BudgetID INT NOT NULL,
    nameOfgoal VARCHAR(100),
    details varchar(100),
    startdate DATE,
    recurrence ENUM('one-time','daily', 'weekly', 'monthly', 'yearly'),
    FOREIGN KEY (BudgetID) REFERENCES Budgets(BudgetID)
);
-- transactions
CREATE TABLE Transactions (
    transactionID INT PRIMARY KEY AUTO_INCREMENT,
    BudgetID INT NOT NULL,
    amount DECIMAL(10, 2),
    recurrence ENUM('one-time', 'daily', 'weekly', 'monthly','yearly'),
    startdate DATE,
    notes varchar(100),
    FOREIGN KEY (BudgetID) REFERENCES Budgets(BudgetID)
);
-- workshops
CREATE TABLE WorkshopTable (
    workshopID INT PRIMARY KEY AUTO_INCREMENT,
    AdminID INT NOT NULL,
    title VARCHAR(255),
    duration INT,
    dateofbeginning DATE,
    dateofend DATE,
    FOREIGN KEY (AdminID) REFERENCES UserTable(TeenID)
);
-- progress
CREATE TABLE Progress (
    challengeID INT PRIMARY KEY AUTO_INCREMENT,
    lessonid INT,
    workshopID INT,
    BudgetID INT,
    GoalID INT,
    title VARCHAR(255),
    LessonEnded BOOLEAN,
    ChallengeEnded BOOLEAN,
    GoalEnded boolean,
    typeToTrack ENUM('workshop', 'lesson', 'challenge','Goal','Budgets'),
    instructions TEXT,
    FOREIGN KEY (lessonid) REFERENCES LessonsTable(lessonid),
    FOREIGN KEY (workshopID) REFERENCES WorkshopTable(workshopID),
    FOREIGN KEY (BudgetID) REFERENCES Budgets(BudgetID),
    FOREIGN KEY (GoalID) REFERENCES Goals(goalID)
);
-- lessons
CREATE TABLE LessonsTable (
    lessonid INT PRIMARY KEY AUTO_INCREMENT,
    workshopID INT NOT NULL,
    AdminID INT NOT NULL,
    title VARCHAR(255),
    Lessonstatus ENUM('not_started', 'in_progress', 'completed'),
    content TEXT,
    duration INT,
    OrderInWorkshop INT,
    FOREIGN KEY (workshopID) REFERENCES WorkshopTable(workshopID),
    FOREIGN KEY (AdminID) REFERENCES UserTable(TeenID)
);
-- challenge
CREATE TABLE Challenge (
    challengeID INT PRIMARY KEY AUTO_INCREMENT,
    workshopID INT NOT NULL,
    AdminID INT NOT NULL,
    title VARCHAR(255),
    typeOfChallenge ENUM('physical', 'math', 'financial'),
    instructions TEXT,
    FOREIGN KEY (workshopID) REFERENCES WorkshopTable(workshopID),
    FOREIGN KEY (AdminID) REFERENCES UserTable(TeenID)
);
-- questions
CREATE TABLE Questions (
    QuestionID INT PRIMARY KEY AUTO_INCREMENT,
    nameOfQuestion VARCHAR(255),
    Details TEXT,
    StatusOfQuestion boolean,
    Entrypassword VARCHAR(255)
);




