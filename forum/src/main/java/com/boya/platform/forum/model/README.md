## 说明

[PO、POJO、BO、DTO等在项目中的含义（整理）](http://blog.csdn.net/gashli/article/details/40951437)

> BO（Business Object） ：业务对象。由 Service 层输出的封装业务逻辑的对象。

所以 `/bo` 文件夹存放 `Service` 层传递业务逻辑的对象。

> VO（View Object） ：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。

所以 `/vo` 文件夹存放与 `页面` 互相 `映射` 的对象。

> DO（Data Object） ：与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。

此处用 `/po` 代替 `bo` 作为文件夹名称，放置 `mybatis-generator` 自动生成的实体。

> DTO( Data Translate Object )：传输给前端所需的数据的载体类

