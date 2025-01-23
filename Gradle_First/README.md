Setup of basic gradle using cli:

gradle init --use-defaults --type java-application

The above command will setup a basic gradle project

./gradlew build

To prepare a jar which is executable, you need to setup manifest property in build.gradle to identify what is the main class to execute

jar{
 manifest {
attributes(
'Main-Class':'org.example.Main'
)
}
}

The above command can build your project

./gradlew jar

The above command creates a new jar file in build/libs folder

java -jar build/libs/filename.jar

The above command will execute your code