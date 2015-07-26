# ValueReporter-LoadGenerator
Generate traffic to ValueReporter. May use ValueReporter-agent to provide the load

Startup
=====

__Standalone:__
```
mvn clean package
java -jar target/load-generator-0.1-SNAPSHOT.jar 
```
__With Valuereporter-agent:__

```
java -javaagent:../valuereporter-agent/valuereporter-agent-jar-with-dependencies.jar= \
base.package:com.example,load.host:localhost,valuereporter.port:4901,prefix:myService \
 -jar target/load-generator-0.1-SNAPSHOT.jar
```
