# Descrição

O projeto foi desenvolvido utilizando linguagem Java e framework de desenvolvimento Spring.

# Como subir

## 1. Criação do banco de dados

O primeiro passo é criar uma database no Mysql local com o nome de `desafiomirante`.

O comando a seguir pode ser executado para criá-lo:

> CREATE SCHEMA `teste` ;

Agora é necessário criar um usuário com os privilégios todos os privilégios nessa base de dados. Utilize os comandos a seguir:

> CREATE USER 'mirante'@'localhost' IDENTIFIED BY 'mirante@010203';

> GRANT ALL PRIVILEGES ON desafiomirante.* TO 'mirante'@'localhost';

## 2. Executando o back-end

Com o banco de dados local já configurado e o Maven instalado, execute o seguinte comando no terminal a partir da pasta raíz do projeto.

> mvn spring-boot:run

## 3. Inserção de dados

Para que a aplicação funcione corretamente, é necessário executar o seguinte script de inserts na base de dados criada a partir do Hibernate:

```
INSERT INTO `desafiomirante`.`profile` (`id`, `title`) VALUES ('1', 'Administrador');
INSERT INTO `desafiomirante`.`profile` (`id`, `title`) VALUES ('2', 'Gerente');
INSERT INTO `desafiomirante`.`app_user` (`id`, `login`, `password`, `profile_id`) VALUES ('1', 'mirante01', '$2a$10$7kbXCnAWrx25BNSd/Af2Ge8cYGWFjj0Sx7buRd1A5t7gn/4soUtiO', '1');
```
