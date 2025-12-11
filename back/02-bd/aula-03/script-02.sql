SELECT *
FROM Pessoa p
CROSS JOIN Contato c;

SELECT *
FROM Pessoa p
INNER JOIN Contato c
  ON p.id_pessoa = c.id_pessoa;

SELECT *
FROM Pessoa p
INNER JOIN Pessoa_X_Pessoa_Endereco px
  ON p.id_pessoa = px.id_pessoa
INNER JOIN Endereco_Pessoa e
  ON px.id_endereco = e.id_endereco;

SELECT *
FROM Pessoa p
INNER JOIN Contato c
  ON p.id_pessoa = c.id_pessoa
INNER JOIN Pessoa_X_Pessoa_Endereco px
  ON p.id_pessoa = px.id_pessoa
INNER JOIN Endereco_Pessoa e
  ON px.id_endereco = e.id_endereco;

SELECT *
FROM Pessoa p
LEFT JOIN Contato c
  ON p.id_pessoa = c.id_pessoa;

SELECT *
FROM Pessoa p
LEFT JOIN Pessoa_X_Pessoa_Endereco px
  ON p.id_pessoa = px.id_pessoa
LEFT JOIN Endereco_Pessoa e
  ON px.id_endereco = e.id_endereco;

SELECT *
FROM Pessoa p
LEFT JOIN Contato c
  ON p.id_pessoa = c.id_pessoa
LEFT JOIN Pessoa_X_Pessoa_Endereco px
  ON p.id_pessoa = px.id_pessoa
LEFT JOIN Endereco_Pessoa e
  ON px.id_endereco = e.id_endereco;