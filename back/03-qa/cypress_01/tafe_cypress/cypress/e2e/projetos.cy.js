describe('Visualização do Quadro de Projetos', () => {
  beforeEach(() => {
    cy.clearLocalStorage()
    cy.visit('/projetos_automacao_cypress%20-%20task/app/index.html')

    cy.get('#username').type('admin')
    cy.get('#password').type('admin123')
    cy.get('#login-ws').click()

    cy.get('#nav-kanban').click()
  })

  it('deve exibir colunas, contadores e cards corretamente', () => {
    cy.contains('Quadro de Projetos').should('be.visible')

    cy.get('#col-todo').within(() => {
      cy.contains('A Fazer').should('be.visible')
      cy.get('.count').should('contain', '1')
      cy.contains('Criar Testes E2E').should('be.visible')
    })

    cy.get('#col-doing').within(() => {
      cy.contains('Em Andamento').should('be.visible')
      cy.get('.count').should('contain', '1')
      cy.contains('Refatorar CSS').should('be.visible')
    })

    cy.get('#col-done').within(() => {
      cy.contains('Concluído').should('be.visible')
      cy.get('.count').should('contain', '1')
      cy.contains('Configurar CI/CD').should('be.visible')
    })
  })

  it('deve permitir excluir um projeto e atualizar o contador', () => {
    cy.contains('.kanban-card', 'Configurar CI/CD')
      .find('.delete-card-btn')
      .click()
    
    cy.contains('Configurar CI/CD').should('not.exist')
    cy.get('#col-done .count').should('contain', '0')
  })

  it('deve navegar para a aba de equipe', () => {
    cy.get('#nav-team').click()
    cy.contains('h2', 'Gestão de Equipe').should('be.visible')
    cy.get('table').should('be.visible')
  })
})