-- 1. Tạo database và sử dụng
DROP DATABASE IF EXISTS CinemaManagementSystem;
CREATE DATABASE CinemaManagementSystem;
USE CinemaManagementSystem;

-- 2. Các bảng cơ bản
CREATE TABLE Movie (
    Mov_ID CHAR(10) PRIMARY KEY,            -- Mã phim
    Mov_title VARCHAR(50),                  -- Tên phim
    Mov_genre VARCHAR(20),                  -- Thể loại phim
    Mov_director VARCHAR(50),               -- Đạo diễn
    Mov_duration INT,                       -- Thời lượng
    Mov_status VARCHAR(20)                  -- Trạng thái
) ENGINE=InnoDB;

CREATE TABLE Theater (
    Theater_ID CHAR(10) PRIMARY KEY,        -- Mã phòng
    Theater_name VARCHAR(50),               -- Tên phòng
    Seat_total INT                          -- Số lượng ghế
) ENGINE=InnoDB;

CREATE TABLE Showtime (
    Show_ID CHAR(10) PRIMARY KEY,           -- Mã suất chiếu
    Mov_ID CHAR(10),                        -- Mã phim
    Theater_ID CHAR(10),                    -- Mã phòng
    Show_date DATETIME,                     -- Ngày chiếu
    Start_time DATETIME,                    -- Bắt đầu
    End_time DATETIME,                      -- Kết thúc
    Show_price DECIMAL(10,2),               -- Giá
    FOREIGN KEY (Mov_ID) REFERENCES Movie(Mov_ID)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Theater_ID) REFERENCES Theater(Theater_ID)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Seat (
    Seat_ID CHAR(10) PRIMARY KEY,
    Theater_ID CHAR(10),
    Seat_row CHAR(5),
    Seat_column INT,
    Seat_type CHAR(10),
    Available BOOLEAN,
    FOREIGN KEY (Theater_ID) REFERENCES Theater(Theater_ID)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Customer (
    Cus_ID INT AUTO_INCREMENT PRIMARY KEY,
    Cus_name VARCHAR(50),
    Cus_phone VARCHAR(15),
    Cus_email VARCHAR(50),
    Cus_point INT
) ENGINE=InnoDB;

CREATE TABLE Employee (
    Emp_ID CHAR(10) PRIMARY KEY,
    Emp_name VARCHAR(50),
    Emp_email VARCHAR(50),
    Emp_role VARCHAR(20),
    Emp_username VARCHAR(50),
    Emp_password VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE Service (
    Service_ID CHAR(10) PRIMARY KEY,
    Service_name VARCHAR(50),
    Service_price DECIMAL(10,2)
) ENGINE=InnoDB;

CREATE TABLE Invoice (
    Inv_ID CHAR(10) PRIMARY KEY,
    Cus_ID INT,
    Inv_date DATETIME,
    Inv_total DECIMAL(10,2),
    FOREIGN KEY (Cus_ID) REFERENCES Customer(Cus_ID)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Ticket (
    Ticket_ID CHAR(10) PRIMARY KEY,
    Show_ID CHAR(10),
    Seat_ID CHAR(10),
    Cus_ID INT,
    Inv_ID CHAR(10),
    Ticket_price DECIMAL(10,2),
    FOREIGN KEY (Show_ID) REFERENCES Showtime(Show_ID)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Seat_ID) REFERENCES Seat(Seat_ID)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Cus_ID) REFERENCES Customer(Cus_ID)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Inv_ID) REFERENCES Invoice(Inv_ID)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE ServiceLine (
    Inv_ID CHAR(10) NOT NULL,
    Service_ID CHAR(10) NOT NULL,
    Service_price DECIMAL(10,2),
    Quantity INT,
    Total DECIMAL(10,2),
    PRIMARY KEY (Inv_ID, Service_ID),
    FOREIGN KEY (Inv_ID) REFERENCES Invoice(Inv_ID)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Service_ID) REFERENCES Service(Service_ID)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;
