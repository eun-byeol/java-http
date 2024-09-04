# 기능 목록

## 1. HTTP 서버 구현

- [ ] GET /index.html 응답하기
    - 인덱스 페이지(http://localhost:8080/index.html)에 접근할 수 있다.
    - Http11ProcessorTest의 모든 테스트 통과한다.
- [ ] CSS 지원하기
    - 사용자가 페이지를 열었을 때 CSS 파일이 호출된다.
- [ ] Query String 파싱
    - http://localhost:8080/login?account=gugu&password=password으로 접속하면 로그인 페이지(login.html)가 보여진다.
    - 로그인 페이지 접속 시, Query String을 파싱해서 아이디, 비밀번호가 일치하면 콘솔창에 로그로 회원을 조회한 결과가 나온다.