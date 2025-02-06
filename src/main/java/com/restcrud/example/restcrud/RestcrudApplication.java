package com.restcrud.example.restcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestcrudApplication.class, args);
	}

}

// NOTE:
// By default Spring Data Rest will create endpoints based on entity type
// simple pluralized form
// First character of entity type is lowercase
// then just add 's' to the entity
// Spring Data REST does not handle complex pluralized forms
// in this case, you need to specify plural name
// solution: @RepositoryRestResource(path="endpoint_name")

// Spring Data Rest endpoints are HATEOAS compliant
// HATEOAS: Hypermedia as the Engine of Application State

// Hypermedia-drive sites provide information to access REST Interfaces
// think of it as meta-data for REST data (https://spring.io/understanding/HATEOAS
// For a collection, meta-data includes page size, total elements, pages etc

// Spring Data REST advanced features
// Pagination, Sorting and Searching
// Extending and Adding custom queries with JPQL
// Query Domain Specific Language (Query DSL)
// https://spring.io/projects/spring-data-rest