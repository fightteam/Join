# 权限

基于spring security 3.2的权限管理，提供一个比较适合扩展的RBAC模型，如果是通常的扩展权限，这样的模型基本上可以通用。

### 什么是RBAC？

#### 设计实现

权限来源于操作（operation）与资源（resource），加载权限配置来源于权限许可（permission）和角色（role）

permission->operation,resource

spring security->permission，role

user->role-->roleGroup,permission-->permissionGroup

### 对象模型

### 权限配置

权限资源主要分成了4种，4种的配置方式不同。根据不同的方式配置权限。

#### URL权限配置


#### 方法权限配置

### 关于初始化

