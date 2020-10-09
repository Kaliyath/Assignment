@echo off
rem ---------------------------------------------------------------------------
rem Start script for the mathcaptcha application
rem ---------------------------------------------------------------------------

setlocal

IF EXIST mathcaptcha (
echo [INFO] Execution starting ...
cd mathcaptcha
echo [INFO] Change directory to mathcaptcha
) ELSE (
echo [ERR] Application folder not found. 
echo [ERR] Cannot find " mathcaptcha " directory 
echo [ERR] Please check your current directory
@pause
exit 
)

echo [INFO] Maven command (mvn clean) execution starting ...

call mvn clean

echo [INFO] Maven command (mvn clean) execution completed successfully 

echo [INFO] Maven command (mvn clean install) execution starting ...

call mvn clean install

echo [INFO] Maven command (mvn clean install) execution completed successfully

echo [INFO] Spring boot application is starting ... 

call mvn spring-boot:run

rem mvn test

@pause