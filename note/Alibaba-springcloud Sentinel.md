# Sentinel

pom

```xml
<!--alibaba sentinel-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
<!--持久化-->
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-datasource-nacos</artifactId>
</dependency>
<!--openfeign-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

### Sentinel基础使用

sentinel默认端口号为8080，启动时执行jar包即可启动，访问地址为localhost:8080，默认用户名密码为sentinel，sentinel

![](../img/sentinel/Sentinel_dashboard.png)

applicaltion.yml

```yml
spring:
  cloud:
    sentinel:
      transport:
        #配置sentinel dashboard地址，当前的服务8401会被8080监控
        dashboard: localhost:8080
        #默认8719端口，如果端口号被占用，自动从8719依次+1扫描，知道找到可用端口号
        port: 8719
```

sentinel自身为懒加载机制，当服务配置了sentinel监控，但该服务从未被调用过时，sentinel仪表盘不显示该服务，直到服务被调用

### Sentinel流控

**系统默认**（直接在页面配置，因此错误返回由系统提供，没有特定的fallback方法）

![](../img/sentinel/sentinel_系统默认流控.png)

上图配置表示：每秒只能访问一次，出现大于一次的访问时，直接失败

![](../img/sentinel/sentinel错误提示.png)

**关联**

这里配置了testA关联testB，阈值类型是对被关联对象的限制，即对testB的限制，当testB达到阈值时，不对testB进行限流控制，而对testA进行限流

场景：订单服务关联支付服务，若支付服务达到阈值，对订单服务进行限流

![](../img/sentinel/sentinel_流控_关联.png)

**wormup**

场景：某系统平时无人问津，等到举行某活动时，突然有大批量的访问，系统可能会扛不住压力，因此需要预热，即warmup

预热初始访问量往往从threshhold/3开始，即当设置了QPS为10时，初始访问量阈值为3，即每秒访问量达到3的时候就开始限流，等到n秒后再升到10，n为设置的预热时常。

**排队等待**

排队等待时，阈值的类型必须为QPS，否则无效。设置为排队等待后，所有的请求匀速排队，串行处理，直到等待的时候达到超时时长后，失败重试。

场景：在某一时刻有大量的请求，接下来立刻出现一段时间的空缺，设置排队等待可以让系统在接下来的空闲时间内处理刚刚的大量未处理的剩余请求，而不是在大量请求到来时直接拒绝。

### sentinel熔断降级

sentinel的熔断降级和hystrix非常相似。

**最大RT**：慢调用比例，当请求响应时间超出设置的阈值，统一认为是慢调用，当请求的数据大于设置的最小请求数据，且慢调用的比例大于设置的比例，就会触发熔断，经过熔断时长后会进入探测阶段（半开），在接下来的请求响应时间内若小于慢调用的相关阈值则结束熔断。（在sentinel1.8之后引入了半开）

**异常比例**：单位统计时常内达到最小请求次数，且异常比例数超过了设置的阈值，则熔断。熔断时长后进入半开状态探测...

**异常数**：单位统计时常内达到最小请求次数，且异常数超过了设置的阈值，则熔断。...

### sentinel热点规则

配置的热点规则在每次服务重启后会重置，下一次需要重新配置。。。是因为我没做持久化吗。。。

![](../img/sentinel/sentinel热点规则.png)

@SentinelResource注解类似于hystrix中的@HystrixCommand注解

value属性对应页面配置中的资源名，blockHandler类似于hystrix中的fall_back回调方法，**SentinelResource从逻辑上一定要带上blockHandler方法，否则放出错的时候，错误将直接返回到页面。**

还可以对特定的参数设置特定的值...详见官网吧...
