## Setting up PostgreSQL and Creating a Database

## Installing PostgreSQL

- Navigate to the official PostgreSQL website or search for "PostgreSQL download."
- Choose the appropriate version based on your operating system (Windows, Mac, Linux).
- Download the installer and follow the installation prompts.
- During installation, ensure to select the option to install pgAdmin, the graphical administration tool for PostgreSQL.
- Choose a secure password for the PostgreSQL database.

## Accessing pgAdmin

- Launch pgAdmin after installation.
- Enter the PostgreSQL password to access the pgAdmin dashboard.

## Creating a Database

- In the pgAdmin dashboard, locate the Object Explorer panel.
- Expand the PostgreSQL server and navigate to Databases.
- Right-click on Databases and select Create Database.
- Enter the database name, such as "demo," and specify the owner (default is usually "postgres").
- Optionally, configure additional settings for the database.
- Click Save to create the database.

## Creating Tables and Inserting Data

- Once the database is created, right-click on it and select Create Table.
- Define the table structure by specifying column names and data types (e.g., student ID, name, marks).
- Optionally, configure constraints such as primary keys and not-null constraints.
- Click Save to create the table.
- To insert data into the table, use SQL INSERT queries, specifying the values for each column.
- Execute the INSERT query to add data to the table.
- Verify the inserted data by querying the table or viewing rows in pgAdmin.

By following these steps, you can set up PostgreSQL, create databases, define tables, and insert data, preparing the environment for JDBC implementation in Java applications.
