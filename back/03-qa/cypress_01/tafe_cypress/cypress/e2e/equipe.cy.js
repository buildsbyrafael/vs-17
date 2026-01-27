describe('Gestão de Equipe', () => {
  beforeEach(() => {
    cy.clearLocalStorage()
    cy.visit('/projetos_automacao_cypress%20-%20task/app/index.html')

    cy.get('#username').type('admin')
    cy.get('#password').type('admin123')
    cy.get('#login-ws').click()

    cy.get('#dashboard-container').should('be.visible')

    cy.get('#nav-team').click()
  })

  it('deve validar o carregamento inicial da tabela e estilos', () => {
    cy.contains('h2', 'Gestão de Equipe').should('be.visible')
    cy.get('#team-tbody tr').should('have.length', 4)
    
    cy.contains('th', 'Nome').should('be.visible')
    cy.contains('th', 'Cargo').should('be.visible')
    
    cy.contains('td', 'Ana Silva')
      .parent()
      .find('.badge-success')
      .should('be.visible')
      .and('have.text', 'Active')
  })

  it('deve filtrar membros por nome e cargo', () => {
    cy.get('#search-member').type('Ana')
    cy.get('#team-tbody tr').should('have.length', 1)
    cy.contains('td', 'Ana Silva').should('be.visible')

    cy.get('#search-member').clear().type('Dev')
    cy.get('#team-tbody tr').should('have.length', 2)
    cy.contains('td', 'Carlos Rocha').should('be.visible')
    cy.contains('td', 'João Oliveira').should('be.visible')

    cy.get('#search-member').clear().type('Inexistente')
    cy.get('#team-tbody tr').should('have.length', 0)
  })

  it('deve adicionar um novo membro com sucesso', () => {
    cy.get('#add-member-btn').click()
    cy.get('#team-modal-overlay').should('be.visible')

    cy.get('#team-edit-name').type('Rafael Tester')
    cy.get('#team-edit-role').type('QA Automation')
    cy.get('#team-edit-level').select('Senior')
    
    cy.get('#team-save-btn').click()

    cy.get('#toaster').should('be.visible').and('contain', 'Membro adicionado!')
    cy.get('#team-modal-overlay').should('not.be.visible')
    
    cy.contains('td', 'Rafael Tester').should('be.visible')
    cy.contains('td', 'QA Automation').should('be.visible')
  })

  it('deve editar um membro existente', () => {
    cy.contains('td', 'João Oliveira')
      .parent()
      .find('.edit-btn')
      .click({ force: true })

    cy.get('#team-modal-overlay').should('be.visible')
    cy.contains('h3', 'Editar Membro').should('be.visible')

    cy.get('#team-edit-role').should('be.visible').clear().type('Tech Lead')
    cy.get('#team-save-btn').click()

    cy.get('#toaster').should('be.visible').and('contain', 'Membro atualizado!')
    cy.get('#team-modal-overlay').should('not.be.visible')

    cy.contains('td', 'João Oliveira').parent().should('contain', 'Tech Lead')
  })

  it('deve remover um membro', () => {
    cy.contains('td', 'Beatriz Costa')
      .parent()
      .find('.delete-btn-team')
      .click({ force: true })

    cy.get('#confirm-modal-overlay').should('be.visible')
    cy.get('#confirm-ok-btn').click()

    cy.get('#toaster').should('be.visible').and('contain', 'Membro removido.')
    cy.contains('td', 'Beatriz Costa').should('not.exist')
  })
})