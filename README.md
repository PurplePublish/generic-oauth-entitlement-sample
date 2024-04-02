# Generic OAuth2.0/OpenID Entitlement Sample

## Getting started

### Requirements

* Docker
* Java
* IDE (IntelliJ)

### Steps

1. Start services from docker-compose.yml, e.g. docker compose up -d
2. Open Keycloak Admin in browser: http://localhost:8080
3. Navigate to sample realm and create a user with credentials, e.g. username admin and password admin
4. Start Spring Boot service
5. Use requests/CreateToken.http to create a access token
6. Use access token from response in requests/EntitlementsWithValidAccessToken.http
