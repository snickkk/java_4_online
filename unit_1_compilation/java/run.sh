#!/bin/sh

echo 'run java'

. ./remove-class.sh

echo 'run level 1'

echo 'run simple'
cd ./level_1/simple
javac Hello.java
java Hello

cd ../

echo 'run package'
cd ./package
javac ua/com/alevel/BestUnit.java
java ua.com.alevel.BestUnit

cd ../

echo 'run separate packages'
cd ./separate_packages
javac ua/com/alevel/BestUnit.java
java ua.com.alevel.BestUnit

cd ../

echo 'run minimal proj'
cd ./minimal_proj
javac -sourcepath ./src -d build/classes ./src/ua/com/alevel/BestUnit.java
java -cp build/classes ua.com.alevel.BestUnit

cd ../

echo 'run med proj and create simple jar'
cd ./med_proj
javac -sourcepath ./src -d build/classes ./src/ua/com/alevel/BestUnit.java
jar cvfm build/jar/hello.jar resources/MANIFEST.MF -C build/classes .
java -jar build/jar/BestUnit.jar
cd ../../

. ./remove-class.sh


