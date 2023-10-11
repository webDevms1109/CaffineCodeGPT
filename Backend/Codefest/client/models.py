from django.db import models
from appointment.models import Appointment

# Create your models here.
class Client(models.Model):
    name = models.CharField(max_length=30)
    address = models.CharField(max_length=30)
    phone_no = models.CharField(max_length=30)
    email = models.CharField(max_length=30)
    password = models.CharField(max_length=30)
    appointment_id = models.ForeignKey(Appointment, on_delete=models.CASCADE)

    def _str_(self):
        return self.name