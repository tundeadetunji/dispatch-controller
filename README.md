# dispatch-controller
Java Coding Assignment


##Overview:

###Major Technologies:

..* Maven project WITH Spring Boot WITH Jersey (for JSON) WITH H2 (for in-memory database)

..* 10 Drones (serials DRONE01 through 10) with varying models are pre-populated in the database

..* 5 Medication items (codes MED01 through 5) with varying weights are pre-populated in the database

..* IDE used was IntelliJ Idea 2021.3.2 (Community Edition)

..* Testing endpoints was with Postman



###Operations:

To register a drone:
POST
http://localhost:8080/api/drones/new

Sample request body:
`{
    "DroneSerial":"DroneSerial",
    "DroneModel":"Heavyweight"
}`
Response:
`{
    "headers": {},
    "body": {
        "id": 11,
        "droneModel": "Heavyweight",
        "droneSerial": "DroneSerial",
        "droneState": "IDLE",
        "droneBatteryCapacity": 100
    },
    "statusCodeValue": 202,
    "statusCode": "ACCEPTED"
}`


To load a drone:
POST
http://localhost:8080/api/drones/load

Sample request body:
`{
    "DroneSerial":"DRONE01",
    "MedicationCode":"MED01",
    "DroneId":1
}`
Response:
`{
    "headers": {},
    "body": {
        "droneModel": "Lightweight",
        "droneSerial": "DRONE01",
        "medicationName": "Med01",
        "medicationCode": "MED01",
        "droneState": "IDLE",
        "droneId": 1,
        "medicationWeight": 500,
        "medicationImageURL": "https://domain.com/path-to-resource-1"
    },
    "statusCodeValue": 202,
    "statusCode": "ACCEPTED"
}`


To check medication items on a drone:
GET
http://localhost:8080/api/drones/check-load

Sample request body:
`{
    "DroneSerial":"DRONE01"
}`
Response:
`{
    "headers": {},
    "body": [
        {
            "droneModel": "Lightweight",
            "droneSerial": "DRONE01",
            "medicationName": "Med01",
            "medicationCode": "MED01",
            "droneState": "IDLE",
            "droneId": 1,
            "medicationWeight": 500,
            "medicationImageURL": "https://domain.com/path-to-resource-1"
        }
    ],
    "statusCodeValue": 202,
    "statusCode": "ACCEPTED"
}`


To check available drones for loading:
GET
http://localhost:8080/api/drones/check-available

Sample response:
`{
    "headers": {},
    "body": [
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Lightweight",
            "droneSerial": "DRONE02"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Lightweight",
            "droneSerial": "DRONE03"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Middleweight",
            "droneSerial": "DRONE04"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Middleweight",
            "droneSerial": "DRONE05"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Middleweight",
            "droneSerial": "DRONE06"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Cruiserweight",
            "droneSerial": "DRONE07"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Cruiserweight",
            "droneSerial": "DRONE08"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Heavyweight",
            "droneSerial": "DRONE09"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Heavyweight",
            "droneSerial": "DRONE10"
        },
        {
            "laidenOrEmpty": "EMPTY",
            "droneModel": "Heavyweight",
            "droneSerial": "DroneSerial"
        },
        {
            "laidenOrEmpty": "LAIDEN",
            "droneModel": "Lightweight",
            "droneSerial": "DRONE01"
        }
    ],
    "statusCodeValue": 202,
    "statusCode": "ACCEPTED"
}`


To check battery level of given drone:
GET
http://localhost:8080/api/drones/check-battery

Sample request body:
`{
    "id":1
}`

Response:
`{
    "headers": {},
    "body": {
        "id": 1,
        "droneModel": "Lightweight",
        "droneSerial": "DRONE01",
        "droneState": "IDLE",
        "droneBatteryCapacity": 100
    },
    "statusCodeValue": 202,
    "statusCode": "ACCEPTED"
}`



###Notes:

..* Battery Levels of all drones are logged every 30 seconds - you can check the database by following the URL:
http://localhost:8080/h2-console
..* Username: sa
..* Password:
..* JDBC URL: jdbc:h2:mem:testdb
..* Driver Class: org.h2.Driver
..* (Please note that the password field should be blank - nothing)
