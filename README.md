﻿# Hansung Authorization Server
## 프로젝트명
Hansung Authorization Server

## 프로젝트 소개
이 프로젝트는 한성대학교 캡스톤 디자인 작품에 OIDC 프로토콜을 적용하기 위해 구현된 인가 서버 프로젝트입니다. Spring Authorization Server 프레임워크를 사용해서 구현하였으며 OIDC 프로토콜에서는 OpenID Provider, OAuth2 프로토콜에서는 Authorization Server 역할을 담당하고 있는 서버입니다.

## 개발 기간
- 2023/03/20 ~

## 개발 환경
- 개발 언어 : `JAVA 17`
- IDE : `IntelliJ IDEA`
- 프레임워크 : `Spring Authorization Server` `Spring Boot`
- 데이터베이스 : `MySQL`
## 프로젝트 설명

### OIDC란?

OpenID Connect (OIDC)는 사용자 인증 및 권한 부여를 위한 인증 프로토콜입니다. OAuth 2.0을 기반으로 하며, 추가적인 인증 관련 기능을 제공합니다.

OIDC를 사용하면, 사용자가 서드파티 애플리케이션에 로그인할 때 인증 과정이 자동으로 처리됩니다. 이를 통해 사용자는 서드파티 애플리케이션에서 계정을 만들거나 별도로 로그인할 필요 없이, 기존의 인증 과정을 거쳐 즉시 애플리케이션을 사용할 수 있습니다.

OIDC의 핵심적인 컨셉은 ID Token입니다. ID Token은 클라이언트 애플리케이션에 반환되는 JWT(Json Web Token)입니다. ID Token은 사용자 정보와 함께 클라이언트가 인증한 사용자를 식별하는 데 사용됩니다. 이것은 클라이언트가 애플리케이션을 사용할 때 필요한 인증 정보를 제공합니다.

### 적용 이유

구글, 카카오와 같은 기업에서는 OAuth2 프로토콜을 사용해 “구글 로그인", “카카오 로그인”과 같은 기능을 제공하고 있습니다. 대학생 수준에서는 보통 “클라이언트”의 입장에서 위의 기능들을 사용하여 프로젝트를 구현하곤 합니다. 

저희는 OAuth2 프로토콜의 핵심적인 역할을 하는 Authorization Sever를 개발해보고 싶다는 생각을 했고, 전반적인 프로젝트의 구성을 OAuth2 프로토콜을 사용해서 구축하고자 했습니다. 더불어, 학생들의 정보(이름, 학번 등)을 클라이언트가 식별할 수 있도록 ID Token을 제공하고자 OAuth2 프로토콜을 기반으로 하는 OIDC 프로토콜을 사용하게 되었습니다.

### 주요 설정

이 프로젝트에서 주요 설정은 다음과 같습니다.

- OIDC 지원
- ID Token Claim 커스텀
    - 이름, 학번, 트랙, 프로필 사진
    - 권한
- Access Token Claim 커스텀
    - 권한
- 커스텀 로그인 페이지
- 로그아웃 엔드포인트 지원

간단히 정리하면, Spring Authorization Server는 기본적으로 OAuth2를 기반으로 동작하기에 OIDC를 지원하도록 설정했습니다. 또한, 클라이언트에게 제공되는 ID Token, Access Token의 Claim을 전반적인 프로젝트의 문맥에 맞게 커스터마이징 하였습니다.마지막으로 이 프로젝트에 적용한 프레임워크의 버전에는 지원되지 않는 로그아웃 엔트포인트를 구현했습니다.
