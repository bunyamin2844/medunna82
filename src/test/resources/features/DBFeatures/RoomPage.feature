@DBTestRoom
Feature: DB RoomPage tests
Scenario:bir seyler

Given user connects to the databases

And user get the "room_number" from "room" table

And verify "room" table "room_number" column contain " 25" data

Then closes the databases connections


