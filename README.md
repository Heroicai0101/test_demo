## Quick Start

### 一、环境准备

1、启动本机MySQL 3306端口，初始化数据库准备

> SQL见 transfer-api 模块 src/main/resources/sql/demo.sql
> 说明：asset_account表 和 transfer_event表应该同属于发起转账方的库，而transfer_event表则属于转账收款方的表，工程中为了避免多数据源写多个Mapper文件，实际上偷懒将这三者放一个数据库了 ，但本质上还是将这三者看做不同的库来做分布式事务的。


2、启动本机redis
> 工程里面用到了基于redis实现的分布式锁
```shell
nohup ./redis-server &
```

3、启动工程transfer-api
启动成功后, 访问`http://localhost:8080/swagger-ui.html` , 即可看到熟悉的`swagger-ui`界面 


4、测试转账接口
利用Swagger界面测试转账接口

> POST `http://localhost:8080/api/v1/transfer`

```json
{
  "amount": 100,
  "oppositeUserId": 2,
  "selfUserId": 1,
  "token": "1234567",
  "transactionNo": "100_20200621001"
}
```
