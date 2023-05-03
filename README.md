# SSAFY 9th SpringBoot - BackEnd Project

# EnjoyTrip

### 1. 프로젝트 소개

1. 개요
2. 팀원
3. 개발환경

### 2. 정보구조도 및 요구사항 명세

### 3. 프로젝트 구조

1. 프로젝트 패키지 구조
2. ER-Diagram

### 4. Back-End 구현

---

# 1. 프로젝트 소개

📢 SSAFY 관통 프로젝트의 3단계 → Servlet에서 SpringBoot 및 RestAPI 구현

📢 Vue 미적용으로 BackEnd 만 구현. RestAPI를 통한 Front - Back 의 분업화

## a. 개요

- 공공 데이터 포털의 오픈 API를 이용하여 관광지에 관한 정보 제공
- 여행 플랫폼으로서 사용자는 본인이 여행 정보를 등록 및 수용 가능

## b. 팀원

- 최하영
- 홍유빈

## c. 개발 환경

- 협업: Notion, MatterMost
- 형상관리(VCS): Git, GitHub, GitLab
- BackEnd: Spring, JAVA, MyBtis
- DataBase: MySQL
- Test: Postman

---

# 2. 요구사항 및 API 명세

[정보구조도 및 요구사항 명세](https://www.notion.so/90b0b0df7d0f4d7fb0eb4d1e28a09fd6)

- 정보구조도 및 요구사항 명세

  ![정보구조도 및 요구사항 명세.png](img/ERDiagram.png)

---

# 3. 프로젝트 구조

## a. 프로젝트 패키지 구조

```
C:.
│  .gitignore
│  mvnw
│  mvnw.cmd
│  pom.xml
│
├─.mvn
│  └─wrapper
│          maven-wrapper.jar
│          maven-wrapper.properties
│
└─src
  ├─main
  │  ├─java
  │  │  └─com
  │  │      └─ssafy
  │  │          └─ssafytrip
  │  │              │  SsafytripSpringbootApplication.java
  │  │              │
  │  │              ├─controller
  │  │              │      AttractionController.java
  │  │              │      PlanController.java
  │  │              │      UserController.java
  │  │              │
  │  │              └─model
  │  │                  │  Attraction.java
  │  │                  │  Board.java
  │  │                  │  Gugun.java
  │  │                  │  Page.java
  │  │                  │  PageResult.java
  │  │                  │  Plan.java
  │  │                  │  PlanAttraction.java
  │  │                  │  PlanUser.java
  │  │                  │  Review.java
  │  │                  │  Sido.java
  │  │                  │  User.java
  │  │                  │
  │  │                  ├─mapper
  │  │                  │      AttractionMapper.java
  │  │                  │      PlanMapper.java
  │  │                  │      UserMapper.java
  │  │                  │
  │  │                  └─service
  │  │                          AttractionService.java
  │  │                          AttractionServiceImpl.java
  │  │                          PlanService.java
  │  │                          PlanServiceImpl.java
  │  │                          UserService.java
  │  │                          UserServiceImpl.java
  │  │
  │  └─resources
  │      │  application.properties
  │      │
  │      └─mapper
  │              attraction.xml
  │              plan.xml
  │              user.xml
  │
  └─test
      └─java
          └─com
              └─ssafy
                  └─ssafytrip
                          SsafytripSpringbootApplicationTests.java
```

## b. ER-Diagram

- ![정보구조도 및 요구사항 명세.png](img/ERDiagram.png)

---

# 4. Back-End 구현

<details>
<summary>로그인, 로그아웃, 회원가입</summary>
<div markdown="1">

- 로그인
  ![로그인.png](img/login.png)
- 로그아웃
  ![로그아웃.png](img/logout.png)
- 회원가입
  ![회원가입.png](img/signin.png)

</div>
</details>

<details>
<summary>개인정보</summary>
<div markdown="1">

- 개인정보 수정
  ![개인정보 수정.png](img/modify_personalinfo.png)
- 개인정보 조회
  ![개인정보조회.png](img/view_personalinfo.png)
- 나의 여행지 조회(찜한 여행지 조회)
  ![내가 찜한 장소 조회.png](img/view_my_hotplace.png)

</div>
</details>

<details>
<summary>여행 코스</summary>
<div markdown="1">

- 여행 코스 설정

  - 여행 코스 생성
    ![계획 생성.png](img/create_plan.png)
  - 여행 세부 계획 설정
    ![세부 계획 설정.png](img/modify_detail_plan.png)
  - 여행 세부 계획 반환
    ![여행세부계획 반환.png](img/view_plan.png)

- 나의 여행 코스

  - 나의 여행 코스 조회
    ![나의 여행 코스 조회.png](img/view_my_plan.png)
  - 나의 여행 코스 삭제
    ![플랜 삭제.png](img/delete_plan.png)

- 나의 여행 코스 공유
  - 여행 코스 참여자 추가
    ![여행 계획 참여자 추가.png](img/add_crewmember.png)
  - 여행 코스 참여자 삭제
    ![여행계획 참여자 삭제.png](img/delete_crewmember.png)
  - 여행 코스 참여자 조회
    ![여행계획 참여자 조회.png](img/view_crewmember.png)

</div>
</details>

<details>
<summary>찜하기</summary>
<div markdown="1">

- 찜

  - 내가 좋아하는 장소 찜하기
    ![내가 좋아하는 장소 찜하기.png](img/add_my_hotplace.png)
  - 내가 찜한 장소 조회하기
    ![내가 찜한 장소 조회하기.png](img/search_by_gugun.png)

</div>
</details>

<details>
<summary>관광지 검색</summary>
<div markdown="1">

- 관광지 정보 검색
  ![관광지 정보 검색.png](img/search_attraction.png)
- 관광지 구-군 조회
  ![구군조회.png](img/search_by_gugun.png)
- 관광지 시-도 조회
  ![시도 조회.png](img/search_by_city.png)
- 관광지 카테고리별 조회
  ![카테고리별 관광지 반환.png](img/search_by_category.png)

</div>
</details>
