create database sgesp




CREATE TABLE Estado(
	IdEstado INT PRIMARY KEY IDENTITY,
	Estado VARCHAR(20),
	Uf VARCHAR(2)
)

CREATE TABLE Cidade(
	IdCidade INT PRIMARY KEY IDENTITY,
	Cidade VARCHAR(30),
	IdUf INT
		FOREIGN KEY (IdUf)
		REFERENCES Estado (IdEstado)
)






CREATE TABLE PessoaFisica(
	IdPessoaFisica INT PRIMARY KEY IDENTITY,
	Nome VARCHAR(50),
	CPF VARCHAR(14),
	RG VARCHAR(9),
	Endereco VARCHAR(50),
	IdCidade INT
		FOREIGN KEY (IdCidade)
		REFERENCES Cidade (IdCidade),
	Cep VARCHAR(9),
	Email VARCHAR(30),
    Telefone VARCHAR(20),
	Celular  varchar (20)
	
)

CREATE TABLE PessoaJuridica(
	IdPessoaJuridica INT PRIMARY KEY IDENTITY,
	RazaoSocial VARCHAR(50),
	Fantasia VARCHAR(50),
	Cnpj VARCHAR(14),
	Ir VARCHAR(12),
	Endereco VARCHAR(50),
	IdCidade INT
		FOREIGN KEY (IdCidade)
		REFERENCES Cidade (IdCidade),
	Cep VARCHAR(9),
	Email VARCHAR(30),
        Telefone VARCHAR(20),
	Celular  varchar (20)
	
)	

CREATE TABLE Funcinario(
	IdFuncionario INT PRIMARY KEY IDENTITY,
	IdPessoaFisica INT
		FOREIGN KEY (IdPessoaFisica)
		REFERENCES PessoaFisica (IdPessoaFisica),
	Carteira VARCHAR(30),
	Data_Admissao varchar(10),
	Data_Demissao varchar(10),
	Usuario VARCHAR(30),
	Senha VARCHAR(255),
	Administrador VARCHAR(1)
	
)

CREATE TABLE Fornecedor(
	IdFornecedor INT PRIMARY KEY IDENTITY,
	IdPessoaJuridica INT
		FOREIGN KEY (IdPessoaJuridica)
		REFERENCES PessoaJuridica (IdPessoaJuridica),
        Materiais varchar (100)
)


CREATE TABLE Componente(
	IdComponente INT PRIMARY KEY IDENTITY,
	Descricao VARCHAR(30),
	VlrCompra FLOAT,
	Estoque INT,
	EstoqueMinimo INT 
)


CREATE TABLE Produto(
	IdProduto INT PRIMARY KEY IDENTITY,
	Descricao VARCHAR(30),
	VlrVenda REAL
)


CREATE TABLE ComponentesProduto(
	IdComponentesProduto INT PRIMARY KEY IDENTITY,
	IdComponente INT
		FOREIGN KEY (IdComponente)
		REFERENCES Componente (IdComponente),
	IdProduto INT
		FOREIGN KEY (IdProduto)
		REFERENCES Produto (IdProduto),
	Quantidade INT
)

CREATE TABLE CompForne(
	IdProdForne INT PRIMARY KEY IDENTITY,
	IdComponente INT
		FOREIGN KEY (IdComponente)
		REFERENCES Componente (IdComponente),
	IdFornecedor INT
		FOREIGN KEY (IdFornecedor)
		REFERENCES Fornecedor (IdFornecedor)
)


CREATE TABLE OrdemProducao(
	IdOrdemProducao INT PRIMARY KEY IDENTITY,
	IdPessoaJuridica INT
		FOREIGN KEY (IdPessoaJuridica) 
		REFERENCES PessoaJuridica (IdPessoaJuridica), 
	IdProduto INT
		FOREIGN KEY (IdProduto)
		REFERENCES Produto (IdProduto),
	Quantidade INT,
	DataSolicitacao  VARCHAR(10),
	Concluido VARCHAR(1),
	DataFinalizacao VARCHAR(10)
)


CREATE TABLE CompraCab(
	IdCompraCab INT PRIMARY KEY IDENTITY,
	IdComponente int ,
        Descricao varchar (40) ,
	vlrUltima float ,
	Data varchar (12) ,
	Quantidade int 
)

CREATE TABLE CompraDet(
	IdCompraDet INT PRIMARY KEY IDENTITY,
	IdCompraCab INT
		FOREIGN KEY (IdCompraCab)
		REFERENCES CompraCab (IdCompraCab),
	IdComponente INT
		FOREIGN KEY (IdComponente )
		REFERENCES Componente (IdComponente),
	ValorCompra REAL,
	QTD INT
)

CREATE TABLE VendaCab(
	IdVendaCab INT PRIMARY KEY IDENTITY,
	IdOrdemProducao INT
		FOREIGN KEY (IdOrdemProducao)
		REFERENCES OrdemProducao (IdOrdemProducao),
	Data DATE,
	Total FLOAT
)



-- fazer estes insets antes 

    -- insert estados 

insert into Estado values ('Sao Paulo','SP')
insert into Estado values ('Rio de Janeiro','RJ')
insert into Estado values ('Paraná','PR')
insert into Estado values ('Rio grande do sul','RS')

-- insert cidades 
insert into Cidade values ('Itapui',1)
insert into Cidade values ('Pederneiras',1)
insert into Cidade values ('Bauru',1)
insert into Cidade values ('Jau',1)
insert into Cidade values ('Macatuba',1)
insert into Cidade values ('Porto Alegre',4)
insert into Cidade values ('Curitiba',3)

-- insert pessoa fisica 
insert into PessoaFisica values('Deivis','35082979850','43666267','rua jose ruiz corral s -740',1 ,'17280000','deivisvp@gmail.com','(14)3283-1385','(14)99785-4512')
insert into PessoaFisica values('Matheus','45882979850','48658267','rua jose  corral s -940',1 ,'17290000','matheus@gmail.com','(14)3277-7885','(14)98745-5210')
insert into PessoaFisica values('Edevandro','99882542145','45269874','avenida brasil o-654',3 ,'17280000','edevandro@gmail.com','(14)3283-1478','(14)99654-4732')
insert into PessoaFisica values('Marcos','45124578454','102541789','avenida paulista l-12',2 ,'18250000','marcos@gmail.com','(15)3247-2033','(14)99541-1200')
insert into PessoaFisica values('Paulo','302124554789','35069874','rua :Brasil metal 0 -567',4 ,'3200000','paulo@gmail.com','(21)3654-7410','(21)981184566')
insert into PessoaFisica values('Marquito','475896321','120457845','avenida rota 66',2 ,'11745200','Quito@gmail.com','(44)3210-1455','(55)95647-1245')

--insert pessoa juridica 
select * from PessoaJuridica
insert into PessoaJuridica values('Deivis', 'SGESP', '35082979850','43666267','rua jose ruiz corral s -740',1 ,'17280000','deivisvp@gmail.com','(14)3283-1385','(14)99785-4512')
insert into PessoaJuridica values('Matheus', 'SisPhoddinha', '45882979850','48658267','rua jose  corral s -940',1 ,'17290000','matheus@gmail.com','(14)3277-7885','(14)98745-5210')
insert into PessoaJuridica values('Edevandro', 'Induzidos', '99882542145','45269874','avenida brasil o-654',3 ,'17280000','edevandro@gmail.com','(14)3283-1478','(14)99654-4732')
insert into PessoaJuridica values('Marquito', 'QuitinhoTI', '475896321','120457845','avenida rota 66',2 ,'11745200','Quito@gmail.com','(44)3210-1455','(55)95647-1245')
insert into PessoaJuridica values('Marcos', 'MaquinhoTI', '45124578454','102541789','avenida paulista l-12',2 ,'18250000','marcos@gmail.com','(15)3247-2033','(14)99541-1200')
insert into PessoaJuridica values('Menininho', 'Virgula', '35082979850','43666267','rua jose ruiz corral s -740',1 ,'17280000','deivisvp@gmail.com','(14)3283-1385','(14)99785-4512')


--insert funcionario 
insert into Funcinario values (1,'6547895','27/08/2012','20/10/2015','zubat',HASHBYTES('MD5', 'metal'),'S')
insert into Funcinario values (2,'54785','1410/2012','25/08/2015','matheus',HASHBYTES('MD5', 'boiola'),'S')
insert into Funcinario values (3,'54785','12/10/2014','10/10/2015','1',HASHBYTES('MD5', '1'),'S')
insert into Funcinario values (4,'201544','10/01/2011','22/12/2014','2',HASHBYTES('MD5', '2'),'N')

--insert fornecedor
select * from Fornecedor
insert into Fornecedor values (3)
insert into Fornecedor values (4)
insert into Fornecedor values (5)

--insert componente
select * from Componente
insert into Componente values ('Porca M8', 0.50, 100, 50)
insert into Componente values ('Parafuso M8', 0.50, 100, 50)
insert into Componente values ('Arruela M8', 0.50, 100, 50)
insert into Componente values ('Porca M9', 0.50, 100, 50)
insert into Componente values ('Parafuso M9', 0.50, 100, 50)
insert into Componente values ('Arruela M9', 0.50, 100, 50)
insert into Componente values ('Porca M10', 0.50, 100, 50)
insert into Componente values ('Parafuso M10', 0.50, 100, 50)
insert into Componente values ('Arruela M10', 0.50, 100, 50)
insert into Componente values ('Porca M11', 0.50, 100, 50)
insert into Componente values ('Parafuso M11', 0.50, 100, 50)
insert into Componente values ('Arruela M11', 0.50, 100, 50)
insert into Componente values ('Porca M12', 0.50, 100, 50)
insert into Componente values ('Parafuso M12', 0.50, 100, 50)
insert into Componente values ('Arruela M12', 0.50, 100, 50)
insert into Componente values ('Fio Azul 2mm', 0.50, 100, 50)
insert into Componente values ('Fio Amarelo 2mm', 0.50, 100, 50)
insert into Componente values ('Fio Vermelho 2mm', 0.50, 100, 50)
insert into Componente values ('Fio Azul 4mm', 0.50, 100, 50)
insert into Componente values ('Fio Amarelo 4mm', 0.50, 100, 50)
insert into Componente values ('Fio Vermelho 4mm', 0.50, 100, 50)
insert into Componente values ('Chapa 100mmX100mm', 0.50, 100, 50)
insert into Componente values ('Chapa 200mmX200mm', 0.50, 100, 50)
insert into Componente values ('Chapa 300mmX300mm', 0.50, 100, 50)
insert into Componente values ('Chapa 400mmX400mm', 0.50, 100, 50)
insert into Componente values ('parafuso sestavado m15', 0.80, 30, 80)
insert into Componente values ('parafuso sestavado m16', 0.90, 20, 50)
insert into Componente values ('parafuso brocante 5/16', 0.17, 100, 200)
insert into Componente values ('parafuso brocante 3/8', 0.22, 50, 90)
insert into Componente values ('arruela de pressao 3/8', 0.25, 20, 50)
insert into Componente values ('arruela de pressao 1/2', 0.50, 40, 80)
--
insert into Componente values ('laminas de cobre ', 0.30, 2000, 100)
insert into Componente values ('folha de fibra ', 1.50, 300, 50)
insert into Componente values ('coletor de omega', 5.30, 100, 20)
insert into Componente values ('coletor de palio', 4.50, 100, 20)
insert into Componente values ('coletor de gol', 3.30, 100, 20)
insert into Componente values ('coletor de monza', 7.30, 100, 20)
insert into Componente values ('coletor de fusca', 2.50, 100, 20)
insert into Componente values ('eixo de omega', 4.00, 100, 20)
insert into Componente values ('eixo de palio', 3.00, 100, 20)
insert into Componente values ('eixo de gol', 3.50, 100, 20)
insert into Componente values ('eixo de monza', 5.00, 100, 20)
insert into Componente values ('eixo de fusca', 2.70, 100, 20)
insert into Componente values ('casco ms-1', 10.00, 100, 20)
insert into Componente values ('casco ms-2', 12.00, 100, 20)
insert into Componente values ('casco ms-3', 13.00, 100, 20)
insert into Componente values ('casco ms-4', 15.00, 100, 20)
insert into Componente values ('casco ms-5', 9.00, 100, 20)






--insert produto
select * from Produto
insert into Produto values ('Motor Partida Fusca', 150.99)
insert into Produto values ('Motor Partida Monza', 200.00)
insert into Produto values ('Motor Partida Gol', 149.99)
insert into Produto values ('Motor Partida Golf', 100.99)
insert into Produto values ('Gerador Energia Fusca', 50.00)
insert into Produto values ('Gerador Energia Monza', 50.00)
insert into Produto values ('Gerador Energia Gol', 50.00)
insert into Produto values ('Gerador Energia Golf', 50.00)


--insert ComponentesProduto
select * from ComponentesProduto
insert into ComponentesProduto values (1, 1, 12)
insert into ComponentesProduto values (2, 1, 12)
insert into ComponentesProduto values (3, 1, 12)
insert into ComponentesProduto values (12, 1, 12)
insert into ComponentesProduto values (4, 2, 12)
insert into ComponentesProduto values (5, 2, 12)
insert into ComponentesProduto values (6, 2, 12)
insert into ComponentesProduto values (11, 2, 12)
insert into ComponentesProduto values (7, 3, 12)
insert into ComponentesProduto values (8, 3, 12)
insert into ComponentesProduto values (9, 3, 12)
insert into ComponentesProduto values (10, 3, 12)

--insert OrdemProducao
select * from OrdemProducao
insert into OrdemProducao values (1, 1, 12, '12/12/2015', 'N', '')
insert into OrdemProducao values (1, 2, 12, '21/12/2015', 'S', '23/12/2015')
insert into OrdemProducao values (2, 3, 12, '12/01/2015', 'N', '')
insert into OrdemProducao values (3, 4, 12, '21/02/2015', 'S', '23/12/2015')
insert into OrdemProducao values (4, 1, 12, '12/12/2015', 'N', '')
insert into OrdemProducao values (1, 5, 12, '21/12/2015', 'S', '23/12/2015')


-- select de produtos listando os componentes que vao nele  este eu fiz agora novo comando

  select p.Descricao, c.IdComponente , m.Descricao , c.Quantidade from Produto p , ComponentesProduto c , Componente m
  where p.IdProduto = c.IdProduto
   and m.IdComponente = c.IdComponente


--select funcionario 

select * from Funcinario
 -- fazer este selec para ver se o usuario ta certo e senha corretas criptografadas 
 
 
  select * from Funcinario
  where Usuario = '1' and Senha = HASHBYTES('MD5', '1')
  
  select * from Produto
  
  select * from ComponentesProduto


-- listar componentes pertencentes ao produto  
SELECT
	X.IdComponentesProduto AS [Codigo], P.Descricao AS [Produto], C.Descricao as [Componente], X.Quantidade AS [Quantidade]
FROM
	ComponentesProduto AS X, Produto AS P, Componente AS C
WHERE
	X.IdProduto = P.IdProduto
AND
	X.IdComponente = C.IdComponente;


--listar cidade com descrição do estado
SELECT 
	c.IdCidade AS [Codigo], c.Cidade AS [Cidade], e.Estado AS [Estado]
FROM
	Cidade AS c, Estado AS e
WHERE
	c.IdUf = e.IdEstado


--listar pessoa fisica com descrição cidade
SELECT 
	p.IdPessoaFisica AS [Codigo], p.Nome AS [Nome], c.Cidade AS [Cidade]
FROM
	PessoaFisica AS p, Cidade AS c
WHERE
	p.IdCidade = c.IdCidade


--listar pessoa juridica com descrição cidade
SELECT 
	p.IdPessoaJuridica AS [Codigo], p.Fantasia AS [Nome], c.Cidade AS [Cidade]
FROM
	PessoaJuridica AS p, Cidade AS c
WHERE
	p.IdCidade = c.IdCidade


--listar funcionario com nome da pessoa fisica
SELECT 
	f.IdFuncionario AS [Codigo], p.Nome AS [Nome], f.Data_Admissao AS [Data Admissao], f.Administrador AS [Administrador]
FROM
	PessoaFisica AS p, Funcinario AS f
WHERE
	f.IdPessoaFisica = p.IdPessoaFisica
