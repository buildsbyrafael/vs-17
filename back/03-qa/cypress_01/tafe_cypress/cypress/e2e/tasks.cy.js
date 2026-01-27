import dataLogin from '../fixtures/loginData.json'

describe('Gerenciamento de Tarefas', () => {

  beforeEach(() => {
    cy.visit('projetos_automacao_cypress - task/app/index.html')
    const user = dataLogin.user_valido
    cy.get('#username').type(user.user)
    cy.get('#password').type(user.pass)
    cy.get('#login-ws').click()
    cy.get('#welcome-msg').should('be.visible')
  })

  it('Deve adicionar uma nova tarefa', () => {
    const taskName = 'Tarefa de Teste Cypress'
    
    cy.get('#new-task').type(taskName)
    cy.get('#add-task-btn').click()
    
    cy.contains('.task-text', taskName).should('be.visible')
  })

  it('Deve concluir uma tarefa', () => {
    cy.contains('.task-text', 'Aprender Cypress')
      .parent()
      .find('.check-btn')
      .click()

    cy.contains('.task-text', 'Aprender Cypress')
      .should('have.class', 'completed')
  })

  it('Deve excluir uma tarefa', () => {
    cy.contains('.task-text', 'Criar Page Objects')
      .parents('.task-item')
      .find('.delete')
      .click()
    
    cy.get('#confirm-modal-overlay').should('be.visible')
    cy.get('#confirm-ok-btn').click()

    cy.contains('Criar Page Objects').should('not.exist')
  })
})