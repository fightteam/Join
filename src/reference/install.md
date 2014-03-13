# 安装使用

### 安装（不必安装也可以使用）

#### 用gradle

```
maven {
            url 'https://raw.github.com/fightteam/Join/mvn-repo'
        }
```

#### 用maven

```
 <repository>
    <id>maven-repository</id>
    <url>https://raw.github.com/fightteam/Join/mvn-repo</url>
  </repository>
```

### 使用

选择需要的依赖模块

```
compile "org.fightteam.join:join-log:1.0.0.BUILD-SNAPSHOT"
```

```
compile "org.fightteam.join:join-core:1.0.0.BUILD-SNAPSHOT"
```

```
compile "org.fightteam.join:join-dao:1.0.0.BUILD-SNAPSHOT"
```

```
compile "org.fightteam.join:join-web:1.0.0.BUILD-SNAPSHOT"
```

```
compile "org.fightteam.join:join-rest:1.0.0.BUILD-SNAPSHOT"
```

```
testCompile "org.fightteam.join:join-test:1.0.0.BUILD-SNAPSHOT"
```

### 关于spring java config

如果使用sping的java config，就不得不考虑一个问题，那就是配置载入如问题。
简单来说Spring的java config是使用`@Configuration`来实现，这个注解会被扫描，和`@Service`、`@Component`等一样。
如果组件化了jar包，而且有了`@Configuration`在jar中的配置，那么就得考虑这个注解的载入问题。

在开发test模块中遇到了这个问题，比如我有一些需求这个模块的项目需要的是简单的集成了spring的单元测试。
可是在test模块中还有，spring data等的配置，直接使用就会产生class找不到的问题。
