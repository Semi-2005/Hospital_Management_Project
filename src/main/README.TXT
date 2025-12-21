This project uses JavaFX.
To run the project, JavaFX must be configured in the IDE.
Main class: HelloApplication

"./mvnw" … error=13 (Permission denied) Solution:
This project is Maven-based and uses the Maven Wrapper (mvnw).
On macOS, when the project is extracted from a ZIP file or copied via
Finder, the execution permission of the mvnw file may be removed,
which can cause a “Permission denied: ./mvnw” error when running the project in NetBeans.
To resolve this,
1) open Terminal, navigate to the project directory
2) execute the command " chmod +x mvnw "
After this step, the project can be run normally from NetBeans.