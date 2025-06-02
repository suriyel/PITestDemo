mvn配置
```text
-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005
```

plugin工程采用Remote方式Debug

打开插件项目
Run → Edit Configurations

点击 + → Remote JVM Debug

配置参数：

Name: Maven Plugin Debug

Host: localhost

Port: 8000（默认）


再执行mvn
```shell
mvn distributed-pitest:distributed-mutationCoverage
```