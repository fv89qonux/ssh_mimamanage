## 本项目实现的最终作用是基于SSH密码本管理系统平台
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 修改管理员资料
 - 密码管理
 - 管理员登录
### 第2个角色为用户角色，实现了如下功能：
 - 修改个人资料
 - 密码管理
 - 用户登录
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_mimamanage

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_mimamanage](#t_mimamanage) |  |
| [t_user](#t_user) | 用户表 |

**表名：** <a id="t_mimamanage">t_mimamanage</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  3   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  4   | mima |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  5   | bz |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | u_username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | u_password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | u_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 姓名  |
|  5   | u_birthday |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 生日  |
|  6   | u_sex |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 性别  |
|  7   | u_tel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  8   | u_lxr |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 联系人  |
|  9   | u_phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  10   | u_jg |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 籍贯  |
|  11   | u_address |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 家庭地址  |
|  12   | u_bm |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  13   | u_type |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户类型  |
|  14   | u_by_1 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备用字段1  |
|  15   | u_by_2 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备用字段2  |
|  16   | u_by_3 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备用字段3  |
|  17   | u_bz |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 个人信息备注  |

