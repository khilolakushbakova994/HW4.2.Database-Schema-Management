CREATE TABLE Persons
(
id REAL  PRIMARY KEY,
car_id REAL REFERENCES cars (id),
name TEXT,
age INTEGER,
licence BOOLEAN);


CREATE TABLE Cars
(
car_id REAL PRIMARY KEY,
brand TEXT,
model TEXT,
price MONEY );

CREATE TABLE PersonsCars
(
car_id REAL REFERENCES Cars (id),
person_id REAL  REFERENCES Persons (id)
);


