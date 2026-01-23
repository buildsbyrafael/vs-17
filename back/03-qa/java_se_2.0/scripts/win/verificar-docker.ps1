# ==========================================
# VERIFICADOR DE INSTALAÇÃO DO DOCKER
# ==========================================

Write-Host "🔍 Verificando instalação do Docker..." -ForegroundColor Cyan
Write-Host ""

# 1. Verificar se o comando docker existe
Write-Host "[1/3] Verificando comando 'docker'..." -ForegroundColor Yellow
try {
    $dockerVersion = docker --version 2>$null
    if ($dockerVersion) {
        Write-Host "   ✅ Docker instalado: $dockerVersion" -ForegroundColor Green
    }
    else {
        throw "Docker não encontrado"
    }
}
catch {
    Write-Host "   ❌ Docker não está instalado ou não está no PATH." -ForegroundColor Red
    Write-Host "   Execute 'instalar-docker.ps1' primeiro." -ForegroundColor Yellow
    exit
}

# 2. Verificar se o Docker está rodando
Write-Host "`n[2/3] Verificando se o Docker Desktop está rodando..." -ForegroundColor Yellow
try {
    docker ps 2>$null | Out-Null
    Write-Host "   ✅ Docker Desktop está rodando." -ForegroundColor Green
}
catch {
    Write-Host "   ⚠️  Docker instalado, mas o Docker Desktop não está rodando." -ForegroundColor Yellow
    Write-Host "   Abra o Docker Desktop pelo menu Iniciar." -ForegroundColor Yellow
    exit
}

# 3. Testar com container Hello World
Write-Host "`n[3/3] Testando com container de exemplo..." -ForegroundColor Yellow
try {
    docker run --rm hello-world 2>$null | Out-Null
    Write-Host "   ✅ Docker funcionando perfeitamente!" -ForegroundColor Green
}
catch {
    Write-Host "   ⚠️  Erro ao executar container de teste." -ForegroundColor Red
}

Write-Host "`n🎉 DOCKER PRONTO PARA USO!" -ForegroundColor Cyan
Write-Host "Agora você pode executar 'scripts\win\grid-start.bat' para subir o Selenium Grid."
