


#!/bin/sh

cd hw1
mvn clean package
java -jar ./target/hw3_base_operation.jar

cd ../

cd hw2
mvn clean package
java -jar ./target/hw3_base_operation.jar

cd ../

cd hw3
mvn clean package
java -jar target/hw3_base_operation.jar