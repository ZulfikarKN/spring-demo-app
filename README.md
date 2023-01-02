# spring-demo-app
- SPRINGBOOT 3.0.2
- JAVA 17
- MongoDB
- JWT

# Register
REQ 
```
{
	"username": "Mickey",
	"password": "Ajalakab"
}
```
RES
```
{
	"status": "success",
	"message": "Data Registered",
	"data": {
		"username": "Mickey",
		"password": "Ajalakab",
		"created": "2023/01/02 10:06:02"
	}
}
```

# Login
REQ
```
{
	"username": "Mickey",
	"password": "Ajalakab"
}
```
RES
```
{
	"status": "success",
	"message": "login Success",
	"data": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJNaWNrZXktQWphbGFrYWIiLCJleHAiOjE2NzI2ODk5NjgsImlhdCI6MTY3MjY3MTk2OH0.laEUZpTZvH5rJG_616HmObKdQeB9ym5AN4LVhofEqXJkzyoaQegMpXmqnrS9x-ho3vFUxcbSBK9cJmJnP_1dTg"
}
```
