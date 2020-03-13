Spring Pagination, Sorting and Filtering Example

Minimum Configuration:
1. Add Spring Jpa dependency to pom file.

        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
2. Add Database driver dependency
3. Create Model class representing Database table
4. Create the Repository interface for the model class extending PagingAndSortingRepository interface


