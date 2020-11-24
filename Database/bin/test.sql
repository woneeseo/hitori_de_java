CREATE table tbl_test(
name VARCHAR(3),
age INTEGER (3)
)
// Mysql 에서는 NUMBER가 아닌 INTEGER를 써야한다
//*주의 :  SQL은 한줄이 하나의 실행코드 / 여러줄을 블럭으로 해서 실행하려고 하면 에러남 */

INSERT INTO tbl_test VALUES ('kim', 33)

INSERT INTO tbl_test VALUES('lee', 40)

INSERT INTO tbl_test VALUES ('park', 50)

INSERT INTO tbl_test VALUES ('cho' 23)

// 데이터 입력은 INSERT명령어를 사용한다.

SELECT * FROM tbl_test

// tbl_test 에 있는 모든 레코드 호출하기

COMMIT

// 저장

SELECT name FROM tbl_test

// tbl_test에서 name컬럼의 레코드를 모두 호출

SELECT age FROM tbl_test

// tbl_test에서 age컬럼의 레코드를 모두 호출

SELECT name as 이름, age as 나이 FROM tbl_test

// alias : 컬럼에 별명 만들어주기
// 컬럼명 + as + 별칭 또는 컬럼명 + 별칭 또는 두가지 방법을 섞어서 써도 됨

INSERT INTO tbl_test VALUES ('kim', 20)

SELECT distinct name FROM tbl_test

// DISTINCT 키워드로 중복값을 빼고 레코드를 조회할 수 있음

SELECT * FROM tbl_test ORDER BY age ASC

SELECT * FROM tbl_test ORDER BY age desc

// ORDER BY 는 레코드의 정렬을 가능하게 해줌
// ASC는 오름차순으로 DESC는 내림차순으로 정렬함

SELECT * FROM tbl_test ORDER BY name DESC
// 모든 컬럼의 모든 레코드를 조회하되, 이름을 기준으로 내림차순으로 정렬

SELECT * FROM tbl_test ORDER BY name DESC, age ASC
// 모든 컬럼의 모든 레코드를 조회하되, 이름을 기준으로 내림차순으로 정렬하되,
// 이름이 같은 사람들은 나이가 많은 사람이 우선이 되도록 정렬

select * FROM tbl_test WHERE name = 'kim'
// name 이 kim인 사람들의 모든 레코드를 조회하세요
// WHERE을 사용하면 조건을 부여해 조회하는 것이 가능하다.

SELECT * FROM tbl_test WHERE name != 'kim'
//name 이 kim이 아닌 사람들의 모든 레코드를 조회하시오

INSERT INTO tbl_test (age) VALUES (55)

INSERT INTO tbl_test (name) VALUES ('pyo')

SELECT * FROM tbl_test

COMMIT

SELECT * FROM tbl_test WHERE age IS NULL
// age값이 null인 레코드를 모두 조회

SELECT * FROM tbl_test WHERE name IS NULL
// name 값이 null인 레코드를 모두 조회

SELECT * FROM tbl_test WHERE age > 33
// age값이 33보다 큰 age레코드를 모두 조회

SELECT * FROM tbl_test WHERE age = 20 OR age = 23 OR age = 40
// age값이 20이거나 23이거나 40인 레코드를 모두 조회

SELECT * FROM tbl_test WHERE IN age(20, 23, 24, 61, 77)
// age값이 20이거나 23이거나 24이거나 61이거나 77인 레코드를 모두 조회
// 조회할 값이 여러개일 때는 IN()을 이용해서 조건을 부여하면 간결하게 코드를 정리할 수 있다

SELECT * FROM tbl_test WHERE NOT IN age(20, 23, 24, 61, 77)
// age값이 20이거나 23이거나 24이거나 61이거나 77이 아닌 레코드를 모두 조회

SELECT * FROM tbl_test WHERE name = 'kim' AND age = 33
// tbl_test에서 name 이 kim이고 age가 33인 레코드를 조회하시오
 
SELECT * FROM tbl_test WHERE age > 25 AND age <47
// tbl_test 에서 age 값이 25보다 크고 47보다 작은 레코드를 모두 조회하시오

SELECT * FROM tbl_test WHERE age BETWEEN 25 AND 47
// tbl_test 에서 age값이 25 이상 47 이하인 레코드를 모두 조회하시오
// BETWEEN AND 를 사용하면, 아래 AND 만 사용한 코드와 같은 값을 조회한다.
SELECT * FROM tbl_test WHERE age >= 25 AND age <= 47

SELECT * FROM tbl_test WHERE name LIKE '_i_'
// 정확한 name 값은 모르는데, 글자수와 특정 글자가 몇번째 자리에 있는지 알고있을 때 사용

SELECT * FROM tbl_test WHERE name LIKE '%o'
// 정확한 name 값도 모르고, 특정 글자가 몇글자인지도 모르고 끝자리에 o만 있다는 것을 알 때 사용

SELECT * FROM tbl_test WHERE name LIKE '%k%'
// 정확한 name 값도 모르고, 특정 글자가 몇글자인지, 어느 자리에 위치해있는지도 모르는 경우의 레코드를 조회할때 사용



// 기본키 = 주키 = primary_key = pk 를 이용해서 원하는 데이터 뽑아서 조회하기

CREATE TABLE depart(
id VARCHAR(6),
name VARCHAR(6),
age INTEGER(3)
)

SELECT * FROM depart

ALTER TABLE depart ADD CONSTRAINT pk_depart_id PRIMARY KEY(id)

INSERT INTO depart VALUES ('m001', 'kim', 30)
INSERT INTO depart VALUES ('m002', 'kim', 30) --> 중복된ID는 레코드가 입력되지 않는다. : UNIQUE 제약조건
INSERT INTO depart (name, age) VALUES ('kim', 30) --> 기본키로 설정한 칼럼이 null이어서는 안된다. : NULL제약조건
INSERT INTO depart VALUES ('m003', 'kim', 30)
INSERT INTO depart VALUES ('m004', 'kim', 30)
--> 이 코드들을 실행하면, m001, m003, m004의 레코드만 입력 된 것을 확인할 수 있다.

--> 외래키 (foreign key = fk) 
--> 선택지 외의 값을 입력하지 못하도록 제한을 두는 것
--> 외래키를 자식 테이블에서 참조하려면 반드시 외래키가 있는 부모 테이블을 먼저 만들고,
--> 외래키로 쓰고 싶은 컬럼은 반드시 부모테이블의 기본키가 되게 설정한다.
--> 외래키로써 자식 테이블에 참조되는 값는 중복이 가능하며, null값도 가능하다. 

--> 먼저 외래키로 쓸 부모 테이블을 만든다
CREATE TABLE dep(
dep VARCHAR(12)
)
--> 외래키로 쓸 컬럼을 부모테이블의 기본키로 설정한다
ALTER TABLE dep ADD CONSTRAINT pk_dep_dep PRIMARY KEY(dep)

--> 외래키로 쓸 컬럼의 데이터를 입력한다.
--> 입력된 데이터 외의 값은 레코드로 쓸 수 없다 (오류발생 / 테이블에 저장되지 않음)
INSERT INTO dep VALUES ('인사부')
INSERT INTO dep VALUES ('영업부')
INSERT INTO dep VALUES ('연구실')
INSERT INTO dep VALUES ('홍보부')


--> 이제 외래키를 쓸 자식 테이블을 만든다. 
CREATE TABLE employee(
eid VARCHAR(6),
ename VARCHAR(6),
dep VARCHAR(12)
)

ALTER TABLE employee ADD CONSTRAINT pk_employee_eid PRIMARY KEY(eid)

--> 자식 테이블인 employee 에 외래키를 만들어준다.
ALTER TABLE employee ADD CONSTRAINT fk_employee_dep FOREIGN KEY(dep) REFERENCES dep(dep)

--> 이제 자식 테이블에 자료를 입력해본다.
INSERT INTO employee (eid, ename, dep) VALUES ('e001', 'kim','인사부')
INSERT INTO employee (eid, ename, dep) VALUES ('e002', 'lee','홍보부')
INSERT INTO employee (eid, ename, dep) VALUES ('e003', 'park','연구실')
INSERT INTO employee (eid, ename, dep) VALUES ('e004', 'choi','영업부')
INSERT INTO employee (eid, ename) VALUES ('e005', 'choi')--> dep컬럼이 null이지만 데이터 입력 가능
INSERT INTO employee (eid, ename, dep) VALUES ('e006', 'choi','행정부') --> 외래키 레코더에 없는 값을 입력해 테이블에 저장되지 않았다

--> 이 테이블을 실행해보면
SELECT * FROM employee
--> e001, e002, e003, e004까지는 정상적인 값으로,
--> e005는 값을 입력하지 않았기 때문에 null이,
--> e006은 외래키 데이터에 없는 레코드이기 때문에 테이블에 저장되지 않은 것을 확인할 수 있다.

