# g2-notifications-ms
## Notification module of CoinMarketCap project of IndraMakers

This module provides an API to perform actions like send an email and send SMS as notification service

- Consider that this project uses Twilio SMS Api for SMS service and SendGrid API for email service
- Will only use for notify sign-up or another actions indicated by the project's master

## Composite

This module use some attributes explained below:

- User model

| Attribute    | Description or usage                                        |
|--------------|-------------------------------------------------------------|
| user_id      | An identification associated to an user in the system       |
| phone_number | A number phone to use as SMS recipient                      |
| mail_user    | Address where the email will be send                        |


- Notification model

| Attribute    | Description or usage                                                             |
|--------------|----------------------------------------------------------------------------------|
| user_id      | An identification associated to an user in the system                            |
| typeof       | A notification type selector to indicate system if needs to send an email or SMS |
| subject      | A short flag to indicate what the notification is about                          |
| message      | Notification message or content                                                  |
| sent_at      | A timestamp value to specify when the notification was sent                      |


## Usage
First of all you must add an user. Notification service will not work if there is no an associated user.

Add an user trought the API:
```sh
{
    "userId": "YourUserId-OrUsername",
    "mailUser": "youremail@domain.com",
    "phoneNumber": "+123456789012"
}
```

Perform a SMS notification send request:
```sh
{
    "userId": "YourUserId-OrUsername",
    "typeOf": "SMS",
    "subject": "N/A",
    "message": "Content"
}
```
_'subject' can be sent empty, it doesn't matter what you write there, it will be overwritten with "N/A"._
_'message' can exceed the 160 char limit, you have to write something short._

Perform a MAIL notification send request:
```sh
{
    "userId": "YourUserId-OrUsername",
    "typeOf": "MAIL",
    "subject": "A little text about that you are trying to notify",
    "message": "Content"
}
```

You will get one of these code status depending on the execution of the request:

| Code | How to prevent or repair                                                                                          |
|------|-------------------------------------------------------------------------------------------------------------------|
| 1    | Verify your userId/username or if you know it's not registered, do it.                                            |
| 2    | You're trying to register a user that already exists. Try another.                                                |
| 3    | You're trying to register a user without specifying its username.                                                 |
| 4    | You only can specify between SMS and MAIL to perform a notification.                                              |
| 5    | Email address has not a correct format and/or phone number has not a correct format.                              |
| 6    | You're trying to send an email without specifying a subject. Provide a one and try again.                         |
| 7    | You're trying to send a notification without specify the content. Why? Write something.                           |
| 8    | You choose to send a SMS notification but the content exceeds the char limit allowed. Short the text.             |
| 9    | You have all correct but the server that performs the SMS sending isn't given an answer or its having a failure.  |
| 10   | You have all correct but the server that performs the MAIL sending isn't given an answer or its having a failure. |
| 404  | You're trying to request a service in a wrong route.                                                              |
| 400  | You're requesting a service with an incorrect way.                                                                |
| 500  | You're good but our service is having problems.                                                                   |

Treat below as a function declaration

## Restrictions

For _'phone_number'_ you have to provide a correct format like: +570123456789012.
For _'mail_user'_ you have to provide a correct format of email address: something@mydomain.com
For _'typeOf'_ you have to choose between SMS or an Email


## License

This software doesn't need a license, it's only for educational purposes.