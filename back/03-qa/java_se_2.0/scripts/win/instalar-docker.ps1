# Assistente de Instalacao do Docker Desktop
# Autor: Mailton Nascimento

Write-Host "Assistente de Instalacao do Docker Desktop" -ForegroundColor Cyan
Write-Host ""

# Verificar Virtualizacao
Write-Host "[1/4] Verificando suporte a virtualizacao..." -ForegroundColor Yellow
$virtualization = Get-ComputerInfo | Select-Object -ExpandProperty HyperVisorPresent

if ($virtualization) {
    Write-Host "   OK: Virtualizacao habilitada" -ForegroundColor Green
}
else {
    Write-Host "   AVISO: Virtualizacao NAO detectada." -ForegroundColor Red
    Write-Host "   Habilite Intel VT-x ou AMD-V no BIOS." -ForegroundColor Yellow
}

# Verificar Windows
Write-Host "`n[2/4] Verificando versao do Windows..." -ForegroundColor Yellow
$osVersion = [System.Environment]::OSVersion.Version
if ($osVersion.Major -ge 10) {
    Write-Host "   OK: Windows 10/11 detectado" -ForegroundColor Green
}
else {
    Write-Host "   ERRO: Docker requer Windows 10 ou superior." -ForegroundColor Red
    exit
}

# Abrir download
Write-Host "`n[3/4] Abrindo pagina de download..." -ForegroundColor Yellow
Start-Process "https://www.docker.com/products/docker-desktop"
Write-Host "   OK: Pagina aberta no navegador." -ForegroundColor Green

# Instrucoes
Write-Host "`n[4/4] PROXIMOS PASSOS:" -ForegroundColor Cyan
Write-Host "   1. Clique em 'Download for Windows'"
Write-Host "   2. Execute o instalador baixado"
Write-Host "   3. Marque 'Use WSL 2 instead of Hyper-V'"
Write-Host "   4. Reinicie o PC quando solicitado"
Write-Host "   5. Execute 'verificar-docker.ps1' apos reiniciar"
Write-Host ""
Write-Host "Tempo estimado: 10-15 minutos" -ForegroundColor Gray
