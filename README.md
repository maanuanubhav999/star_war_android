# Star Wars Android App

## Overview

Welcome to the Star Wars Android App! This project is a showcase of modern Android development principles and practices, featuring a multi-module architecture, clean architecture, MVVM pattern, Dagger for dependency injection, Jetpack Compose for UI, and the use of the SWAPI (Star Wars API) for data retrieval.

## Features

- Multi-module architecture: The project is structured into separate modules to ensure clean and modular code organization.
- Clean architecture: The app follows clean architecture principles to separate concerns and maintain a clear code structure.
- MVVM pattern: The architecture is based on the Model-View-ViewModel pattern, promoting a clear separation of UI and business logic.
- Dagger: Dependency injection is handled by Dagger, making the codebase more maintainable and testable.
- Paging: The app implements paging for efficient data loading and displaying large datasets.
- Kotlin: The entire project is written in Kotlin, taking advantage of its concise syntax and modern language features.
- Jetpack Compose: The UI is built using Jetpack Compose, offering a declarative and concise way to define UI components.

## Data Source

The app utilizes the SWAPI (Star Wars API) as its data source. The API is accessed through network calls to retrieve information about Star Wars characters.

API Base URL: [https://swapi.dev/](https://swapi.dev/)

## Data Persistence

Data fetched from the API is stored locally using Room, a local database library for Android. This ensures that data is available even when the network is down.

## Offline Mode

The app features a remote mediator to manage data retrieval and storage. The `CharacterPagingSourceUsingRemoteMediator` is responsible for saving fetched data to Room and accessing it later when the network is unavailable. If needed, you can switch to using `CharactersPagingSource` in the `OfflineFirstCharactersRepository` to make API calls directly without storing them in Room.

## Modules

- **app:** The main Android application module.
- **data:** Contains data-related classes, including repositories, data sources, and models.
- **domain:** Contains the business logic of the application, including use cases and entities.
- **presentation:** The UI layer of the application, implemented using Jetpack Compose.

## How to Build

To build the project, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/star-wars-android-app.git
   ```

2. Open the project in Android Studio.

3. Build and run the app on an Android emulator or device.

## Contributing

If you would like to contribute to the project, please follow the standard GitHub workflow:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature-name`.
3. Make your changes and commit them: `git commit -m "Description of changes"`.
4. Push your changes to your fork: `git push origin feature-name`.
5. Create a pull request on the main repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
