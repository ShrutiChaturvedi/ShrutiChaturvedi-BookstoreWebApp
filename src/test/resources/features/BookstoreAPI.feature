Feature: Bookstore API

  As a book shop admin
  I want to be able to add, update, delete, count or view books
  So that I can manage book stock

  Scenario: Get list of books
	Given I call get books api
	Then I should get a list of books

  Scenario Outline: Create a new book
	When I add a book with id <id>, title <title>, description <description>, isbn <isbn>, price <price> and language <language>
	Then I should be able to find this book in the system by id <id>

	Examples:
	  | id       | title              |  description  | isbn     | price  | language |
	  | 1234567 | Peter Pan          |  Happy        | 75943582 | 89     | ENGLISH  |

  Scenario Outline: Update a book
	Given I update a book with id <id> with a new title <title>
	Then A book with id <id> should have a title <title>

	Examples:
	  |id        |title         |
	  |1234567   |Treasure To Island    |


  Scenario Outline: Delete a book
	Given I add a book with id <id>
	When I delete a book with id <id>
	And I call get books api
	Then a book with id <id> should not be in the list

	Examples:
	  | id      |
	  | 2345678 |
