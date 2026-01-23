@echo off
echo ===========================================
echo SETUP DE AMBIENTE (WINDOWS BATCH)
echo ===========================================
echo.

REM Define variaveis locais
set "PROJECT_ROOT=%~dp0..\.."
set "TOOLS_DIR=%PROJECT_ROOT%\tools"
set "MAVEN_DIR=%TOOLS_DIR%\maven"
set "ALLURE_DIR=%TOOLS_DIR%\allure"

echo [1/3] Configurando Variaveis de Ambiente...

REM Configura MAVEN_HOME permanentemente
setx MAVEN_HOME "%MAVEN_DIR%"
echo MAVEN_HOME definido para: %MAVEN_DIR%

REM Configura ALLURE_HOME permanentemente
setx ALLURE_HOME "%ALLURE_DIR%"
echo ALLURE_HOME definido para: %ALLURE_DIR%

echo.
echo [2/3] Verificando Ferramentas...

if not exist "%MAVEN_DIR%\bin\mvn.cmd" (
    echo [AVISO] Maven nao encontrado!
    echo Para baixar as ferramentas automaticamente, execute o script:
    echo setup-ambiente.ps1 (na raiz do projeto)
    echo.
) else (
    echo [OK] Maven encontrado.
)

if not exist "%ALLURE_DIR%\bin\allure.bat" (
    echo [AVISO] Allure nao encontrado!
) else (
    echo [OK] Allure encontrado.
)

echo.
echo [3/3] Concluido!
echo Reinicie seu terminal para as variaveis fazerem efeito.
pause
