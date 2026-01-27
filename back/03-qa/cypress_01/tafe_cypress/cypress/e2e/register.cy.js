describe('Cadastro de Usuário', () => {

  beforeEach(() => {
    cy.visit('projetos_automacao_cypress - task/app/index.html')
    cy.get('#goto-register').click()
  })

  it('Deve cadastrar um novo usuário com sucesso', () => {
    const randomID = Date.now()
    const userName = `User ${randomID}`
    const userLogin = `user_${randomID}`

    cy.get('#reg-name').type(userName)
    cy.get('#reg-user').type(userLogin)
    cy.get('#reg-pass').type('123456')
    
    cy.get('#register-btn').click()

    cy.get('#login-container').should('be.visible')
    cy.get('#register-container').should('not.be.visible')
  })

  it('Deve falhar ao tentar registrar usuário existente', () => {
    cy.get('#reg-name').type('Administrador')
    cy.get('#reg-user').type('admin')
    cy.get('#reg-pass').type('123456')
    
    cy.get('#register-btn').click()

    cy.get('#register-container').should('be.visible')
    cy.get('#login-container').should('not.be.visible')
  })
})