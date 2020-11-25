CREATE TABLE department(
dep VARCHAR(15)
)

ALTER TABLE department ADD CONSTRAINT pk_department_dep PRIMARY KEY(dep)

INSERT INTO department VALUES ("홍보부")
INSERT INTO department VALUES ("인사부")
INSERT INTO department VALUES ("영업부")
INSERT INTO department VALUES ("행정실")
INSERT INTO department VALUES ("경영지원실")
INSERT INTO department VALUES ("비서실")

CREATE TABLE employee(
eid VARCHAR(6),
ename VARCHAR(12),
dep VARCHAR(12),
telNum INTEGER(12),
gread VARCHAR(12),
birth DATE
)

SELECT * FROM employee

ALTER TABLE employee ADD CONSTRAINT pk_employee_eid PRIMARY KEY(eid)

ALTER TABLE employee ADD CONSTRAINT fk_employee_dep FOREIGN KEY(dep) REFERENCES department(dep)
