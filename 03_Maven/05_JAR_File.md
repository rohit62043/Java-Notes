# Introduction to JAR Files

- **JAR File Definition**:
  - JAR (Java ARchive) file is a compressed file format used for packaging Java class files, associated metadata, and resources into a single archive.
  - JAR files facilitate the distribution and deployment of Java applications and libraries.
- **Contents**:
  - A JAR file can contain:
    - Compiled Java classes (\*.class files).
    - Resources such as images, configuration files, and XML documents.
    - Manifest file (META-INF/MANIFEST.MF) containing metadata about the JAR file and its contents.
    - Additional libraries and dependencies required by the application or library.
- **Purpose**:
  - JAR files provide a platform-independent way to package and distribute Java applications.
  - They simplify the deployment process by bundling all necessary files into a single archive.
  - JAR files support versioning, digital signing for security, and can be easily distributed over the internet.
- **Usage in Maven**:
  - In Maven projects, JAR files are automatically created during the build process based on project configuration specified in Pom.xml.
  - Maven manages dependencies and plugins to ensure the successful creation and deployment of JAR files.

# Creating a Jar File in Maven

- **Requirements**:
  - To create a JAR file for your project, you need to specify the following in Pom.xml:
    - Group ID: Unique identifier typically based on reverse domain name convention.
    - Artifact ID: Name of the project or library.
    - Version: Version number of the project or library.
- **Procedure**:
  - Ensure that the Pom.xml file of your Maven project includes the necessary project identifiers.
  - Maven uses these identifiers to generate a JAR file during the build process.
  - By adhering to Maven conventions and providing the required project metadata, Maven automates the JAR file creation process.
- **Custom Libraries**:
  - Maven allows developers to create their own libraries by packaging project code into JAR files.
  - By defining group ID, artifact ID, and version in Pom.xml, developers can manage and distribute their libraries using Maven.
  - Custom libraries facilitate code reuse and maintainability across projects.
