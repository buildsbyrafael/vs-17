describe('Meu Perfil', () => {
  beforeEach(() => {
    cy.clearLocalStorage()
    cy.visit('/projetos_automacao_cypress%20-%20task/app/index.html')

    cy.get('#username').type('admin')
    cy.get('#password').type('admin123')
    cy.get('#login-ws').click()

    cy.get('#nav-profile').click()
  })

  it('deve atualizar informações do perfil e persistir dados após navegação', () => {
    cy.contains('h2', 'Meu Perfil').should('be.visible')

    cy.get('#profile-name').clear().type('Admin Atualizado')
    cy.get('#profile-phone').clear().type('(11) 99999-8888')
    cy.get('#profile-bio').clear().type('QA Automation Engineer em treinamento.')

    cy.get('#add-skill').type('Cypress{enter}')
    cy.get('#add-skill').type('JavaScript{enter}')

    cy.get('#save-profile').click()

    cy.get('#toaster').should('be.visible').and('contain', 'Perfil atualizado com sucesso!')
    
    cy.get('#nav-settings').click()
    cy.contains('h2', 'Configurações').should('be.visible')

    cy.get('#nav-profile').click()
    cy.contains('h2', 'Meu Perfil').should('be.visible')

    cy.get('#profile-name').should('have.value', 'Admin Atualizado')
    cy.get('#profile-phone').should('have.value', '(11) 99999-8888')
    cy.get('#profile-bio').should('have.value', 'QA Automation Engineer em treinamento.')
    
    cy.contains('.tag', 'Cypress').should('be.visible')
    cy.contains('.tag', 'JavaScript').should('be.visible')
  })
})