drop table board;

CREATE TABLE board (
  id VARCHAR2(20) PRIMARY KEY,
  password VARCHAR2(20),
  birth VARCHAR2(20),
  zone varchar2(20),
  name VARCHAR2(20)
  );
  
  DESC board;
  
  INSERT INTO board(id,password,birth,zone,name)
  VALUES('slygun','1234','790611','용인','이건효');
  
  SELECT * FROM board;
           
  COMMIT;
  
  drop table mboard; 
  
  CREATE TABLE mboard (
  col_num number(20) PRIMARY KEY,
  title VARCHAR2(200),
  substance VARCHAR2(4000)
  );
  
  DESC mboard;
  
  INSERT INTO mboard
  VALUES(1, '테스트제목','오늘우리저녁 언제 집에 갈수 있을까요');
  INSERT INTO mboard
  VALUES(2, '테스트제목2','오늘우리저녁 언제 집에 갈수 있을까요');
  
  select * from mboard;
  
  delete from mboard where col_num = 1;
  
  commit;    