# ServletLogin

국비지원 학원 수강생들과 팀을 꾸려, 데이트 코스 추천이라는 주제로 서블릿을 활용한 로그인 페이지를 만들었습니다. 
처음으로 깃을 사용해 협업을 연습했습니다. 

김병국: 로그인, 데이트 코스 입력, 즐겨찾기, 데이트 코스 게시글 보기
서아진: 회원가입, 회원정보 수정&삭제, 폰트 
최규범: UI디자인, 메인 페이지 레이아웃, 비밀번호 찾기

로그인 전후에 대한 header를 다르게 설정했습니다.(로그인 세션 처리하는 방법을 몰랐었다,,,)
[메인 페이지 - 로그인 전]
![image](https://user-images.githubusercontent.com/87313203/176162543-20c51a69-7110-4d05-b117-610b43920e20.png)
[메인 페이지 - 로그인 후]
![image](https://user-images.githubusercontent.com/87313203/176163111-480ce93b-7e2b-4cae-8b5e-20a8258811cd.png)


[로그인 페이지] - 구글 로그인 페이지를 벤치마킹했습니다.
- 엔터버튼 값이 들어오면 로그인 버튼을 누르는 효과를 냄
- 눈 모양을 누르면 비밀번호의 type을 text로 바꾸는 toggle기능 
- OAuth는 구현 못했습니다....흑
![image](https://user-images.githubusercontent.com/87313203/176162840-d96b4373-3097-4b56-9dbe-75960a78d69f.png)

[회원가입 페이지]
- 아이디이자 이메일은 Ajax를 사용해 중복체크를 하고, 이미지와 같이 알림 메시지를 표시한다.
- 중복체크의 조건이 통과해야만 회원가입 버튼이 활성화 된다.
![image](https://user-images.githubusercontent.com/87313203/176322273-4868211b-19fa-4c9c-bd7e-a665994db325.png)

[회원 정보]
- 로그인 후에는 회원 정보를 조회하고 일부 수정(update) 및 전체 삭제(delete)를 할 수 있다. 
- 수정은 비밀번호, 이름, 생년월일, 전화번호, 답변만 가능하다. 
![image](https://user-images.githubusercontent.com/87313203/176322677-f57b7758-2afc-4d33-a677-11543c9810fc.png)

[비밀번호 찾기]
- 이메일(pk)을 입력하고, 회원가입 시 설정한 질문에 맞는 답변을 고르면 비밀번호를 알려준다. 
![image](https://user-images.githubusercontent.com/87313203/176322857-4dbed95b-61d5-4fe3-b020-29212d76c61c.png)
![image](https://user-images.githubusercontent.com/87313203/176322992-68fd2180-ef7e-4578-863b-b56367809bd3.png)

[코스 추천]
- 코스 제목을 누르면 코스를 상세보기 가능 
- 코스를 상세보기 하면 해당 게시글의 조회수가 1증가
- 즐겨찾기하고 싶다면 별표를 누른다. 누르면 toggle : 즐겨찾기 추가(채워진 별) <-> 즐겨찾기 삭제(빈 별)
![image](https://user-images.githubusercontent.com/87313203/176323101-613e4cc9-9c4c-43c6-9b02-353425260f41.png)

[코스 만들기]
- 로그인 하면 직접 데이트 코스를 추가할 수 있다. 
![image](https://user-images.githubusercontent.com/87313203/176323326-6ed3879d-9d24-4f70-97b1-9b7eee59354e.png)


