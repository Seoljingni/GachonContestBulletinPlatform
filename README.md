# 게시판
### 블로그 정리 글 링크
https://innovation123.tistory.com/93

### 사용 기술
Java 11, SpringBoot 2.7.10, Thymeleaf
H2 Database 
 -> JdbcTemplate, MyBatis


# 주요 기능

### 회원 관리(Member)
회원가입 / 로그인 / 필터(Spring Interceptor)
- 회원 CRUD 구현 (회원가입, 회원정보 열람, 수정, 삭제)
- 이메일 형식이 '@gachon.ac.kr' 과 일치해야지만 회원가입 가능
- userType을 institution과 normal로 구분
- userType institution과 normal이 들어갈 수 있는 페이지 구분 + 개인 페이지 구분
- 세션쿠키를 이용해서 현재 로그인 되어있는 상태인지 확인
- 로그인 없이도 이용할수 있는페이지, 로그인 회원만 이용할 수 있는 페이지 구분
- 비로그인 상태로 회원 전용 페이지에 들어가려 할때, 로그인페이지로 이동
- 로그아웃 시 세션 만료

### 글 (Post)
제목, 내용, 작성자 검색 / 수정, 삭제 / 정렬
- 글 관련 CRUD 구현 ( 글쓰기, 열람, 수정, 삭제 )
- 글쓰기는 userType: institution만 가능
- 제목, 내용, 작성자로 각각 검색 가능
- 세션을 통해 로그인 사용자 확인 후 본인의 글일때만 수정, 삭제 가능
- 조회수 기능 ( 본인이 본인 글 열람시 조회수 증가x)

### 공모전 신청하기 (Application)
- 각 공모전 글마다 신청하기 가능
- userType: normal만 가능

### 개인페이지 (Profile)
- userType: institution -> my writings, write 버튼
- my writings -> 본인이 작성한 공모전 글 확인 가능
- write -> 공모전 글 작성
- userType: normal -> my application 버튼
- my application -> 공모전 신청 내역 확인 가능 + cancel 가능

### 검증(Validation)
Spring Bean Validation
- 모든 사용자 입력 발생 시 Validation 진행 

### 메시지
- messages.properties / errors.properties 파일을 이용해 메시지 관리
- 국제화 적용 (messages_en.properties, errors_en.properties) 


### Front View
Thymeleaf, Html, bootstrap

### Test 
JUnit5
- Member, MemberRepository, Post, PostRepository 동작 테스트  

