# Spring Cloud Demo

## Projects

- [ ] []()
- [x] []()
- [x] []() 【】
- [x] [demo-eureka-server](demo-eureka-server) 【2021-11-03】: Eureka 服务端
- [x] [demo-eureka-client](demo-eureka-client) 【2021-11-03】: Eureka 客户端
- [x] [demo-spring-boot-admin-server](demo-spring-boot-admin-server) 【2021-12-21】: Spring Boot Admin 服务端
- [x] [demo-spring-boot-admin-client](demo-spring-boot-admin-client) 【2021-12-21】: Spring Boot Admin 客户端
- [x] [demo-spring-cloud-feign-sentinel](demo-spring-cloud-feign-sentinel) 【2021-12-09】: Spring Cloud OpenFeign and Sentinel

## 服务端口

### 基础服务

| 服务                          | 描述        | 端口 |
|-----------------------------|-----------|--|
| demo-eureka-server | eureka 服务端 | 8761 |

### 业务服务

| 服务                                        | 描述        | 端口 |
|-----------------------------              |-----------|--|
| demo-dubbo-provider-service               | dubbo 服务端 | 8001 |
| demo-dubbo-consumer-service               | dubbo 消费端 | 8002 |
| :demo-spring-cloud-rpc:rpc-api            | rpc 接口                    | 9101 |
| :demo-spring-cloud-rpc:openfeign-sample   | openFeign 示例              | 9102 |
| :demo-spring-cloud-rpc:rpc-sample         | rpc 示例                      | 9103 |
| :demo-spring-cloud-feign:goods-service    | goods 接口 (feign 服务端)      | 9111 |
| :demo-spring-cloud-feign:goods-client     | goods 客户端 (feign 客户端)    | 9112 |

## links

- [spring cloud + gradle多模块示例](https://github.com/jkazama/sample-boot-micro)