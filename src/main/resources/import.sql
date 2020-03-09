insert into categoria (id, nome) values (1, 'Carne');
insert into categoria (id, nome) values (2, 'Frutas e Verduras');
insert into categoria (id, nome) values (3, 'Massa');

insert into produto (id, nome, ultima_compra, valor) values (1,'Frango','2020/01/25','8.89');
insert into produto (id, nome, ultima_compra, valor) values (2, 'Alface', '2019/11/25','2.75');
insert into produto (id, nome, ultima_compra, valor) values (3, 'Banana', '2020/02/05','3.20');
insert into produto (id, nome, ultima_compra, valor) values (4, 'Picanha', '2020/01/30','35.89');
insert into produto (id, nome, ultima_compra, valor) values (5, 'Macarrão Paraty', '2020/01/20','4.20');
insert into produto (id, nome, ultima_compra, valor) values (6, 'Lazanha Nobre', '2020/02/07','9.70');


insert into produto_categoria (produto_id, categoria_id) values (1, 1), (2, 2), (3, 2), (4, 1), (5, 3), (6, 3);


insert into cliente (id, cpf_ou_cnpj, data_ultima_compra, email, natureza, nome, razao_social, status, tipo ) values (1, '17183083020', '2020/01/12', 'adriano@gmail.com', 1, 'Adriano Ramazzotte', null, 1, 1);
insert into cliente (id, cpf_ou_cnpj, data_ultima_compra, email, natureza, nome, razao_social, status, tipo ) values (2, '54724780061','2019/11/20', 'ana@gmail.com', 1, 'Ana', null, 0, 1);
insert into cliente (id, cpf_ou_cnpj, data_ultima_compra, email, natureza, nome, razao_social, status, tipo ) values (3, '75404814000352','2020/12/28', 'prodasa@gmail.com', 2, 'Prodasa', 'Produtos Alimenticios LTDA', 1, 2);


insert into endereco (id, bairro, cep, complemento, logradouro, numero, cliente_id) values (1, 'Monaco', '86702690',null,'Tico tico', 101, 1);
insert into endereco (id, bairro, cep, complemento, logradouro, numero, cliente_id) values (2, 'Flamingos','86702510',null,'Harpia', 68, 1);
insert into endereco (id, bairro, cep, complemento, logradouro, numero, cliente_id) values (3, 'Morumbi', '86702380','ap branco','Guaturamo', 10, 2);
insert into endereco (id, bairro, cep, complemento, logradouro, numero, cliente_id) values (4, 'Aeroporto', '86702000',null,'Parati', 999, 3);
insert into endereco (id, bairro, cep, complemento, logradouro, numero, cliente_id)values (5, 'Centro', '86703000',null,'Av. Arapongas', 250, 3);


insert into usuario (id, login, senha) values (1, 'alex123@gmail.com', '123456');
insert into usuario (id, login, senha) values (2,'ana789@gmail.com','0258963');
insert into usuario (id, login, senha) values (3,'pedro456@gmail.com', 'adr78a9a');

insert into perfil (usuario_id, perfis) values (1, 1), (2, 2),(1, 2) ;

insert into telefone (cliente_id, telefones) values (1,'4398569874');
insert into telefone (cliente_id, telefones) values (1,'43985856595');
insert into telefone (cliente_id, telefones) values (2,'999789878');
insert into telefone (cliente_id, telefones) values (3,'965854587');
















