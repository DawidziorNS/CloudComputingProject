#------------------------------------------
#--- Author: Pradeep Singh
#--- Date: 20th January 2017
#--- Version: 1.0
#--- Python Ver: 2.7
#--- Details At: https://iotbytes.wordpress.com/store-mqtt-data-from-sensors-into-sql-database/
#------------------------------------------


from pymongo import MongoClient
from bson.objectid import ObjectId
import pymongo
import json

client = MongoClient(
	'mongodb+srv://kasucjusz:bartekdawid@cloudcomputingclass.flxo2.mongodb.net/<dbname>?retryWrites=true&w=majority')

db = client.mqtt

tempSensors = db['sensors'].find({'topic': 'Temperature'})


def tempHandler(jsonData):
	json_Dict = json.loads(jsonData)
	SensorID = json_Dict['Sensor_ID']
	Data_and_Time = json_Dict['Date']
	Temperature = json_Dict['Temperature']
	toSave = {"sensorId": SensorID,
			  "date": Data_and_Time, "temp": Temperature}

	db.temperature.insert_one(toSave)


def humHandler(jsonData):
	json_Dict = json.loads(jsonData)
	SensorID = json_Dict['Sensor_ID']
	Data_and_Time = json_Dict['Date']
	Humidity = json_Dict['Humidity']
	toSave = {"sensorId": SensorID,
			  "date": Data_and_Time, "humidity": Humidity}

	db.humidity.insert_one(toSave)


def acidityHandler(jsonData):
	json_Dict = json.loads(jsonData)
	SensorID = json_Dict['Sensor_ID']
	Data_and_Time = json_Dict['Date']
	Acidity = json_Dict['Acidity']
	toSave = {"sensorId": SensorID,
			  "date": Data_and_Time, "acidity": Acidity}

	db.acidity.insert_one(toSave)


def sensor_Data_Handler(Topic, jsonData):
	if Topic == "Home/BartekDawid/Temperature":
		tempHandler(jsonData)
	elif Topic == "Home/BartekDawid/Humidity":
		humHandler(jsonData)
	elif Topic == "Home/BartekDawid/Acidity":
		acidityHandler(jsonData)