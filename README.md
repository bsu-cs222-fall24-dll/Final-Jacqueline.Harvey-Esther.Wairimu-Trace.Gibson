Library Catalog GUI - Iteration 3
The Library Catalog GUI is the culmination of three iterations to create an interactive and user-friendly system for managing library activities. Built using JavaFX, this final version integrates all the features developed in earlier iterations while introducing new enhancements for an improved user experience and functionality. This project supports various user stories, starting with account management. Users can create new accounts with unique usernames and secure passwords. Once registered, they can log in to access their accounts through a basic authentication system. This allows them to search for books and manage their reading activities within the catalog. The book search functionality is robust and will enable users to search by title, author, genre, or publication year. Personalized book recommendations are also provided based on user activity, enhancing the reading experience by suggesting titles tailored to individual preferences. Iteration 3 further builds on this with notifications that alert users about new book releases or updates on their saved books, ensuring they stay informed. Newly introduced in this iteration are enhanced features for a seamless experience. A prominent red **Exit Button** has been added for easy application closure. The GUI now supports themes and customization options, enabling users to personalize the interface to their liking. Notifications for updates and visual progress bars for reading goals enrich the overall user experience. Behind the scenes, the application securely stores user credentials in a database, with passwords hashed for added security. This implementation aligns with best practices for protecting user data. The project has been carefully designed following the Model-View-Controller (MVC) pattern to ensure a clear separation between logic, interface, and data management, making the system maintainable and scalable. This final iteration represents a significant step toward creating a polished and feature-rich library catalog system. It combines the technical capabilities of earlier iterations with a focus on user experience, security, and functionality. The result is a comprehensive tool that caters to the needs of avid readers while demonstrating best practices in software development.

Build and Execution Instructions added:
The application is runnable through Gradle. Once built, launching the LibraryCatalogGUI class starts the program.


Library Catalog Project - Iteration 2
This release builds on the Library Catalog project by introducing features that allow avid readers to manage their collections and track reading goals more effectively. In Iteration 2, we’ve implemented several user-requested functionalities such as notifications for New Releases. The project’s Database Management System (DBMS), implemented in the previous iteration, underpins all these features. It securely manages user data, including but not limited to reading lists, notifications, and bookmarks, ensuring seamless and efficient access across the catalog. In the next iteration, we’ll introduce a GUI to bring these features together in an interactive, user-friendly interface.



Overall Project Summary : 
The purpose of this project is to create a Library Catalog Application; a desktop Java application designed to help users manage a collection of books. 
The application uses JavaFX for the graphical user interface and SQLite for managing the database.
Users can add, search, update, and delete books, with each entry containing information like the title, author, genre, and publication year. 
All data is stored locally in an SQLite database, ensuring persistence across sessions. 
This project is ideal for users who want a simple and efficient way to maintain a digital library.



Build and Execution Instructions :
Java Development Kit (JDK) 8 or higher installed
IntelliJ IDEA with Gradle support
JavaFX 17 SDK or higher
SQLite tools and DLL installed
SQLite JDBC driver installed



Team Members :
Esther Wairimu
Jacqueline Harvey
Trace Gibson
