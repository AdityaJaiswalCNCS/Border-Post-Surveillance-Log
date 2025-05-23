CREATE DATABASE border_security;

USE border_security;

CREATE TABLE logs (
    LOG_ID INT AUTO_INCREMENT PRIMARY KEY,
    POST_NAME VARCHAR(255) NOT NULL,
    INCIDENT_TIME DATETIME NOT NULL,
    DESCRIPTION TEXT NOT NULL,
    OFFICER_NAME VARCHAR(255),
    OFFICER_ID VARCHAR(255),
    LOCATION VARCHAR(255),
    WEATHER_CONDITION VARCHAR(100),
    WITNESS_NAME VARCHAR(255),
    VEHICLE_NUMBER VARCHAR(100),
    VEHICLE_ID VARCHAR(100)
);