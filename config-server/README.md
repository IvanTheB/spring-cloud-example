# config-server

- Service info:
```
GET http://localhost:8888/{service}/default
```
- Service properties:
```
GET http://localhost:8888/{service}-default.properties
```
```
GET http://localhost:8888/{service}-default.json
```

- Push changes on Event Bus (see https://cloud.spring.io/spring-cloud-config/multi/multi__push_notifications_and_spring_cloud_bus.html):
```
POST http://localhost:8888/monitor
{
	"path" : "*"
}
```
- Properties provided by the Config Server have higher priority than properties defined locally in other projects