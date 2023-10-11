from django.db import models
#from twilio.rest import Client

class Therapist(models.Model):
    therapist_id = models.IntegerField(primary_key=True, auto_created=True)
    name = models.CharField(max_length=30)
    phone_no = models.CharField(max_length=30)
    email = models.CharField(max_length=30)
    password = models.CharField(max_length=30)

    def _str_(self):
        return self.name

# Create your models here.
class SOS(models.Model):
    result = models.PositiveIntegerField()

    def __str__(self):
        return str(self.result)
    
    def save(self, *args, **kwargs):
        account_sid = 'AC5d6fca1d6a6714bf0e9371b1b9c1f3c0'
        auth_token = 'f1795eb6aac74c5c7a5fcacdcda2d185'

        client = Client(account_sid, auth_token)

        message = client.messages.create(
            body = "Hi",
            from_ = "+12293942263",
            to = "+918766516520"
        )

        print(message.sid)

        super.save(*args, **kwargs)