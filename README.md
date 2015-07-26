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
java -javaagent:../Valuereporter-Agent/target/valuereporter-agent-jar-with-dependencies.jar=\
base.package:org.dummy,load,valuereporter.host:localhost,valuereporter.port:4901,prefix:dummy-load \
 -jar target/load-generator-0.1-SNAPSHOT.jar
```
