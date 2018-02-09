# Frontend challange

## Description
Build a simple social networking application, similar to Twitter, using publicly available API. The application should support the scenarios below.

### Login screen
User needs to login to enter the application. It is not required to authenticate user in backend, following is enought:
- username is at least 5 characters long
- password contains 8 characters, at least one small letter, at least one capital letter, at least one number

Store user credentials in the session-storage. Prepare logout functionality.

### Wall
User should be able to see posts on a wall. Posts should come from 
```
https://jsonplaceholder.typicode.com/posts
```
and should be displayed in descending order (by "id" field). Posts should be displayed with delay - one post each second (up to the number of posts available).
Posts should be displayed in form of tiles and whole page should be responsive:
- three columns with tiles for desktop
- two columns with tiles for tablet
- one column with tiles for mobile

#### Search
Search box should appear at the top of posts list. It should filter posts **visible** on the screen (by title and body).

### Post details
User should be able to see post details after clicking on post tile. UserId should be mapped to a random name. Appriopriate routing should be in place, so post ID should appear in the URL.
Post details should come from:
```
https://jsonplaceholder.typicode.com/posts/{postId}
```

### Error handling
In case of HTTP connnection error please display Modal dialog with erorr information. Error handling componenent (dialog) should be shared across wall and post details components.
PageNotFound handler should be prepared as well.


## Technologies
Application should be written using Angular 5. AngularCLI should be used as a build tool. Classes should be written in TypeScript, and styles should use LESS.
Components needs to be tested in Jasmine.
Please use TypeScript version of Bootstrap (ngx-bootstrap).


## References
- API resource
```
https://jsonplaceholder.typicode.com/
```

## DESING

![Design](/desing.png)
