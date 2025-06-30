# Bookstore API

A simple RESTful API for managing a bookstore's inventory. This API provides CRUD (Create, Read, Update, Delete) operations for the `Book` entity, which includes the following attributes:

- **Title**
- **Author**
- **ISBN**

## Features

- **Add a new book** to the bookstore.
- **View all books** or a specific book by ID.
- **Update book details** (title, author, or ISBN).
- **Delete a book** from the inventory.

## Entity: Book

| Field  | Type   | Description              |
|--------|--------|--------------------------|
| id     | int    | Unique identifier        |
| title  | string | Title of the book        |
| author | string | Author of the book       |
| isbn   | string | International Standard Book Number |

## API Endpoints

### 1. Get All Books

```
GET /books
```

**Response:**
```json
[
  {
    "id": 1,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "isbn": "9780743273565"
  },
  ...
]
```

---

### 2. Get a Book by ID

```
GET /books/{id}
```

**Response:**
```json
{
  "id": 1,
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "9780743273565"
}
```

---

### 3. Add a New Book

```
POST /books
```

**Request Body:**
```json
{
  "title": "1984",
  "author": "George Orwell",
  "isbn": "9780451524935"
}
```

**Response:**
```json
{
  "id": 2,
  "title": "1984",
  "author": "George Orwell",
  "isbn": "9780451524935"
}
```

---

### 4. Update a Book

```
PUT /books/{id}
```

**Request Body:**
```json
{
  "title": "Animal Farm",
  "author": "George Orwell",
  "isbn": "9780451526342"
}
```

**Response:**
```json
{
  "id": 2,
  "title": "Animal Farm",
  "author": "George Orwell",
  "isbn": "9780451526342"
}
```

---

### 5. Delete a Book

```
DELETE /books/{id}
```

**Response:**  
- `204 No Content` on successful deletion.

---

## Getting Started

1. **Clone the repository:**

   ```sh
   git clone https://github.com/terrencehlabane/bookstore-api.git
   cd bookstore-api
   ```

2. **Install dependencies and run the server.**  
   *(Instructions will vary depending on your stack; for example, if using Node.js:)*

   ```sh
   npm install
   npm start
   ```

3. **Test the API** using tools like [Postman](https://www.postman.com/) or [curl](https://curl.se/).

---

## Technologies Used

- RESTful API design
- Example stacks: Java/Spring Boot, PostgresSQL (implementation dependent)

---

## License

This project is open source and available under the [MIT License](LICENSE).

---

## Contact

For questions or suggestions, please open an issue or contact the maintainer.
