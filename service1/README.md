A simple Spring Boot service that invokes "service2" with:
- @LoadBalanced RestTemplate
- FeignClient
 
Refresh properties:
	POST http://localhost:8080/refresh
	
Refresh via bus:
	POST http://localhost:8080/bus/refresh