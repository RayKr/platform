## 博亚论坛数据库设计文档 

### 数据库设计思路

基本论坛功能，需满足用户发帖、查看帖子、针对帖子的相关操作，所以面向的对象可以划分为 `用户` 、`帖子（文章/主题）`、 `回帖（回复/评论）`、 `帖子分类` 等。

并且为了拓展方便，不用改动原表结构，需对每个主表增加一个对应的扩展表 `xxxxmeta`，存储的是`key-value` 键值对的数据。

### 数据库字段

#### 帖子表（forum_post）

id：自增唯一ID
post_author：对应作者ID
post_date：发布时间
post_date_gmt：发布时间（GMT+0时间）
post_content：正文
post_title：标题
post_name：文章缩略名
post_excerpt：摘录
post_status：文章状态（publish/auto-draft/inherit等）
post_password：文章密码
post_modified：修改时间
post_modified_gmt：修改时间（GMT+0时间）
post_mime_type：MIME类型

comment_status：评论状态（open/closed）
comment_count：评论总数
like_count：点赞总数
read_count：阅读总数

menu_order：排序ID

#### 评论表（forum_comment）

id：自增唯一ID（楼层数就是id）
gmt_create: 
gmt_modified:
comment_post_id：对应文章ID
comment_user_id：评论者ID
comment_ip：评论者IP
comment_date：评论时间
comment_date_gmt：评论时间（GMT+0时间）
comment_content：评论正文
comment_approved：评论是否被批准
comment_agent：评论者的USER AGENT
comment_parent：父评论ID

#### 帖子分类（forum_term）

id：自增唯一ID
gmt_create: 
gmt_modified:
term_name：分类名
term_slug：缩略名

#### 分类与文章关联表（forum_term_relationship）

id：自增唯一ID
gmt_create: 
gmt_modified:
post_id：对应文章ID
term_id：对应分类方法ID

#### 用户关系表（forum_user_relationship）

用来实现社交功能中的关注

id：自增唯一ID
gmt_create: 
gmt_modified:
user_id: 被关注人id
follower_id: 关注人（粉丝）id