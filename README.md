# To-Do List Application

A simple To-Do List application built using Android Room Database, ViewModel, and LiveData. This application allows users to add, delete, and view tasks.

## Features

- Add new tasks to the to-do list
- Delete tasks
- View all tasks in a list
- Real-time updates of the task list using LiveData

## Architecture Components

- **Room Database**: Provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way. Allows data to survive configuration changes such as screen rotations.
- **LiveData**: A lifecycle-aware data holder class for holding primitive data types and collections, that allows updates to be observed.

## Getting Started

### Prerequisites

- Android Studio 4.0 or higher
- Android SDK 24 or higher
- Gradle 6.1.1 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/ToDoListApp.git
    ```
2. Open the project in Android Studio.
3. Build the project:
    ```sh
    ./gradlew build
    ```
4. Run the application on an emulator or a physical device.

## Usage

1. Open the app.
2. Add a new task by clicking on the 'Plus' button.
3. Delete a task by clicking on the Cross button.
4. View the list of tasks, which updates in real-time.

## Code Overview

### Database

- `ToDoList`: A data class that represents a task entity in the Room Database.
- `ToDoDao`: Data Access Object (DAO) interface containing methods for accessing the database.
- `ToDoDatabase`: Abstract class that extends `RoomDatabase`.

### ViewModel

- `ToDoViewModel`: Extends `ViewModel` and provides data to the UI while surviving configuration changes. Interacts with the repository for data operations.


### UI

- `MainActivity`: The main activity that hosts the task list fragment.
- `RecyclerView`: RecyclerView adapter for displaying tasks in a list.
- `AddToDoActivity`: Fragment for adding or editing a task.



## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.



---

*This project is a part of learning the Android Jetpack components and improving Android development skills.*
