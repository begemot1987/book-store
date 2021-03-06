# BOOK STORE

Spring Boot REST service that allows to manage simple book-store simulator. <br>
![cinema_tape](https://i.ibb.co/JvTjYRW/book-store.jpg)

## Used technologies
* MySQL
* Hibernate
* Spring Boot
* Maven

Project has multiple endpoints
### List of endpoints
* `GET: /authors` - shows all authors stored in DB
* `GET: /authors/top` - shows most successful author and success rate (success rate is calculated as sum of all successBootRate/number of books)
* `GET: /books` - shows all books stored in DB
* `GET: /books/by-author?name={name}` - shows all books by author name
* `GET: /books/by-author/bestseller?name={name}` - shows the best-selling book by author name
* `GET: /books/by-author/top-published?name={name}` - shows a book with the biggest published amount by author name
* `GET: /books/bestsellers/by-author?name={name}` - shows list of most selling book by author name that partially equal to requested name
* `GET: /books/top-published/by-author?name={name}` - shows list of most published book by author name that partially equal to requested name
* `GET: /books/top/by-author?name={name}` - shows list of most successful book by author name that partially equal to requested name (book's success rate is calculated as  sold amount / published amount)
* `POST: /authors{id}` | `POST: /books{id}` - save author/book to DB
* `PUT: /authors/{id}` | `PUT: /books{id}` - update author/book to DB
* `DELETE: /authors{id}` | `DELETE: /books{id}` - remove author/book from DB

## HOW TO USE
1. Install MySQL.
2. Create new schema in MySQL.
3. Fork and clone this project.
4. Replace `YOUR_DATABASE_URL`, `YOUR_USERNAME`, `YOUR_PASSWORD` with your information in `application.properties` file in `src/main/resources` folder.
5. Run this app.
6. Test data will be created on application startup. You may use Postman to manage stored date. For example: <br/>
   `POST: /author {"name" : "author_name", "birthDate" : "yyyy-mm-dd", "phone" : "+111111111111", "email" : "email@mail.com"}` <br/>
7. Have fun :)



