#!/bin/bash

# ==========================================
# SETUP DE AMBIENTE (LINUX/MAC)
# ==========================================

# Pegar diretório atual do script e normalizar paths
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
PROJECT_ROOT="$SCRIPT_DIR/../.."
TOOLS_DIR="$PROJECT_ROOT/tools"
MAVEN_DIR="$TOOLS_DIR/maven"
ALLURE_DIR="$TOOLS_DIR/allure"

# Versões
MAVEN_VERSION="3.9.6"
ALLURE_VERSION="2.25.0"

echo -e "\033[0;36m🚀 Iniciando Setup de Ambiente (Linux/Mac)...\033[0m"

# Criar pasta tools
mkdir -p "$TOOLS_DIR"

# --- MAVEN ---
if [ ! -d "$MAVEN_DIR/bin" ]; then
    echo -e "\n\033[0;33m⬇️  Baixando Maven $MAVEN_VERSION...\033[0m"
    wget -q --show-progress "https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.zip" -O "$TOOLS_DIR/maven.zip"
    
    echo "Extraindo..."
    unzip -q -o "$TOOLS_DIR/maven.zip" -d "$TOOLS_DIR"
    
    # Renomear e limpar
    rm -rf "$MAVEN_DIR"
    mv "$TOOLS_DIR/apache-maven-$MAVEN_VERSION" "$MAVEN_DIR"
    rm "$TOOLS_DIR/maven.zip"
    
    # Dar permissão de execução
    chmod +x "$MAVEN_DIR/bin/mvn"
    echo -e "\033[0;32m✅ Maven instalado.\033[0m"
else
    echo -e "\033[0;32m✅ Maven já instalado.\033[0m"
fi

# --- ALLURE ---
if [ ! -d "$ALLURE_DIR/bin" ]; then
    echo -e "\n\033[0;33m⬇️  Baixando Allure $ALLURE_VERSION...\033[0m"
    wget -q --show-progress "https://github.com/allure-framework/allure2/releases/download/$ALLURE_VERSION/allure-$ALLURE_VERSION.zip" -O "$TOOLS_DIR/allure.zip"
    
    echo "Extraindo..."
    unzip -q -o "$TOOLS_DIR/allure.zip" -d "$TOOLS_DIR"
    
    # Renomear e limpar
    rm -rf "$ALLURE_DIR"
    mv "$TOOLS_DIR/allure-$ALLURE_VERSION" "$ALLURE_DIR"
    rm "$TOOLS_DIR/allure.zip"
    
    # Dar permissão
    chmod +x "$ALLURE_DIR/bin/allure"
    echo -e "\033[0;32m✅ Allure instalado.\033[0m"
else
    echo -e "\033[0;32m✅ Allure já instalado.\033[0m"
fi

echo -e "\n\033[0;36m🎉 Setup Concluído!\033[0m"
echo "Para usar os comandos nesta sessão, execute:"
echo -e "\033[0;35mexport PATH=\"$MAVEN_DIR/bin:$ALLURE_DIR/bin:\$PATH\"\033[0m"
