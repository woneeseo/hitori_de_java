CREATE TABLE depart(
dep VARCHAR(3)
)

ALTER TABLE depart ADD CONSTRAINT pk_depart_dep PRIMARY KEY(dep)


INSERT INTO depart VALUES ('a')
INSERT INTO depart VALUES ('b')
INSERT INTO depart VALUES ('c')
INSERT INTO depart VALUES ('d')
INSERT INTO depart VALUES ('e')


CREATE TABLE employee(
id VARCHAR(8),
name VARCHAR(15),
dep VARCHAR(3),
tel INTEGER(11)
)


ALTER TABLE employee ADD CONSTRAINT pk_attend_id PRIMARY KEY(id)

ALTER TABLE employee ADD CONSTRAINT fk_employee_dep FOREIGN KEY(dep) REFERENCES depart(dep)

SELECT * FROM employee

CREATE TABLE attend(
id VARCHAR(8),
name VARCHAR(15),
intime DATE,
exittime DATE,
dep VARCHAR(3)
)

ALTER TABLE attend ADD CONSTRAINT pk_attend_id PRIMARY KEY(id)
ALTER TABLE attend ADD CONSTRAINT fk_attend_id FOREIGN KEY(id) REFERENCES employee(id)
ALTER TABLE attend ADD CONSTRAINT fk_attend_dep PRIMARY KEY(dep) REFERENCES depart(dep)

COMMIT

SELECT * FROM attend

INSERT INTO employee VALUES ('m001', 'kim', 'a', 010222333)

DELETE FROM attend 

CREATE TABLE timeTable(
now TIME
)

DROP TABLE timeTable



