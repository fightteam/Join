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
