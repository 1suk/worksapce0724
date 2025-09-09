--관리자계정으로 계정생성
CREATE USER C##KH IDENTIFIED BY KH;

GRANT CONNECT, RESOURCE TO C##KH;

ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS; --KH계정으로 전환

-----------------------------------------------------------------------------------
--테이블을 복제할 수 있다. 여기서부터 KH계정으로 진행함.
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE); 

--CREATE TABLE 테이블명 AS SELECT문
--AS 뒤에오는 SELECT문의 결과를 기반으로 테이블을 생성하겠다.

DROP TABLE EMPLOYEE_COPY;

CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE WHERE 1=0);

SELECT * FROM EMPLOYEE_COPY;

-------------------------------------------------------------
/*
    테이블이 생성된 후에 제약조건을 수정하는 방법
    ALTER TABLE 테이블명 변경할 내용
    
    -PRIMARY KEY : ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명);
    -FOREIGN KEY :  ALTER TABLE 테이블명 ADD FOREIGN KEY(컬러명) REFERENCES 참조할테이블명(컬럼명);
    -UNIQUE : ALTER TABLE 테이블명 ADD UNIQUE(컬럼명);
    -CHECK : ALTER TABLE 테이블명 ADD CHECK(컬럼에 대한 조건식)
    
    위의 제약조건을 제거하려면
    -ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건이름;
    
    -NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
                ALTER TABLE 테이블명 MODIFY 컬럼명 NULL;
    
*/
--EMPLOYEE_COPY 테이블에 PRIMARY_KEY 제약조건 추가(EMP_ID)
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);

--EMPLOYEE 테이블에 DEPT_CODE에 외래키제약조건을 추가(DEPT_ID를 참조)
ALTER TABLE EMPLOYEE ADD CONSTRAINT DEPT_FK FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID); 

