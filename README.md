# Employee CRUD REST API - MongoDB
Simple Rest API that displays a way of constructing and designing a simple Spring boot REST API using MongoDB.
We are going to use Mlab to host the db instance. 

### Main Technologies
* Java 8
* Spring boot
* MongoDb 
* Mlab

#### Create Mlab instance
1. If you don't have an Mlab account, you should create one... it's free.
2. Create a new DB deployment. Select your favorite cloud provider and the Plan type of your preference (Sandbox is free).
3. Select the Region that's more suitable for you.
4. Name your db. 
5. Click into your newly created db instance. Go to the Users tab and add a new user to your db.
6. Make sure that has write and read privileges (ReadOnly = false).
7. Now that you have the user, you should be able to connect to your db instance through Mongo shell or via the standard MongoDB URI.
In our case, we'll be using the MongoDB URI.
#### Setup Environment
1. Clone this repo
```
git clone blablabla
```
2. Create env variables to store your MongoDB username, pasword and db name.
### TODO
* Controller
* Service
* Model - Document 👀
* DTO pattern implementation.
* REST tests and unit tests

Made with love by ❤️ gorygon - jdgonzaleza😀  