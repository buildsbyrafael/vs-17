@echo off
echo Verificando status dos containers...
cd ..\..
docker-compose ps
pause
