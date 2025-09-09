/*
    <JOIN>
    두개 이상의 테이블에서 데이터를 조회하고자할 떄 사용되는 구문
    조회 결과는 하나의 결과 (RESULT SET)을 반환한다.
    
    관계형 데이터베이스에서는 최소한의 데이터를 각각의 테이블에 담고 있음
    (무작정 다 조회해 오는 것이 아니라 각 테이블 간 연결고리(외래키)를 통해 데이터를 매칭시켜 조회)
    
    JOIN은 "오라클 전용구문" "ANSI 구문"으로 나뉨
*/

--전체 사원들의 사번, 사원명, 부서코드, 부서명
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;

/*
    1.내부조인(INNER JOIN) / 등가조인 (EQUAL JOIN)
    연결시키는 컬럼의 값이 일치하는 행들만 조회
    
    2.
*/

--> 오라클 전용구문
--FROM절에 조회하고자하는 테이블을 나열 (, 구분)
--WHERE절에 매칭시킬 컬럼에 대한 조건을 제시
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

--> ANSI구문
--FROM절에 기준이 되는 테이블 하나만 기술한다.
--JOIN절에 같이 조인하고자하는 테이블을 기술 + 매칭시킬 컬럼에 대한 조건
-- [INNER] JOIN [USING/ON]
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

--1. 연결할 두 컬럼명이 다른 경우 JOIN ON을 사용해서 연결할 컬럼명을 명시
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--2 연결할 두 컬럼명이 동일한 경우
--전체 사원들의 사번, 사원명, 직급코드, 직급명
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE, J.JOB_CODE
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);
--JOIN JOB USING(JOB_CODE);

--직급이 대리인 사원의 사번, 사원명, 직급명, 급여조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';

SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;
SELECT * FROM JOB;

--1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회
SELECT EMP_ID, EMP_NAME, NVL(BONUS,0)
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
WHERE D.DEPT_TITLE = '인사관리부';

--2. 부서와 지역 테이블을 참고하여 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회
SELECT D.DEPT_ID, D.DEPT_TITLE, L.LOCAL_CODE, L.LOCAL_NAME
FROM DEPARTMENT D
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE;

--3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명을 조회
SELECT E.EMP_ID, E.EMP_NAME, E.BONUS, D.DEPT_TITLE
FROM DEPARTMENT D
JOIN EMPLOYEE E ON D.DEPT_ID = E.DEPT_CODE
WHERE BONUS IS NOT NULL;

--4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회
SELECT E.EMP_NAME, E.SALARY
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
WHERE NOT D.DEPT_TITLE = '총무부';

-------------------------------------------------------------
/*
    2.외부조인(OUTER JOIN) /포괄조인
    두 테이블 간의 JOIN시 일치하지 않는 행도 포함시켜 조회 가능
    단, 반드시 LEFT/RIGHT를 지정해야된다. (어떤 테이블을 기준으로 할것인가)
*/
--외부조인과 비교할만한 내부조인
--사원명, 부서명, 급여, 연봉
--부서배치를 받지 않은 2명의 사원정보는 어떻게 되는가?
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--INNER JOIN 종종 데이터가 누락될 수 있어서 실무에선 LEFT JOIN을 많이 사용함
--1) LEFT [OUTER] JOIN : 두 테이블 중 왼편에 기술된 테이블을 기준으로 JOIN
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--2) RIGHT [OUTER] JOIN : 두 테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--FULL [OUTER] JOIN : 두 테이블이 가진 모든행을 조회할 수 있다. (잘 사용 X)
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

/*
    3. 비등가 조인
    매칭시킬 컬럼에 대한 조건 작성시 '='을 사용하지 않는 조인문
    
    범위(수치적 범위, 기간적 범위)를 기반으로 조인을 구현할 때 사용
*/                                  
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY >= MIN_SAL AND SALARY <= MAX_SAL);

/*
    4. 자체조인(SELF JOIN)
    같은 테이블을 다시 한번 조인하는 경우
    -하나의 테이블에서 서로 다른 두개의 행을 비교해야하는 경우 사용
    -동일한 테이블을 조인하는 것이기 때문에 별칭을 사용해서 구분해야한다.
*/

--전체 사원의 사원사번, 사원명, 사원부서코드 --EMPLOYEE
--            사수사번, 사수명, 사수부서코드 --EMPLOYEE
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE,
        M.EMP_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID);

/*
    <다중조인>
    2개 이상의 테이블을 가지고 JOIN 할 수 있음
*/

--사번, 사원명, 부서명, 직급명
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

--사번, 사원명, 부서명, 지역명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE 
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

--사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME,
        NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);
------------------------------------------------------------
/*
    내출럴 조인 (NATURAL JOIN)
    두 테이블 간에 공통된 컬럼이름을 기준으로 정해서 자동으로 조인하는 방식
    ON이나 USING 조건을 지정하지 않아도 두 테이블 간의 공통된 컬럼을 기반으로 조인
    
    동일한 컬럼명이 각 테이블에 존재하는 경우에만 정상적인 조인 가능하다.
*/

SELECT * 
FROM EMPLOYEE
--JOIN JOB USING(JOB_CODE);
NATURAL JOIN JOB;
--가독성이 많이 떨어짐
--ERROR시 소프트웨어가 잡아주지 않는 오류가 가장 안좋음

/*
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
*/
-- 1. 70년대 생(1970~1979) 중 여자이면서 전씨인 사원의 이름과 주민번호, 부서 명, 직급 조회 
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE SUBSTR(EMP_NO,1,2)BETWEEN 70 AND 79
    AND SUBSTR(EMP_NO, 8, 1) IN ('2','4')
    AND EMP_NAME LIKE '전%';

-- 2. 이름에 ‘형’이 들어가는 사원의 사원 코드, 사원 명, 직급 조회 
SELECT EMP_ID, EMP_NAME, DEPT_ID
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE EMP_NAME LIKE '%형%';
-- 3. 부서코드가 D5이거나 D6인 사원의 사원 명, 직급 명, 부서 코드, 부서 명 조회  
SELECT EMP_NAME, JOB_CODE, DEPT_ID, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE DEPT_CODE IN ('D6','D5');
-- 4. 보너스를 받는 사원의 사원 명, 부서 명, 지역 명 조회  
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
WHERE BONUS IS NOT NULL;
--방식2)
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE BONUS IS NOT NULL;

-- 5. 사원 명, 직급 명, 부서 명, 지역 명 조회  
SELECT EMP_NAME,JOB_CODE, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
LEFT JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
JOIN JOB USING(JOB_CODE);

-- 6. 한국이나 일본에서 근무 중인 사원의 사원 명, 부서 명, 지역 명, 국가 명 조회
SELECT EMP_NAME,JOB_CODE, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
JOIN JOB USING(JOB_CODE)
WHERE NATIONAL_CODE IN ('KO', 'JP');
-- 7. 한명의 사원과 같은 부서에서 일하는 사원의 이름 조회 (자체조인 활용)  
--    같은 부서에서 일하는 다른 사원의 이름을 조회하시오.  
--    단, 모든 사원이 자신의 부서에서 함께 일하는 다른 사원의 이름을 확인할 수 있어야 합니다.  
--    (예: 사원 A가 속한 부서에서 다른 사원 B의 이름을 조회)  
SELECT A.EMP_NAME, B.EMP_NAME
FROM EMPLOYEE A
JOIN EMPLOYEE B ON (A.DEPT_CODE = B.DEPT_CODE)
WHERE A.EMP_ID != B.EMP_ID
ORDER BY A.EMP_ID;

-- 8. 보너스가 없고 직급 코드가 J4이거나 J7인 사원의 이름, 직급 명, 급여 조회 (NVL 이용) 
SELECT EMP_NAME,JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE NVL(BONUS, 0) = 0 AND JOB_CODE IN ('J4', 'J7') AND BONUS IS NULL;

-- 9. 부서 명과 부서 별 급여 합계 조회  
SELECT DEPT_TITLE, SUM(SALARY) AS "부서 별 급여"
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
GROUP BY DEPT_TITLE;

-- 10. 부서 별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서 명, 부서 별 급여 합계 조회  
SELECT DEPT_TITLE, SUM(SALARY) AS "부서 별 급여"
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY)* 0.2 FROM EMPLOYEE);

-- 11. 나이 상 가장 막내의 사원 코드, 사원 명, 나이, 부서 명, 직급 명 조회  
SELECT EMP_ID, 
    EMP_NAME, 
    FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12) AS "나이", 
    DEPT_TITLE, 
    JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12) = (
        SELECT MIN(FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12))
        FROM EMPLOYEE
);

--ORDER BY "나이(만)"
--FETCH FIRST 1 ROWS ONLY;

--나이 구하기
SELECT MIN(FLOOR((SYSDATE - TO_DATE(SUBSTR(EMP_NO, 1, 6),'RRMMDD'))/365))  AS "막내"
FROM EMPLOYEE;

SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE())
-- 11. 나이 상 가장 막내의 사원 코드, 사원 명, 나이, 부서 명, 직급 명 조회  
SELECT EMP_ID, 
    EMP_NAME, 
    FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12) AS "나이", 
    DEPT_TITLE, 
    JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12) = (
       SELECT MIN(FLOOR((SYSDATE - TO_DATE(SUBSTR(EMP_NO, 1, 6),'RRMMDD'))/365))  AS "막내"
        FROM EMPLOYEE
);
