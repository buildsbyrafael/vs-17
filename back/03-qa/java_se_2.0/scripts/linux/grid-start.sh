#!/bin/bash
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
cd "$SCRIPT_DIR/../.."

echo "🚀 Iniciando Selenium Grid..."
docker-compose up -d
echo "✅ Grid iniciado! Acesse: http://localhost:4444"
