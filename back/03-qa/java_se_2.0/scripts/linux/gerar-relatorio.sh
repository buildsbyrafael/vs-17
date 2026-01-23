#!/bin/bash
echo "==========================================="
echo "📊 GERANDO RELATÓRIO ALLURE"
echo "==========================================="
echo ""

# Diretório do script
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
PROJECT_ROOT="$SCRIPT_DIR/../.."

# Caminho do Maven Local
MVN_CMD="$PROJECT_ROOT/tools/maven/bin/mvn"

# Verifica se existe
if [ -f "$MVN_CMD" ]; then
    echo "Usando Maven Local: $MVN_CMD"
    # Dá permissão de execução caso tenha se perdido
    chmod +x "$MVN_CMD"
    "$MVN_CMD" allure:serve
else
    echo "❌ Erro: Maven não encontrado em tools/maven/bin/mvn"
    echo "Execute o script 'scripts/linux/setup-ambiente.sh' primeiro."
    exit 1
fi
