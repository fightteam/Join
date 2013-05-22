@echo off
echo [Pre-Requirement] Makesure install JDK 6.0+ and set the JAVA_HOME.
echo [Pre-Requirement] Makesure install Maven 3.0.0+ and set the PATH.

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

echo [Step 1] Install all modules to local maven repository.
cd modules
call %MVN% clean install -Dmaven.test.skip=true
if errorlevel 1 goto error
cd ../

echo [Step 2] Generate quickstart archetype and install to local maven repository.
cd examples/quickstart
call %MVN% clean archetype:create-from-project -Dmaven.test.skip=true
if errorlevel 1 goto error

cd target/generated-sources/archetype
call %MVN% clean install
cd ../../../../../

echo [Step 3] Generate fullstart archetype and install to local maven repository.
cd examples/fullstart
call %MVN% clean archetype:create-from-project -Dmaven.test.skip=true
if errorlevel 1 goto error

cd target/generated-sources/archetype
call %MVN% clean install
cd ../../../../../

goto end
:error
echo Error Happen!!
:end
pause