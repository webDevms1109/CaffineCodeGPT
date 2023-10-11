from django.db import models
from administrator.models import Administrator
from therapist.models import Therapist
from client.models import Client

# Create your models here.
class Appointment(models.Model):
    appointment_id = models.CharField(max_length=30)
    start_time = models.DateTimeField()
    end_time = models.DateTimeField()
    status = models.CharField(max_length=30)
    client_name = models.ForeignKey(Client, on_delete=models.CASCADE)
    therapist_name = models.ForeignKey(Therapist, on_delete=models.CASCADE)
    admin_name = models.ForeignKey(Administrator, on_delete=models.CASCADE)

    def _str_(self):
        return self.name