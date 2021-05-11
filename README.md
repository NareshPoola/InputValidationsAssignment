# InputValidations

### Tasks is to implement below functionality to the existing application

#### Requirements for a valid username: 

	only alphanumerics

	number or characters are 8 or more and below 16

#### Requirements for valid password: 

	at least one uppercase letter

	at least one digit in the password 

	number or characters are 8 or more and below 16



1) Enable submit button only when user enters valid username and password
2) show success message to the user upon submitting username and password as “testusername” and “testPassword1”
3) Show failure message if user enters valid username and password but not username and password as “testusername” and “testPassword1”
4) Show error message in the username field if user enters invalid username
5) Show error message in the password field if user enters invalid password

	
#### Write unit test cases for the below scenario

1) Validate error message shown to the user for username field when user taps on submit button with invalid user name
2) Validate error message shown to the user for password field when user taps on submit button with invalid password
3) Validate submit button is enabled only when user enters more than 8 characters for both user name and password fields
4) Validate success message is shown to the user if user enters correct username and password with valid chars allowed for user name
5) Validate error message is shown to the user if user enters invalid username and password with valid chars allowed for password
