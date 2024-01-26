When using Hibernate v 4.0 and Generation Type as AUTO, specifically for MySql,
Hibernate would choose the IDENTITY strategy (and thus use the AUTO_INCREMENT feature)
for generating IDs for the table in question.

Starting with version 5.0 when Generation Type is selected as AUTO,
Hibernate uses SequenceStyleGenerator regardless of the database.
In case of MySql Hibernate emulates a sequence using a table and is why you are seeing 
the hibernate_sequence table. MySql doesn't support the standard sequence type natively.

Some commonly used strategy types :-

GenerationType.IDENTITY: This strategy relies on the auto-increment functionality provided by the database to generate unique identifier values automatically.

GenerationType.SEQUENCE: With this strategy, the @GeneratedValue annotation fetches unique identifier values from a predefined sequence generator.

GenerationType.TABLE: In the table-based strategy, the annotation utilizes a separate table to manage and generate unique identifier values.

GenerationType.AUTO: This strategy lets the JPA provider choose the most appropriate strategy based on the underlying database and configuration. It typically maps to either IDENTITY or SEQUENCE, depending on database capabilities.

GenerationType.UUID: While not a standard JPA strategy, some frameworks and libraries may offer a custom strategy for generating universally unique identifiers (UUIDs) for entities.