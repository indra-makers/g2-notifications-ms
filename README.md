# g2-notifications-ms
## Notification module of CoinMarketCap project of IndraMakers

This module provides an API to perform actions like send an email and send SMS as notification service

- Consider that this project doesn't have a SMS Provider in real world
- Will only use for notificy sign-up or another actions indicated by the project's master
- Consider that this project doesn't have an email smtp server to send emails, may use a SMTP established server or 3rd party provider.

## Composite

This module use some attributes explained below:

| Attribute | Description or usage |
| ------ | ------ |
| id_notification¹ | An unique identification by notification performed|
| typeof | A notification type selector to indicate system if needs to send an email or SMS |
| message | Notification message or content |
| sent_at¹ | A timestamp value to specify when the notification was sent |
| mailuser² | Address where the email will be send |
| subject² | A short flag to indicate what the notification is about |
| phonenumber² | Phone number where the notification will be send |
¹ = Don't declare this in service request, it will be processed and used in logical environment
² = If system request a SMS will be send 'mailuser' and 'subject' with 'null' value, any value typed on these parameters will be not treated for a SMS request. Likewise if system request an email, 'phonenumber' will be 'null' or any other value.
## Usage
Due to the 'typeof' attribute system can send a notification as email using an email address or a sms using a phone number

Treat below as a function declaration

Send notification as email:
```sh
send_notification("email","Hi this is a test!","aquiles@bailo.com","Mail test",null)
```

Send notification as SMS:

```sh
send_notification("sms","Hi this is a test!",null,null,"3210123456")
```

> Note: `mailuser` is required for email procedure, it will be validated as an email address written correctly.

> Note: `phonenumber` is required for sms procedure, it will be validated as a phone number written correctly.

## License

This software doesn't need a license, it's only for educational purposes.