from django.db import models
from administrator.models import Administrator
from therapist.models import Therapist
from client.models import Client

# Create your models here.
class Appointment(models.Model):
    appointment_id = models.IntegerField(primary_key=True, auto_created=True)
    start_time = models.DateTimeField()
    end_time = models.DateTimeField()
    status = models.CharField(max_length=30)
    client_id = models.ForeignKey(Client, on_delete=models.CASCADE)
    therapist_id = models.ForeignKey(Therapist, on_delete=models.CASCADE)
    admin_id = models.ForeignKey(Administrator, on_delete=models.CASCADE)

    def _str_(self):
        return self.name