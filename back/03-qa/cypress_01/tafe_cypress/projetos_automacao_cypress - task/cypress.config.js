const { defineConfig } = require("cypress");

module.exports = defineConfig({
    e2e: {
        // URL base da aplicação
        baseUrl: 'http://localhost:8080',

        // Configurações de Viewport (Tamanho da tela)
        viewportWidth: 1280,
        viewportHeight: 720,

        // Configurações de Gravação e Screenshots
        video: true, // Gravar vídeo em caso de falha (padrão em v13+ depende da flag, mas bom deixar explícito que é possível)
        screenshotOnRunFailure: true, // Tirar print quando falhar

        // Padrão de arquivos de teste
        specPattern: 'cypress/e2e/**/*.cy.{js,jsx,ts,tsx}',

        setupNodeEvents(on, config) {
            // Aqui você pode implementar ouvintes de eventos do Node (plugins)
            // Ex: on('task', { ... })
        },
    },
});
