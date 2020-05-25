# Descrição

O projeto foi desenvolvido utilizando linguagem Java e framework de desenvolvimento Spring.

# 1. Criação do banco de dados

O primeiro passo é criar uma database no Mysql local com o nome de `desafiomirante`.

O comando a seguir pode ser executado para criá-lo:

> CREATE SCHEMA `teste` ;

Agora é necessário criar um usuário com os privilégios todos os privilégios nessa base de dados. Utilize os comandos a seguir:

> CREATE USER 'mirante'@'localhost' IDENTIFIED BY 'mirante@010203';

> GRANT ALL PRIVILEGES ON desafiomirante.* TO 'mirante'@'localhost';

# 2. Executando o back-end

Com o banco de dados local já configurado e o Maven instalado, execute o seguinte comando no terminal a partir da pasta raíz do projeto.

> mvn spring-boot:run
