@echo off
echo Iniciando Selenium Grid...
cd ..\..
docker-compose up -d
echo Grid iniciado! Acesse: http://localhost:4444
pause
