# 日志

日志模块几乎没用做什么工作，只是简单的包括了依赖。日志采用sel4j的api调用方式，具体实现提供了log4j2的方式。如果要自定义配置，同log4j2的配置复写类路径下的`log4j2.xml`配置文件。

调用方式很简单：

```
public static final Logger logger = LoggerFactory.getLogger(XXXX.class);
```
