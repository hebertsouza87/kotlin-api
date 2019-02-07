# API Basica em Kotlin

### Tecnologias:
* Injeção de dependencias: Koin - insert-koin.io
* Web: Javalin - javalin.io
* Banco de dados: Postgres - postgresql.org
* Acesso Banco de Dados: exposed - github.com/JetBrains/Exposed
* Pool de Conexão: HikariCP - github.com/brettwooldridge/HikariCP

* Outras: jackson, ulid, konfig, 


### Variáveis de ambiente

* Server

```bash
export SERVER_PORT=[port]
```

* Database

```bash
export POSTGRESQL_JDBC_URL=[jdbc:dbms://host:port/db_name]
export POSTGRESQL_USERNAME=[user]
export POSTGRESQL_PASSWORD=[password]
export POSTGRESQL_MAX_POOL_SIZE=[size]
```

### Build

```bash
./gradlew build
```

### Como executar

```bash
./gradlew run
```
