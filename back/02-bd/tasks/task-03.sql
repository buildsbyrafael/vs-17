SELECT *
FROM Pessoa p
RIGHT JOIN Contato c
    ON p.id_pessoa = c.id_pessoa;

SELECT *
FROM Pessoa p
RIGHT JOIN Pessoa_X_Pessoa_Endereco px
    ON p.id_pessoa = px.id_pessoa
RIGHT JOIN Endereco_Pessoa e
    ON px.id_endereco = e.id_endereco;

SELECT *
FROM Pessoa p
RIGHT JOIN Contato c
    ON p.id_pessoa = c.id_pessoa
RIGHT JOIN Pessoa_X_Pessoa_Endereco px
    ON p.id_pessoa = px.id_pessoa
RIGHT JOIN Endereco_Pessoa e
    ON px.id_endereco = e.id_endereco;

SELECT *
FROM Pessoa p
FULL JOIN Contato c
    ON p.id_pessoa = c.id_pessoa;

SELECT *
FROM Pessoa p
FULL JOIN Pessoa_X_Pessoa_Endereco px
    ON p.id_pessoa = px.id_pessoa
FULL JOIN Endereco_Pessoa e
    ON px.id_endereco = e.id_endereco;

SELECT *
FROM Pessoa p
FULL JOIN Contato c
    ON p.id_pessoa = c.id_pessoa
FULL JOIN Pessoa_X_Pessoa_Endereco px
    ON p.id_pessoa = px.id_pessoa
FULL JOIN Endereco_Pessoa e
    ON px.id_endereco = e.id_endereco;

SELECT *
FROM Pessoa p
WHERE EXISTS (
    SELECT 1
    FROM Pessoa_X_Pessoa_Endereco px
    WHERE px.id_pessoa = p.id_pessoa
);

SELECT p.id_pessoa,
       p.nome,
       e.id_endereco,
       e.logradouro
FROM Pessoa p
INNER JOIN Pessoa_X_Pessoa_Endereco px
    ON p.id_pessoa = px.id_pessoa
INNER JOIN Endereco_Pessoa e
    ON px.id_endereco = e.id_endereco;