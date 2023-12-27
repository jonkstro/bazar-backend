# ***TODO List:***
## Add PgSQL no BD:
### Obs.: Usando banco de dados PostgreSQL:

- Criar arquivo ***application.properties***
    
    Inserir no arquivo:
    
    ```
    spring.profiles.active=pgsql
    spring.jpa.open-in-view=true
    
    ```
    
- Criar arquivo ***application-pgsql.properties***
    
    Inserir no arquivo:
    
    ```
    # DATASOURCE  
    spring.datasource.url=jdbc:postgresql://localhost:5432/curso-spring(nome do banco de dados)  
    spring.datasource.username=postgres  
    spring.datasource.password=admin  
      
    # JPA  
    # Se a tabela mudar atualiza na base de dados automatico
    spring.jpa.hibernate.ddl-auto=update
    
    ```