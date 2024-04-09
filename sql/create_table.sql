use zr_iotproj;

# 每日健康数据
CREATE TABLE health_data_days (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    resident_id INT NOT NULL,
    avg_heart_rate DOUBLE,
    avg_oxygen_level DOUBLE,
    avg_body_temperature DOUBLE,
    time DATETIME
);

# 每小时健康数据
CREATE TABLE health_data_days (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    resident_id INT NOT NULL,
    avg_heart_rate DOUBLE,
    avg_oxygen_level DOUBLE,
    avg_body_temperature DOUBLE,
    time DATETIME
);

# 每分钟健康数据
CREATE TABLE health_data_days (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    resident_id INT NOT NULL,
    avg_heart_rate DOUBLE,
    avg_oxygen_level DOUBLE,
    avg_body_temperature DOUBLE,
    time DATETIME
);

# 每秒钟健康数据
CREATE TABLE health_data_days (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    resident_id INT NOT NULL,
    heart_rate DOUBLE,
    oxygen_level DOUBLE,
    body_temperature DOUBLE,
    time DATETIME
);

# family_members_mobiles
CREATE TABLE members (
    member_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    resident_id INT NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    relation VARCHAR(255),
    phone VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

# medical_staff
CREATE TABLE medical_staff (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(20)
);

# resident_exception_history
CREATE TABLE resident_exception_history (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    resident_id INT,
    exception_start_time DATETIME,
    exception_info VARCHAR(255),
    exception_end_time DATETIME
);

CREATE TABLE residents (
    resident_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    national_id VARCHAR(20) NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    date_of_birth DATE NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    emergency_contact_name VARCHAR(255),
    emergency_contact_phone VARCHAR(20),
    room_number VARCHAR(50) NOT NULL,
    admission_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    notes TEXT,
    staff_id INT,
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);


CREATE TABLE staff_evaluation (
    staff_id INT,
    resident_id INT,
    star DOUBLE,
    comment VARCHAR(255)
);