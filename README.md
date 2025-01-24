## 工程描述

### 技术栈
- springboot 3.x
- jdk17

### 快速开始
- 下载工程代码文件
- 修改目录`src/main/resources/application.yml`下的配置`visual.server`的值。详情见：https://www.yuque.com/geekioe/tuyaiot/kazd2uinmf6tygh8
- 运行启动类：com.tuya.visual.consumer.StartUp.main
- 浏览器访问：http://localhost:8080/visual/token/get
  返回结果如下所示  
  ```
    {
        "success": true,
        "msg": null,
        "t": 1737702810408,
        "data": {
            "deviceVisualTokenList": [
                {
                    "productKey": "wkNCAsnnYSnI6n",
                    "deviceName": "2ac4cffa",
                    "visualToken": "eyJhbGciOiJzI1NiJ9.eyJzdWIiOiJ3a05DQXNubmxzWVNuSTZuIzJhYzRkN2NmZmEiLCJpYXQiOjE3Mzc3MDI4MTAsImV4cCI6MTczNzc4OTIxMH0.iY_GM9oH2PeNO78MwtvBZGJbOE7nEHsCnz2cyC0A22U",
                    "expire": 86400000
                }
            ]
        }
    }
    ```