# Enem a Salvo Desktop 

Projeto final de Análise e Projeto de Software Orientado a Objetos da Faculdade de Computação (FACOM) da Universidade Federal de Mato Grosso do Sul (UFMS).

## Integrantes

+ Alison I. O. Moura
+ Pedro H. S. Souza

## Tecnologias
+ Java (JDK8.*)
+ JavaFX
+ MySQL v14.*
+ Maven
+ Hibernate

## Configuração

Baixar as dependências do Maven (não é necessário pelo Eclipse ou IntelliJ)

`$ mvn install`

Configuração do usuário, senha e nome do banco em:

`src/main/resources/META-INF/persistence.xml`

Ex:

```xml
    <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/NOME_DO_BANCO" />
    <property name="javax.persistence.jdbc.user" value="USUARIO_DO_BANCO" />
    <property name="javax.persistence.jdbc.password" value="SENHA_DO_BANCO" />
```

## Execução

Deve ser executado o arquivo `src/main/java/view/Palco.java`
