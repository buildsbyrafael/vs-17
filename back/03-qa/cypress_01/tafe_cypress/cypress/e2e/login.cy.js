import dataLogin from '../fixtures/loginData.json'

describe('Login TaskMaster', () => {
  
  beforeEach(() => {
    cy.visit('projetos_automacao_cypress - task/app/index.html')
  })

  context('Login', () => {
    
    it('Validar login com sucesso', () => {
      const data = dataLogin.user_valido
      cy.get('#username').type(data.user)
      cy.get('#password').type(data.pass)
      cy.get('#login-ws').click()
      cy.contains(data.text).should('be.visible')
    })

    it('Validar login com usuário inválido', () => {
      const data = dataLogin.user_invalido
      cy.get('#username').type(data.user)
      cy.get('#password').type('admin123')
      cy.get('#login-ws').click()
      cy.contains(data.text).should('be.visible')
    })

    it('Validar login com senha inválida', () => {
      const data = dataLogin.user_valido
      cy.get('#username').type(data.user)
      cy.get('#password').type('senhaerrada')
      cy.get('#login-ws').click()
      cy.contains('Usuário ou senha inválidos').should('be.visible')
    })

    it('Validar login com campos vazios', () => {
      cy.get('#login-ws').click()
      cy.get('#username').should('match', ':invalid')
    })

    it('Realizar logout com sucesso', () => {
      const data = dataLogin.user_valido
      cy.get('#username').type(data.user)
      cy.get('#password').type(data.pass)
      cy.get('#login-ws').click()
      cy.get('#logout-btn').click()
      cy.get('#login-ws').should('be.visible')
    })

  })
})