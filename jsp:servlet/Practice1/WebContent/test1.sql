CREATE table t1(
	id VARCHAR2(6) PRIMARY KEY,
	name VARCHAR2(15) NOT NULL,
	age NUMBER CHECK(age<200)
)

SELECT * FROM T1


