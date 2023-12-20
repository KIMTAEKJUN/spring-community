# spring-community

<br/>

> 기능 구현을 위주로 진행하는 커뮤니티 프로젝트입니다.

<br/>

### 우선 기능
- **유저**
  - 회원가입, 로그인, 로그아웃(카카오, 구글, 이메일)
  - 비밀번호 찾기
  - **내 정보**
    - 회원 정보 수정(이름, 비밀번호, 프로필 사진)
    - 회원 탈퇴
    - 게시글 목록
    - 댓글 목록
    - 좋아요 목록
- **게시판**
    - **게시글 작성**
      - 해쉬태그
      - 제목, 내용
      - 이미지 업로드 
        - aws s3에 업로드 후 url을 db에 저장
        - 1장만 가능, 5MB 이하만 가능, 형식은 jpg, png, gif만 가능
        - 이미지 리사이징
      - 이미지 삭제
      - 파일 업로드
      - 파일 삭제
    - **게시글 수정**
    - **게시글 삭제**
    - **게시글 목록**
      - 페이징
      - 정렬
      - 제목, 내용, 이미지 미리보기
      - 작성일
        - OO분 전, OO시간 전, OO일 전, OO개월 전, OO년 전
      - 좋아요, 댓글, 조회수
      - 해쉬태그
    - **게시글 상세**
      - 작성자 정보(이름, 프로필 사진)
        - 작성일
      - 제목, 내용, 이미지
      - 좋아요, 댓글, 조회수
      - 해쉬태그
      - 댓글(좋아요)
        - 대댓글(좋아요)
- **댓글, 대댓글**
  - 댓글, 대댓글 작성
  - 댓글, 대댓글 수정
  - 댓글, 대댓글 삭제
  - 댓글, 대댓글 목록
- **검색**
  - 해쉬태그
  - 게시글 제목
  - 유저 이름
### 뒤로 미뤄둔 기능
- 퍼사드 패턴에 대해 공부 후 나중에 적용해보기
- 이메일 인증
- 채팅
  - netty나 webflux 사용
  - 가능하면 redis까지 사용
- 친구(팔로우)
- 그룹
- 알림
- 신고
- 쪽지
- 어드민