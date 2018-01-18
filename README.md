# books-rest-api


API Definitions:
a. List all books
 URL  /books:
 METHOD    get:
    description: Retrieve a list of all the books
    headers:
      User:
        required: true
    responses:
      200:
        body:
          application/json: example 
{
  "1": {
    "title": "Norewaing",
    "author": "pepe",
    "pages": 15,
    "id": 1
  }, }
b. Create a new book
URL  /book:       
METHOD    post:
      description: Create a new book
      headers:
        User:
          required: true
      body:
        application/json:  
     example: |
            {    
"title": "The Hound of the Baskervilles",
    "author": "SIr Arthur",
    "pages": 900,
    "id": 4
             
            }
          
      responses:
        200:
          body:
            application/json:
    400:
    Body: Bad Request 
c. Update an existing book (using its id)
URL  /book:  
METHOD put:
        description: Update a book by id
        headers:
          User:
            required: true
        Body:
    example: |
            {    
"title": "The Return of Sherlock Holmes",
    "author": "SIr Arthur",
    "pages": 1300,
    "id": 4
             
            }
          application/json:            
        responses:
         200:
           body:
              application/json:
If the book ID doesn’t exist in the Container, the APIKIT Router will return a 400 Response by default.
d. Delete an existing book (using its id)
URL  /book:  
METHOD delete:
      description: Delete of Book by ID
      headers:
        User:
          required: true
      queryParameters:
        id:
          type: integer
          required: true
      responses:
          200:
            body:
              application/json:
If the book ID doesn’t exist in the Container, the APIKIT Router will return a 400 Response by default.
e. Find a book by name
URL     /findByName:
METHOD      get:
        description: Search a book by Name
        headers:
          User:
            required: true
        queryParameters:
           name:
             type: string
             required: true
        responses:
          200:
           body:
              application/json:
If the name of the book doesn’t exists in the collection, the Service will return an empty collection. If the name exist, they will return the first book order by ID with the name.
