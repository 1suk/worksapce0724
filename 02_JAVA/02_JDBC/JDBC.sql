CREATE TABLE TEAMS(
    team_id INT PRIMARY KEY,
    teamName VARCHAR2(30) NOT NULL,
    win NUMBER DEFAULT 0,
    draw NUMBER DEFAULT 0,
    lose NUMBER DEFAULT 0,
    totalScore NUMBER DEFAULT 0
);

DROP TABLE TEAMS;

CREATE SEQUENCE SEQ_TEAMNO;
DROP SEQUENCE SEQ_TEAMNO;

CREATE TABLE matches(
    match_id INT PRIMARY KEY,
    teamA VARCHAR(30) NOT NULL,
    teamB VARCHAR(30) NOT NULL,
    match_date DATE NOT NULL,
    result VARCHAR2(10) DEFAULT 'draw' NOT NULL
);

DROP TABLE matches;

CREATE SEQUENCE SEQ_MATCHNO;
DROP SEQUENCE SEQ_MATCHNO;

CREATE TABLE members(
    user_no INT PRIMARY KEY,
    userId VARCHAR2(30) NOT NULL,
    userPwd VARCHAR2(30) NOT NULL,
    userName VARCHAR2(20) NOT NULL,
    myTeam VARCHAR2(30)
);

CREATE SEQUENCE SEQ_USERNO;
DROP SEQUENCE SEQ_USERNO;

DROP TABLE members;

INSERT INTO teams(team_id, teamName, win, draw, lose, totalScore)
VALUES (SEQ_TEAMNO.NEXTVAL, '수원삼성', 0, 0, 0, 0);

INSERT INTO teams(team_id, teamName, win, draw, lose, totalScore)
VALUES (SEQ_TEAMNO.NEXTVAL, 'FC서울', 0, 0, 0, 0);

INSERT INTO teams(team_id, teamName, win, draw, lose, totalScore)
VALUES (SEQ_TEAMNO.NEXTVAL, '성남FC', 0, 0, 0, 0);

INSERT INTO teams(team_id, teamName, win, draw, lose, totalScore)
VALUES (SEQ_TEAMNO.NEXTVAL, '전북현대', 0, 0, 0, 0);

INSERT INTO teams(team_id, teamName, win, draw, lose, totalScore)
VALUES (SEQ_TEAMNO.NEXTVAL, '수원FC', 0, 0, 0, 0);

INSERT INTO teams(team_id, teamName, win, draw, lose, totalScore)
VALUES (SEQ_TEAMNO.NEXTVAL, '울산HD', 0, 0, 0, 0);

INSERT INTO teams(team_id, teamName, win, draw, lose, totalScore)
VALUES (SEQ_TEAMNO.NEXTVAL, '안양FC', 0, 0, 0, 0);

INSERT INTO teams(team_id, teamName, win, draw, lose, totalScore)
VALUES (SEQ_TEAMNO.NEXTVAL, '대구FC', 0, 0, 0, 0);

UPDATE TEAMS SET teamName = '울산HD' WHERE team_id = 6;

SELECT * FROM TEAMS;
SELECT * FROM members;
SELECT * FROM matches;

SELECT * FROM teams ORDER BY totalScore DESC;






