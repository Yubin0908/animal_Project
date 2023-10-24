  -- [회원서비스 관련 쿼리 MEMBER] --
  -- (1) 회원가입 시 id중복체크
  SELECT COUNT(*) CNT FROM MEMBER WHERE ID = 'kim12345';
  -- (2) 회원가입 - 정보등록
  INSERT INTO MEMBER VALUES('jang0908', '12345678', '장소연', '010','1234','5678','jang@naver.com','서울 송파구','엄마',SYSDATE,1);
  INSERT INTO CUSTOMER_PET VALUES(CUSTOMER_PET_SEQ.NEXTVAL, 'kim12345','사랑','2014/01/01');
  -- (3) DTO 가져오기 (CUSTOMER_PET JOIN)
  SELECT M.*, P.* 
    FROM MEMBER M, CUSTOMER_PET P
    WHERE M.ID = P.ID AND M.ID = 'bin12345';
  -- (4) 회원정보 수정 전 비밀번호 체크
  SELECT PW FROM MEMBER WHERE ID = 'kim12345';
  -- (5) 회원정보 수정
  UPDATE MEMBER SET
    PW = 'testpw01',
    LOCTEL = '010',
    MIDTEL = '1212',
    LASTEL = '0911',
    EMAIL = 'kim@test.co.kr',
    ADDRESS = '서울 구로구',
    NICKNAME = '엄마'
    WHERE ID = 'kim12345';
  -- (6) 회원탈퇴
  UPDATE MEMBER SET ACCOUNT_STATUS = 0 WHERE ID = 'jang0908';
  -- (7) 로그인
  SELECT COUNT(*) FROM MEMBER WHERE ID = 'kim12345' AND PW = 'testpw01' AND ACCOUNT_STATUS = 1;
  
  
  
  -- [분양 문의 게시판 관련 쿼리 - CONTACT] --
  -- (1) 리스트 출력(paging)
    SELECT * FROM
    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM CONTACT ORDER BY CID DESC) A)
    WHERE RN BETWEEN 1 AND 10;
  -- (2) 문의글 등록
  INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, 'TESTER', '문의글 테스트', '본문 테스트', SYSDATE, CONTACT_SEQ.CURRVAL, 0,0, '192.168.0.1', 1);
  -- (3) 문의글 상세보기
  SELECT * FROM CONTACT WHERE CID = 1;
  -- (4) 문의글 수정
  UPDATE CONTACT SET 
    CTITLE = '수정 테스트',
    CTEXT = '본문수정되는지 확인',
    CIP = '128.0.9.1'
    WHERE CID = 1;
  -- (5) 답변글 쓰기 전단계(step 조정작업)
  -- (6) 답변글 쓰기
  -- (7) 답변글 상세보기
  -- (8) 글 삭제 (관리자만 가능)
  
  
  
  -- [고객 리뷰 게시판 관련 쿼리 - REVIEW] --
  -- (1) 리스트 출력(paging)
  SELECT * FROM
    (SELECT ROWNUM RN, RPAD(SUBSTR(NAME,0,1),LENGTH(NAME), '*') NAME, A.* FROM REVIEW A, MEMBER M
    WHERE A.ID = M.ID ORDER BY RID DESC)
    WHERE RN BETWEEN 1 AND 30;
  -- (2) 리뷰 상세보기
  -- (3) 리뷰 작성
  -- (4) 리뷰 수정
  -- (5) 리뷰 삭제
  DELETE FROM REVIEW;
  
  -- [공지사항 게시판 관련 쿼리 - NOTICE] --
  -- (1) 리스트 출력(paging)
  SELECT * FROM
  (SELECT ROWNUM RN, A.* FROM (SELECT * FROM NOTICE ORDER BY NID DESC) A)
  WHERE RN BETWEEN 1 AND 20;
  -- (2) 공지사항 상세보기
  SELECT * FROM NOTICE WHERE NID = 1;
  -- (3) 공지사항 작성
  INSERT INTO NOTICE VALUES (NOTICE_SEQ.NEXTVAL ,100001, SYSDATE, '공지사항 테스트', '본문 테스트', NULL, '192.168.0.1');
  -- (4) 공지사항 수정
  UPDATE NOTICE SET 
    NDATE = SYSDATE,
    NTITLE = '수정공지사항',
    NTEXT = '수정본문',
    NIMG = NULL,
    NIP = '111.9.0.1'
    WHERE NID = 1;
  -- (5) 공지사항 삭제
  DELETE FROM NOTICE WHERE NID = 1;
  -- (6) 리스트 갯수
  SELECT COUNT(*) CNT FROM NOTICE;
  
  -- [분양 게시판(리스트) 관련 쿼리 - LOCAL_PET] -- 
  -- (1) 리스트 출력(paging)
  -- (2) 리스트 추가
  -- (3) 리스트 수정
  -- (4) 리스트 삭제
  
  
  
  COMMIT;