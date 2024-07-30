# VitalFlow Prognostics

## Description
**VitalFlow Prognostics** is a Java-based command-line utility designed to aid in the management and prognosis of HIV. This tool integrates powerful data processing capabilities with secure data management, providing a comprehensive solution for healthcare professionals and patients to estimate and understand the progression of HIV.

## Features
- **Secure User Management:** Handles both patient and administrator accounts, ensuring data security and privacy.
- **Lifespan Prediction:** Calculates expected lifespan based on the latest medical data and patient treatment plans.
- **Data Export:** Allows administrators to export patient data and statistical reports for further analysis.
- **Command-Line Interface:** Easy-to-use interface designed for efficient navigation and operation.

## Technologies Used
- **Java:** For core application logic and user interactions.
- **Bash:** Used for file management and script execution.
- **Git:** Utilized for version control and collaborative development.

## Getting Started

To get started with **VitalFlow Prognostics**, clone this repository and follow the installation instructions below:

```bash
git clone https://github.com/yourusername/vitalflow-prognostics.git
cd vitalflow-prognostics
# Follow installation instructions
```

## Installation

Ensure you have Java and Bash installed on your machine. Navigate to the project directory and compile the Java classes:

```bash
javac src/java/common/*.java
javac src/java/patient/*.java
javac src/java/admin/*.java
```

To run the application:

```bash
java -cp src/java/common:src/java/patient:src/java/admin Main
```

## Usage

After installation, run the program using the command line interface. Log in as an administrator to manage users or as a patient to update and view personal health data.

[//]: # (## Contributing)

[//]: # ()
[//]: # (Interested in contributing? We welcome contributions from all users and developers. Please read our `CONTRIBUTING.md` for information on how to get started.)

## License

Distributed under the MIT License. See `LICENSE` for more information.
