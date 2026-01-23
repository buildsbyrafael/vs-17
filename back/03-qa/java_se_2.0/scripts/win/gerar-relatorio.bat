@echo off
echo ===========================================
echo GERANDO RELATÓRIO ALLURE
echo ===========================================
echo.

REM Volta 2 niveis para a raiz do projeto
cd ..\..

echo Buscando Maven em local relativo...

REM Verifica se existe
if not exist "tools\maven\bin\mvn.cmd" (
    echo [ERRO] Maven nao encontrado em tools\maven\bin\mvn.cmd
    echo Execute scripts\win\setup-ambiente.bat primeiro.
    pause
    exit
)

REM Executa usando call
call tools\maven\bin\mvn.cmd allure:serve

pause
