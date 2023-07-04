
insert into pessoa (nome,sobrenome)
values ('Manel', 'Delas'),('Caique', 'Delas'), ('Caio', 'Fernandes');

insert into contato (pessoa_id, "tipo", valor)
values (1, 'TELEFONE', '123456789'), (2, 'EMAIL','caiquedelas@outlook.com'), (3, 'TELEFONE','987654321');

insert into contato (pessoa_id, "tipo", valor)
values (1, 'TELEFONE', '456789321'), (2, 'TELEFONE', '693287412');

insert into endereco (pessoa_id, cidade,estado,bairro, rua, numero)
values (1, 'Fortaleza','Ceara','TwoPark','Rua 110', '210'),(2,'Fortaleza','Ceara','PerizIta', 'Rua Cavalcante','133') ,(3, 'Quixada','Ceara','ParkTwo','Rua C','255');
