from django.db import models

class Administrator(models.Model):
    name = models.CharField(max_length=30)
    phone_no = models.CharField(max_length=30)
    email = models.CharField(max_length=30)
    password = models.CharField(max_length=30)

    def _str_(self):
        return self.name