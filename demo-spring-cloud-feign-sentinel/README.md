# Spring Cloud OpenFeign Sentinel

依赖

```groovy
implementation 'com.alibaba.cloud:spring-cloud-starter-alibaba-sentinel'
```

Note: 使用 `com.alibaba.cloud:spring-cloud-alibaba-dependencies` 作为版本管理

feign:

```yaml
feign:
  sentinel:
    enabled: true
```

sentinel:

```yaml
spring:
  application:
    name: concumser-service
  main:
    allow-circular-references: true
  cloud:
    sentinel:
      enabled: true
      log:
        dir: logs/csp/
        switch-pid: true
      transport:
        dashboard:
        port: 8719
        heartbeat-interval-ms: 30000
```

## 文档链接

- [Sentinel](https://github.com/alibaba/Sentinel/wiki/介绍)
- [Spring Cloud Alibaba Sentinel](https://github.com/alibaba/spring-cloud-alibaba/wiki/Sentinel)