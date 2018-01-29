# longest-string-ms
REST microservice using SpringBoot and Java8 streams

## How To Build
**Preconditions**: make sure you have Maven and Java8 JDK installed.
1. Clone the repository
2. Navigate to the cloned repository and run 
~~~
mvn clean package
~~~

## How To Run
1. After the build completes successfully, you can start the application by running
~~~
java -jar target/lsms-0.0.1-SNAPSHOT.jar
~~~
This starts the embedded Tomcat server on port 8080 and exposes the REST endpoint "/allLongestStringsStartingWith".

4. (Optional) If you want the server listening on another port, you can pass it as a system property on the command line like this: 
~~~
java -jar -Dserver.port=9876 target/lsms-0.0.1-SNAPSHOT.jar
~~~

## Example REST request
Send the following JSON via HTTP POST to the endpoint: 
URL (with default port): http://localhost:8080/allLongestStringsStartingWith
Payload: 
~~~ json
{
  "inputArray": ["abba", "bab", "ad", "bcd", "aba"]
}
~~~

If everything is set up properly, you should get the following response: 
~~~ json
{
  "result": ["bab","bcd"]
}
~~~
