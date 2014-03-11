# join

简单模块化的java开发基础框架。主要是按模块提供了常见的日志、数据操作、权限、web等等的常用工具方法等。

### 背景

在开发avalon的时候发现虽然基于了很多开源框架，但是还是有很多不方便的地方，常见的很多功能依然很繁琐。低层的结构依然不够清晰简洁。所以产生了抽离基础框架的思想。于是产生了这个框架。

### 开发环境

其中涉及的技术：

- JDK7+
- gradle
- maven
- spring framework 4
- spring data
- spring security 3.2
- log4j2
- ...

### 模块

项目主要分成了7个模块，其中core是基础模块，除了test和log模块外都依赖了core模块。

- core : 基础模块，提供常用的抽象对象、工具方法等等。
- log : 提供了日志功能。独立不依赖。
- test : 提供了单元测试的常用功能。独立不依赖。
- dao : 数据库操作相关。-->core
- auth : 权限相关。-->core
- web : web相关。-->core
- rest : web相关。-->core，web, dao

