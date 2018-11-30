Feature: Registration Form

Scenario: user Id is Empty or length between 5 to 12
Given user is on Registration Form
When user enters invalid user Id
Then Display alert box 'User id should not be empty/ lngth be between 5 to 12'

Scenario: password is Empty or length between 7 to 12
Given user is on Registration Form
When user enters invalid password
Then Display alert box 'Password should not be empty/ length be between 7 to 12'

Scenario: User name should not be empty and must have alphabet characters only
Given user is on Registration Form
When user enters invalid username
Then Display alert box 'Username should not be empty and must have alphabet characters only'

Scenario: User address must have alphanumeric characters only
Given user is on Registration Form
When user enters invalid address
Then Display alert box 'User address must have alphanumeric characters only'