# React / JPA
<div align="center">
        <img width="60%" src="https://github.com/aozp73/React-JPA_Board-Paging-Searching_Deploy/assets/122352251/caf41e0a-f1ad-4695-a709-6f467be48486"/>
</div>

<br> <br>
&nbsp; ※ 기능 <br>
&nbsp; - 페이징, 검색 <br>
&nbsp; - 유저 (등록, 조회) / 게시글 (등록, 조회, 수정, 삭제) / 댓글 (등록, 조회, 수정, 삭제) <br><br>

&nbsp; ※ 적용 기술 <br>
&nbsp; 1. Backend <br>
&nbsp; - JWT + SpringSecurity (accessToken, refreshToken / 인증 path 관리) <br>
&nbsp; - QueryDSL (게시글 검색) <br>

&nbsp; 2. Frontend <br>
&nbsp; - axios (통신 / Interceptor - Jwt Token 공통 처리) <br>
&nbsp; - redux-persist, 로컬 스토리지 (유저 정보 / accessToken) <br>
&nbsp; - Cookie (refreshToken) <br>

&nbsp; 3. DevOps <br>
&nbsp; - Docker Compose / Git Actions CICD 스크립트 <br>
&nbsp; - AWS EC2 <br>

<br> <br>

## 기술 스택

### FrontEnd 
![HTML5](https://img.shields.io/badge/HTML5-%23E34F26.svg?style=flat-square&logo=html5&logoColor=white) 
![CSS3](https://img.shields.io/badge/CSS3-%231572B6.svg?style=flat-square&logo=css3&logoColor=white) 
![JavaScript](https://img.shields.io/badge/JavaScript-%23323330.svg?style=flat-square&logo=javascript&logoColor=%23F7DF1E) 
![React](https://img.shields.io/badge/React-61DAFB.svg?style=flat-square&logo=React&logoColor=black)

### BackEnd
![Java](https://img.shields.io/badge/Java-007396.svg?style=flat-square&logo=openjdk&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring_Boot-%236DB33F.svg?style=flat-square&logo=spring&logoColor=white) 
![SpringSecurity](https://img.shields.io/badge/Spring_Security-6DB33F?style=flat-square&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JSON%20Web%20Tokens-000000.svg?style=flat-square&logo=JSON-Web-Tokens&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-5F5F5F?style=flat-square&logo=buffer&logoColor=white)

### DevOps
![Docker](https://img.shields.io/badge/Docker-2496ED.svg?style=flat-square&logo=Docker&logoColor=white)
![Git Actions](https://img.shields.io/badge/GitHub%20Actions-2088FF.svg?style=flat-square&logo=GitHub-Actions&logoColor=white)
![EC2](https://img.shields.io/badge/Amazon%20EC2-FF9900.svg?style=flat-square&logo=Amazon-EC2&logoColor=white)

### Tool
![IntelliJ](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=flat-square&logo=IntelliJ-IDEA&logoColor=white)


<br> <br>


## View / 소스코드

### 유저
<table>
  <tr>
    <th>내용</th>
    <th>사진</th>
  </tr>
  <tr>
    <td>회원가입 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
    <td><img src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/c1740bd7-2e2b-4a27-8179-34aba0a3917d" style="width:100%;height:auto;"></td>
  </tr>
  <tr>
    <td>&nbsp 로그인</td>
    <td><img src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/2b15d6e2-16f4-4f47-a61c-a8697322548d" style="width:100%;height:auto;"></td>
  </tr>
</table>

<br>

### 게시글
<table>
  <tr>
    <th>내용 &nbsp&nbsp&nbsp</th>
    <th>사진</th>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        목록
      </div> 
    </td>
    <td><img src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/47476221-4e0d-4e5a-a11a-638279b36b51" style="width:100%;height:auto;"></td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        상세
      </div> 
    </td>
    <td><img src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/14ad804b-2eb7-4912-b895-a1b4d5f823df" style="width:100%;height:auto;"></td>
  </tr>
</table>

<br>

### BackEnd 소스코드
<table>
  <tr>
    <th>내용 &nbsp&nbsp&nbsp</th>
    <th>사진</th>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        패키지
      </div> 
    </td>
    <td>
      <div align="center">
        <img width="60%" src="https://github.com/aozp73/Js-JPA_Board-Paging-Searching/assets/122352251/708b66d1-fbe1-4dce-be16-44412ac76122"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        @QueryDSL
      </div> 
    </td>
    <td>
      <div align="center">
        <img width="80%" src="https://github.com/aozp73/Js-JPA_Board-Paging-Searching/assets/122352251/7143b3d9-bafa-4c23-bd98-25bf955bcd8d"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        @Query
      </div>  
    </td>
    <td>
      <div align="center">
        <img width="80%" src="https://github.com/aozp73/Js-JPA_Board-Paging-Searching/assets/122352251/655b39d0-6f1f-4a87-9c31-75c18e5f8e72"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        NamedQuery
      </div>  
    </td>
    <td>
      <div align="center">
        <img width="80%" src="https://github.com/aozp73/Js-JPA_Board-Paging-Searching/assets/122352251/87feb0d2-0da5-4868-a4fd-6e322cbb49b6"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        Entity
      </div>  
    </td>
    <td>
      <div align="center"> 
        <img width="40%" src="https://github.com/aozp73/Js-JPA_Board-Paging-Searching/assets/122352251/a657b24a-6c91-4ff7-a4cc-9e16fe0ca56a"/>
      </div>
    </td>
  </tr>
</table>

<br> <br>

### Frontend 소스코드
<table>
  <tr>
    <th>내용 &nbsp&nbsp&nbsp</th>
    <th>사진</th>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        컴포넌트
      </div> 
    </td>
    <td>
      <div align="center">
        <img width="50%" src="https://github.com/aozp73/React-JPA_Board-Paging-Searching_Deploy/assets/122352251/c41644e3-ad29-4764-a996-c6bf2e85d880"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        interceptor
      </div> 
    </td>
    <td>
      <div align="center">
        <img width="100%" src="https://github.com/aozp73/React-JPA_Board-Paging-Searching_Deploy/assets/122352251/4798a809-0784-498e-8ca6-d268cbbab2b4"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        reducer
      </div>  
    </td>
    <td>
      <div align="center">
        <img width="60%" src="https://github.com/aozp73/React-JPA_Board-Paging-Searching_Deploy/assets/122352251/0fc0409b-028c-4541-86bb-0131d4216836"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        redux-persist
      </div>  
    </td>
    <td>
      <div align="center">
        <img width="70%" src="https://github.com/aozp73/React-JPA_Board-Paging-Searching_Deploy/assets/122352251/d86f6cb0-187d-4470-9ae8-63f2b5b773c3"/>
       </div>
    </td>
  </tr>
</table>

<br> <br>

### Devops 소스코드
<table>
  <tr>
    <th>내용 &nbsp&nbsp&nbsp</th>
    <th>사진</th>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        스크립트
      </div> 
    </td>
    <td>
      <div align="center">
        <img width="80%" src="https://github.com/aozp73/React-JPA_Board-Paging-Searching_Deploy/assets/122352251/dd345d7a-3d20-4471-b970-9a782b9f7d0b"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center"> 
        Git Actions
      </div> 
    </td>
    <td>
      <div align="center">
        <img width="80%" src="https://github.com/aozp73/React-JPA_Board-Paging-Searching_Deploy/assets/122352251/f9c06344-d2f3-4810-a358-35375e3c5ceb"/>
       </div>
    </td>
  </tr>
</table>

<br> <br>

## Spring 라이브러리 

	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'

	// Security
	implementation 'org.springframework.boot:spring-boot-starter-security'

	// Jwt
	implementation 'io.jsonwebtoken:jjwt-api:0.11.5'
	runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.11.5'
	runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.11.5'

	implementation 'org.springframework.boot:spring-boot-starter-data-redis'

	// Validation
	implementation 'org.springframework.boot:spring-boot-starter-validation'

	// DB
	runtimeOnly 'com.mysql:mysql-connector-j'
	runtimeOnly 'com.h2database:h2'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

	implementation 'com.querydsl:querydsl-jpa'
	annotationProcessor "com.querydsl:querydsl-apt:${dependencyManagement.importedProperties['querydsl.version']}:jpa"
	annotationProcessor "jakarta.annotation:jakarta.annotation-api"
	annotationProcessor "jakarta.persistence:jakarta.persistence-api"

	// RestDocs
	testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'


	// Test
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
	testCompileOnly 'org.projectlombok:lombok'
	testAnnotationProcessor 'org.projectlombok:lombok'

	testImplementation "org.junit.jupiter:junit-jupiter:5.8.1"
	testImplementation 'org.testcontainers:testcontainers:1.19.3'
	testImplementation "org.testcontainers:junit-jupiter:1.17.6"
	testImplementation "com.redis.testcontainers:testcontainers-redis-junit:1.6.4"

<br>
 
## React 라이브러리
    "@testing-library/jest-dom": "^5.17.0",
    "@testing-library/react": "^13.4.0",
    "@testing-library/user-event": "^13.5.0",
    "axios": "^1.6.5",
    "react": "^18.2.0",
    "react-bootstrap": "^2.10.0",
    "react-cookie": "^7.0.1",
    "react-dom": "^18.2.0",
    "react-redux": "^9.1.0",
    "react-router-dom": "^6.21.3",
    "react-scripts": "5.0.1",
    "redux": "^5.0.1",
    "redux-persist": "^6.0.0"
    "web-vitals": "^2.1.4"

<br>
