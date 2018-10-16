<h3>Web Service REST java</h3>

<p>O projeto consiste em um web service desenvolvido com java e com persistencia de dados em MySql. Este web service recebe e envia dados em formato json podendo ser consumido por APPs de diversas plataformas e é um pequeno exemplo que apenas grava e retorna dados de clintes, mas que pode ser expendido e ganhar novas funcionalidades.</p>

<ul>Tecnologis utilizadas:
  <li>Java
  <li>Jersey
  <li>JSON
  <li>XML
  <li>Maven
  <li>MySql
  <li>SQL
  <li>Tomcat 7
  <li>GIT
</ul>

O codio base desse projeto veio do github do Douglas Costa <douglas.cst90@gmail.com>.

# setup do projeto
## banco de dados
### procedimentos para Linux e Mac
#### 1 - entrar no console do MySQL.
'mysql -u'<usuario mysql aqui>'-p'<senha mysql aqui>
```shell
#exemplo
mysql -uroot -p123456
```
#### 2 - criar database como nome ```cliente```
```sql
#mysql>
CREATE DATABASE client;
```
### 3 - criar tabela cliente, com id, nome, endereço e cpf.
copie e cole os comandos no console no mysql e de enter.
```sql
use cliente;
CREATE TABLE `cliente` (`nome` varchar(255) NOT NULL, `cpf` varchar(14) NOT NULL, `endereco` varchar(255) NOT NULL,`id` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `cliente` ADD PRIMARY KEY (`id`);
ALTER TABLE `cliente` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT
```
pronto nesse ponto o banco de dados já esta pronto para a aplicação.
## importar projeto e rodar no Eclipse.
#### 1- abra o eclipse, vá até 
File> Import> GIT> Projects from Git> Next>

Clone URI> Next>
  - cole no campo URI: https://github.com/manoelsmotoso/Web-Service-REST-java.git
Next> Next >Fisish

com o projeto importado no eclipse, clique com o botão direito sobre o mesmo e selecione.
> 'Run as> Run on server'.
> 'Tomcat v8.0'
depois 
>'Download and install' 
e selecione o diretorio onde sera instalado o Servidor Tomcat.
### 2- rode o projeto
clique com o botao direito dp mouse sobre o projeto e vá até,
> Run as
> Run on server
selecione o servidor Toncat criado no passo 1, e clique em 'Finish', depois abra o navegador em http://localhost:8080/cliente/
### 3 criar listar e deletar clientes
recomendo usar o <a href="https://www.getpostman.com/">postman</a> para testar essa api.
#### criar
POST - http://localhost:8080/cliente/
```json
{
	"nome":"",
	"endereco":"",
	"cpf":""
}
```
#### editar 
PUT -  http://localhost:8080/cliente/{id}
```json
{
	"nome":"",
	"endereco":"",
	"cpf":""
}
```
#### listar todos 
GET - http://localhost:8080/cliente/
#### buscar por id 
GET - http://localhost:8080/cliente/```{id}```
#### deletar por id 
DELETE - http://localhost:8080/cliente/```{id}```