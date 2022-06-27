# MVC_MemberManagement

- MVC(Model View Controller) 디자인 방식을 활용한 회원관리 프로그램(MariaDB 사용)

1. 개요: 사용자가 View를 통해 명령을 보내면 Controller가 입력된 명령어를 판단하고 행동, 이 행동에 따라
Model을 통해 데이터를 저장하거나 불러오는 방식

Model
- 어플리케이션의 정보(데이터)를 나타냄
- 일반적으로 데이터베이스를 지칭
View
- 클라이언트 화면(GUI)
- 웹에서의 html, javascript 등과 같다
Controller
- 사용자의 요청사항을 파악해 그에 맞는 데이터를 Model에 의뢰하고 View에 반영해 사용자에게 전달

2. 각 객체 설명
- Member_List: 회원 리스트 출력 GUI
- Member_Proc: 회원가입, 회원정보 수정 GUI
- Member_DAO: 데이터베이스 접근
- Member_DTO: 데이터베이스에 접근하기 위한 회원 한 명의 정보 저장
- Main: Main Class

3. Prepared Statement 사용
- parse 과정을 최초 한번만 수행하고 메모리에 저장한 뒤 필요할 때 마다 재사용
- 동적 sql문을 사용가능 및 코드 가독성이 좋다
- SQL 인젝션 취약점을 보완
