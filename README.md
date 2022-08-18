# codingtest-backend :: oEmbed Service 
과제형 코딩테스트를 위해 만들었던 oEmbed 서비스입니다. <br>
youtube, twitter, vimeo 등의 컨텐츠를 미리 보여줍니다. <br>
URL을 입력받고 oEmbed 데이터를 수집하여 table로 보여줍니다. <br>

<img width="1239" alt="스크린샷 2022-08-18 오전 10 07 03" src="https://user-images.githubusercontent.com/91924087/185270033-927819cc-4e9b-4ec0-b66e-00ef8cfa4675.png">

## oEmbed란?
[oEmbed 공식사이트](https://oembed.com)에 따르면, 현재 사이트에서 다른 사이트의 URL을 내장 표현으로 사용할 수 있도록 하는 Format입니다.<br>
유저가 현재 사이트에 Resource 링크를 입력하면 웹사이트들이 Resource를 직접 파싱하지 않고, <br>
내장된 컨텐츠(사진과 비디오같은)를 보여줄 수 있게 하는 간단한 API 입니다.

## 사용 스택 및 세팅
- Java 11
- Spring Boot (Ver 2.7.2)
- Bootstrap (Ver 5.2.0)
- IntelliJ

## 백엔드 & 프론트엔드 설명
1. Spring Boot
* URL을 HTTP GET 방식으로 받아온다.
* URL 유효성 검사를 실행한다.
* URL이 유효하다면, oembed의 providers.json 파일에 들어있는 scheme인지 확인한다.
* scheme에 따라, 미리 만들어 뒀던, 알맞은 provider 관련 객체를 가져온다. (factory pattern과 비슷한 구조)
* oembed url을 생성한다.
* WebClient를 이용해 Embed 요청 결과를 받아온다.
* 받아온 결과를 화면에 보여준다.

<br>

2. Bootstrap
* 간단한 페이지 디자인을 위해 사용한 것이므로 CDN(Contents Delivery Network)을 사용하여 라이브러리를 가져왔다.
* Provider마다 Json 데이터의 변수가 다르므로 thymeleaf를 사용해서 동적으로 테이블 생성했다.
