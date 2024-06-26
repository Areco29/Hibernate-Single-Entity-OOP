# Hibernate-Single-Entity-OOP

This repository contains an example implementation of a single entity using Hibernate in the context of Object-Oriented Programming (OOP). The goal is to demonstrate how Java entities can be mapped to database tables using Hibernate, one of the most popular Object-Relational Mapping (ORM) libraries for Java.

# Tools and Frameworks Used:

- **IDE:** Eclipse
- **Persistence:** MySQL
- **ORM Framework:** Hibernate
- **Additional Resources:** Refer to [Hibernate documentation](https://hibernate.org/orm/documentation/) for detailed framework usage.

# Project Description:

The Hibernate-Single-Entity-OOP project utilizes Hibernate ORM to manage the persistence of Java objects in a MySQL database environment. It includes comprehensive implementations for data access (CustomerDAO), business logic (CustomerCRUD), and associated testing suites. The project structure is organized into distinct packages (dao, data, mappings, service, test) to maintain clarity and separation of concerns.

# Setup Instructions:

1. Clone the repository and ensure all necessary libraries (JAR files) are configured in the project build path.
2. Execute the provided MySQL database script (`db-hibernate-single-entity.sql`) to set up the required database schema.
3. Configure `hibernate.cfg.xml` with your MySQL database credentials (username, password, database name).


# Repository Notes:

The _Libs_HBM5_for_Java12_ folder contains all required JAR files for Hibernate and MySQL Connector/J for Java 12. Ensure these are added to the project's build path as external libraries. If you require libraries for Java 8 instead of Java 12, they can be found in the `Libs_HBM5_for_Java.zip` file included in the repository.

Remove the module file if present when creating a project to avoid compatibility issues.

# Contributions:

Contributions and feedback are welcome via GitHub pull requests.

# Contact Information:

For further inquiries or assistance, please contact Areco at arecopablosamuel@gmail.com

# License:

This project is licensed under the MIT License.

