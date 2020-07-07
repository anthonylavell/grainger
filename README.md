# Airport information

## Table of contents
* [General info](#general-info)
* [Endpoints](#endpoints)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is simple spring boot application that will return the distance in miles between to airports using their airport codes (IATA code or ICAO code). Using either IATA or ICAO code will retrieve airport information. The airport information is store in an embedded db (H2). Airport that are not define in the db will return error message. Distances between airports was calculate using haversine formula. Testing data and endpoint is done using Postman

## Endpoints
Application has two sets of controllers.
* [RestController](#restcontroller)
* [Controller](#restcontroller)

## RestController
RestController will get data in json format.

## Controller
Controller will get data then render it into a website page.

## Technologies
Project is created with:
* Maven: 3.6.3
* Spring Boot: 2.3.1
* Java: 14
	
## Setup
To run this project, install it locally using maven
