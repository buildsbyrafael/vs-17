# ==========================================
# SETUP DE AMBIENTE AUTOMATIZADO (ROBUSTO)
# Autor: Mailton Nascimento
# ==========================================

$ErrorActionPreference = "Stop"
$projectRoot = Get-Location
$toolsDir = Join-Path $projectRoot "tools"
$mavenDir = Join-Path $toolsDir "maven"
$allureDir = Join-Path $toolsDir "allure"

Write-Host "🚀 Iniciando Setup Blindado do Ambiente..." -ForegroundColor Cyan
Write-Host "📂 Diretório do Projeto: $projectRoot" -ForegroundColor Gray

# ---------------------------------------------------------
# 1. VERIFICAR E ATUALIZAR VARIÁVEIS DE AMBIENTE (Auto-Fix)
# ---------------------------------------------------------
Write-Host "`n🔍 Verificando Variáveis de Ambiente..." -ForegroundColor Yellow

# Função para atualizar variável de usuário de forma persistente
function Update-UserEnvironmentVariable {
    param ($name, $newValue)
    
    $currentValue = [Environment]::GetEnvironmentVariable($name, "User")
    
    if ($currentValue -ne $newValue) {
        Write-Host "   ⚠️  Caminho do $name estava incorreto ou não existia." -ForegroundColor DarkYellow
        Write-Host "   🔧 Atualizando para: $newValue" -ForegroundColor Green
        [Environment]::SetEnvironmentVariable($name, $newValue, "User")
        
        # Atualiza na sessão atual também
        [Environment]::SetEnvironmentVariable($name, $newValue, "Process")
    }
    else {
        Write-Host "   ✅ $name está correto." -ForegroundColor Green
    }
}

# 1.1 Configurar MAVEN_HOME
Update-UserEnvironmentVariable "MAVEN_HOME" $mavenDir

# 1.2 Configurar ALLURE_HOME
Update-UserEnvironmentVariable "ALLURE_HOME" $allureDir

# ---------------------------------------------------------
# 2. BAIXAR FERRAMENTAS (Se não existirem)
# ---------------------------------------------------------

# Criar pasta tools se não existir
if (-not (Test-Path $toolsDir)) {
    New-Item -ItemType Directory -Force -Path $toolsDir | Out-Null
}

# 2.1 MAVEN
if (-not (Test-Path "$mavenDir\bin\mvn.cmd")) {
    Write-Host "`n⬇️  Baixando Maven..." -ForegroundColor Cyan
    $mvnUrl = "https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
    $mvnZip = Join-Path $toolsDir "maven.zip"
    
    Invoke-WebRequest -Uri $mvnUrl -OutFile $mvnZip
    Expand-Archive -Path $mvnZip -DestinationPath $toolsDir -Force
    
    # Renomear pasta extraída para 'maven'
    $extracted = Get-ChildItem -Path $toolsDir -Filter "apache-maven-*" | Select-Object -First 1
    Rename-Item -Path $extracted.FullName -NewName "maven"
    Remove-Item $mvnZip
    Write-Host "✅ Maven instalado em tools/maven" -ForegroundColor Green
}
else {
    Write-Host "✅ Maven já instalado." -ForegroundColor Green
}

# 2.2 ALLURE REPORT
if (-not (Test-Path "$allureDir\bin\allure.bat")) {
    Write-Host "`n⬇️  Baixando Allure..." -ForegroundColor Cyan
    $allureUrl = "https://github.com/allure-framework/allure2/releases/download/2.25.0/allure-2.25.0.zip"
    $allureZip = Join-Path $toolsDir "allure.zip"
    
    Invoke-WebRequest -Uri $allureUrl -OutFile $allureZip
    Expand-Archive -Path $allureZip -DestinationPath $toolsDir -Force
    
    # Renomear para 'allure'
    $extracted = Get-ChildItem -Path $toolsDir -Filter "allure-*" | Where-Object { $_.PSIsContainer } | Select-Object -First 1
    Rename-Item -Path $extracted.FullName -NewName "allure"
    Remove-Item $allureZip
    Write-Host "✅ Allure instalado em tools/allure" -ForegroundColor Green
}
else {
    Write-Host "✅ Allure já instalado." -ForegroundColor Green
}

# ---------------------------------------------------------
# 3. VERIFICAÇÃO FINAL
# ---------------------------------------------------------
Write-Host '`n🎉 Ambiente Configurado com Sucesso!' -ForegroundColor Cyan
Write-Host '⚠️  IMPORTANTE: Se você moveu a pasta do projeto, as variáveis foram corrigidas.'
Write-Host '💡 Dica: Reinicie seu terminal (VS Code) para que as novas variáveis tenham efeito global.'
Write-Host '   Ou use os scripts na pasta "scripts/win" que usam os caminhos locais automaticamente.'
