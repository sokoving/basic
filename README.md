# 1. 새 프로젝트 만들기
## 프로젝트 이름: basic

## 빌드
- 소스코드를 실행 가능한 파일로 만들어주는 과정

## 빌드 시스템
- 빌드를 하는 툴
+ IntelliJ : 인텔리 자체 제공 툴
+ Maven : 웹앱 전통적인 빌드 시스템
+ Gradle : 모바일앱 빌드 시스템

## Gradle DSL : Groovy

## 고급 설정 : 모든 클래스의 기본 경로가 된다
> com.jdbc.basic
### 그룹ID
- 패키지 경로가 된다, 다른 프로젝트와 겹치면 안 됨
- 보통 도메인 주소를 거꾸로 쓴다
> com.jdbc

### 아티팩트ID
- 프로젝트 가칭, 가제
> basic

# 2. 데이터베이스 연결 설정
- C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 에서 ojbc6.jar 찾아서 복사
- 아래 설정 경로 /src/main/webapp/WEB-INF/lib에 붙여넣기

- build.gradle 파일에 dependencies 블록에 아래 소스코드 추가 후 재빌드 (코끼리 새로고침 버튼)
```groovy

//오라클 라이브러리 (11g edition - gradle, maven 라이센스 문제 공식 지원 불가)
- implementation fileTree(dir: '/src/main/webapp/WEB-INF/lib', include: ['*.jar'])
```

# 3. java로 DB 연결하기
- package com.jdbc.basic.Connect

# 4. java로 DB에 CRUD 해 보기
- package com.jdbc.basic.PersonCRUD

# 5. JUnit 테스트
- 테스트 할 클래스에서 ctrl + shift + T > 새 테스트 클래스 생성
- test 패키지에 테스트 파일이 생겨난다, 거기서 테스트함
## 테스트 주도 개발
- 소규모 단위 테스트를 진행하고 테스트에 성공한 코드를 빌드한다
- 테스트 기록 남길 것 : 업데이트 후 문제 발생할 수 있음
## given-when-then






---------------------------------------------------------------------------
# 외부 라이브러리 사용하기
- 해당 라이브러리 사이트나 https://mvnrepository.com/에 가서 
- 사용할 라이브러리의 코드 복사 
 + compileOnly 'org.projectlombok:lombok:1.18.16'
- build.gradle - dependencies에 추가
- 코끼리 새로고침 버튼 누르기
- 

# lombok 적용하고 사용하기
1. build.gradle - dependencies에 추가
```groovy
    //lombok 라이브러리
   compileOnly 'org.projectlombok:lombok:1.18.12'
   annotationProcessor 'org.projectlombok:lombok:1.18.12'
```
2. 인텔리제이 플러그인 lombok 설치
3. 설정에 annotation processor 검색 -> 아노테이션 활성화 체크
4. 롬복 라이브러리를 쓸 클래스의 윗줄에 @Getter, @Setter 이런 식으로 써줌
5. 

# 그리들 사용법
https://docs.gradle.org/current/samples/sample_building_java_applications.html
## Gradle 한글깨짐 현상 해결
- 인텔리제이 파일 -> 설정 탭으로 이동
- 검색창에 gradle 검색 -> 빌드 도구/ 실행 탭에서 Gradle 선택
- 다음을 사용하여 빌드 및 실행과 테스트실행을 Gradle에서 IntelliJ IDEA로 변경


# 패키지 구성
src : 모든 소스 코드는 여기에 저장
```
> main
 > java :  java로 작성한 문서
  > com
   >jdbc
    >basic
     >connect
 > resources : 다른 언어로 작성한 문서
 > webapp
  >	WEB-INF
    > lib : 외부 라이브러리 파일
      > ojdbc6.jar
> test
 > java: java로 작성한 문서 테스트
 > resources : 다른 언어로 작성한 문서 테스트
```

# ORM 프레임워크(Oject-Relational-Mapping)
- Query DSL
- JPA
- Hibernate
- my Batis