# Scenario
A travel agency has recently launched a complete overhaul of their front-end vacation bookings application using Angular and JavaScript. Lately, the front-end engineers have encountered various undocumented bugs when sending requests and fetching data from the back-end. Since the back-end was built in the early 1990s and the original developer has since retired and can no longer help troubleshoot, the existing team is concerned about the growing tech debt and lack of ongoing support. Your chief technology officer (CTO) decided to create a project to port over any mission-critical functionalities to a modern framework and has selected you, a software developer in Java, to start developing the minimally viable product (MVP) to migrate the legacy back-end to the modern Spring framework.

# Project Requirements

A.   Create a new Java project using Spring Initializr, with each of the following dependencies:

    •    Spring Data JPA (spring-boot starter-data-jpa)

    •    Rest Repositories (spring-boot-starter-data-rest)

    •    MySQL Driver (mysql-connector-java)

    •    Lombok



B.   Construct four new packages, one for each of the following: controllers, entities, dao, and services. The packages will need to be used for a checkout form and vacations packages list.



C.   Write code for the entities package that includes entity classes and the enum designed to match the UML diagram.


D.   Write code for the dao package that includes repository interfaces for the entities that extend JpaRepository, and add cross-origin support.


E.   Write code for the services package that includes each of the following:

    •    a purchase data class with a customer cart and a set of cart items

    •    a purchase response data class that contains an order tracking number

    •    a checkout service interface

    •    a checkout service implementation class



F.   Write code to include validation to enforce the inputs needed by the Angular front-end.


G.   Write code for the controllers package that includes a REST controller checkout controller class with a post mapping to place orders.



H.   Add five sample customers to the application programmatically.
