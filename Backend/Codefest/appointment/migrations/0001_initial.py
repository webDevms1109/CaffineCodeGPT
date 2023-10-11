# Generated by Django 4.2.6 on 2023-10-11 20:24

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('client', '0001_initial'),
        ('therapist', '0001_initial'),
        ('administrator', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Appointment',
            fields=[
                ('appointment_id', models.IntegerField(auto_created=True, primary_key=True, serialize=False)),
                ('start_time', models.DateTimeField()),
                ('end_time', models.DateTimeField()),
                ('status', models.CharField(max_length=30)),
                ('admin_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='administrator.administrator')),
                ('client_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='client.client')),
                ('therapist_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='therapist.therapist')),
            ],
        ),
    ]
