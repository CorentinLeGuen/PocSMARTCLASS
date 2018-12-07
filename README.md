# PocSMARTCLASS

Simple **POC** pour un projet universitaire. \
Le principe est simple : on a un serveur (service SOAP) qui écoute et un client qui envoie des messages sur le serveur.

# Fonctionnement

Service SOAP qui persiste une entité composée d'une simple clé `(int reference, int value)` avec `reference` correspondant à la référence de l'iot et `value` la valeur qu'il renvoie.

| **Classe** | **Description** |
|----------------|-----------------|
| IotEntity | Contient l'entité à persister |
| IotManager | Contient le gestionnaire de l'entité *IotEntity* |
| MainPublisher | Endpoint du Webservice |
| MainService | Contient *saveIotInformations* qui sauvegarde les infos d'un iot |

# Persistance avec Hibernate

Il faut ajouter au pom : 

```xml
    <!-- Coeur de hibernate -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.2.12.Final</version>
    </dependency>
    
    <!-- Gestionnaire d'entité -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-entitymanager</artifactId>
        <version>5.2.12.Final</version>
    </dependency>
    
    <!-- Système de persistance -->
    <dependency>
        <groupId>org.hibernate.javax.persistence</groupId>
        <artifactId>hibernate-jpa-2.1-api</artifactId>
        <version>1.0.0.Final</version>
    </dependency>
```

Configuration de la persistence dans le fichier */resources/META-INF/persistence.xml*.

```xml
    <persistence-unit name="JEE-Persistence" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>server.entities.IotEntity</class>
        <properties>
            <property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
            <property name="hibernate.connection.password" value="pocpwd"/>
            <property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/pocsm"/>
            <property name="hibernate.connection.username" value="pocuser"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
        </properties>
    </persistence-unit>
```

Avec un utilisateur **pocuser** ayant le mot de passe **pocpwd** et l'accès à la base de données **pocsm**.
La base de données utilisée ici est du MySQL.

# Database entities

Objet IotEntity et table iot en base :

| **Table/Objet** | **Champs** | **Type** | **Spécificité** |
|---------|------------|----------|-----------------|
| **iot** | id | int | :key: auto increment |
| | reference | int | |
| | value | int | |
| | date | datetime |  |

Poc made by *Corentin Le Guen* :shipit:
