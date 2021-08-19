# Getting started
This is a project that rendering a list of validated phone numbers for customers per phone code and country

#Prerequisites
All src needed to run a spring boot application like jdk,maven 
Npm and Yarn installation
Docker container to be started

##Running the project
-Start Docker 
-open on cmd from project path root
-type in cmd > docker run -t -p 9090:8080
-open cmd from project path root ./src/main/front-end
-type in cmd > npm start

Services Implemented you can test using the following URL

Getting All customers
http://localhost:8080/International-Phone-Number/customerData/all

Getting Customers by country
http://localhost:8080/International-Phone-Number/customerData/findByCountry?country=Morocco

Getting customers per State
http://localhost:8080/International-Phone-Number/customerData/findByState?state=0

Validate All customers phones state and update database
http://localhost:8080/International-Phone-Number/customerData/validatePhonesState


#Running Test classes
We have two test classes 

Controller
com.example.phoneNumbers.restapi.controller.CustomerDataControllerTest

Service
com.example.phoneNumbers.services.CustomerDataServiceTest


#Pagination
code of paging is implemented in back end in service

Get Customers per page number and page size
http://localhost:8080/International-Phone-Number/customerData/allPages?pageNo=1&pageSize=4


#React
what we have in react is a presentation for data per pages ,however I couldn't finish the data filter in time.
I left classes I was trying in for you to take a look on the work.

class has the filter trial is
src/main/front-end/src/components/BasicTableComponent.js

class that render the list by pages is
src/main/front-end/src/components/CustomerComponent.js











