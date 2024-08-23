**Patient Service**
##
Overview
The Patient Service is a backend service designed to manage patient registration, demographic information, and notification preferences. This service handles CRUD operations for patients, supports versioning, and offers advanced search capabilities.

**Tech Stack**
##
Java: Programming language used for the service.
Spring Boot: Framework used for creating RESTful APIs.
Maven: Build tool used for dependency management and project configuration.
PostgreSQL/MySQL: RDBMS used for storing patient data and notification preferences.
Queue Mechanism: For inter-service communication with the Notification Service.
Features
Patient Model: Represents patient demographics including multiple names and identifiers, and supports multiple contact details.
Notification Preferences: Manages patient notification preferences (e.g., NONE, SMS, mail).
Database Design: Stores patient and notification preferences models with versioning support.
CRUD Operations: Full support for Create, Read, Update, Delete operations.
Search Functionality: Search patients by multiple parameters including age ranges.
Caching (Nice to Have): Supports caching for search operations to improve performance.

**API Endpoints**
##
Create Patient: POST /api/v1/patients 

Read Patient: GET /api/v1/patients/{id}

Update Patient: PUT /api/v1/patients/{id}

Delete Patient: DELETE /api/v1/patients/{id}

Search Patients: GET /api/v1/patients/search (supports multiple search parameters)

**Database Schema**
##
Patient Table: Stores patient demographic information.
Notification Preferences Table: Stores patient notification preferences.
Historical Versions Table: Maintains historical versions of patient records with a version number.
Queue Mechanism
Purpose: To notify the Notification Service of new patient records.
Integration: Messages are sent to the queue when a new patient is created or updated.
**Setup and Installation**
Clone the Repository: git clone <repository-url>
Navigate to the Project Directory: cd patient-service
Install Dependencies: mvn install
Run the Application: mvn spring-boot:run

**Documentation**
Swagger: API documentation is available at [/swagger-ui.html](http://localhost:8081/swagger-ui.html
)
