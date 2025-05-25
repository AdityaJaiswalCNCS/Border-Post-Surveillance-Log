CREATE DATABASE border_security;

USE border_security;

CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_name VARCHAR(100),
    incident_time DATETIME,
    description TEXT,
    officer_name VARCHAR(100),
    officer_id VARCHAR(50),
    location VARCHAR(200),
    weather_condition VARCHAR(100),
    witness_name VARCHAR(100),
    vehicle_number VARCHAR(50),
    vehicle_id VARCHAR(50),
    FULLTEXT(post_name, description, officer_name, location, weather_condition, witness_name)
);
