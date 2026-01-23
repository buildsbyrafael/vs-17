#!/bin/bash
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
cd "$SCRIPT_DIR/../.."

echo "🛑 Parando Selenium Grid..."
docker-compose down
echo "✅ Grid parado."
