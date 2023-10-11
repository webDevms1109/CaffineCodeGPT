from django.shortcuts import render, HttpResponse

import smtplib

# Create your views here.
def home(request):
    return HttpResponse("Therapist")

def checkIn(request):
    return HttpResponse("Check In")

def checkOut(request):
    return HttpResponse("Check Out")

def sos(request):
    # creates SMTP session
    sender_email_id = "listening_ear1@outlook.com"
    sender_email_id_password = "Hello@12345"
    receiver_email_id = "administrator.models.email"

    s = smtplib.SMTP('smtp.gmail.com', 587)
    
    # start TLS for security
    s.starttls()
    
    # Authentication
    s.login("sender_email_id", "sender_email_id_password")
    
    # message to be sent
    message = "Help I am in Danger!"
    
    # sending the mail
    s.sendmail("sender_email_id", "receiver_email_id", message)
    
    # terminating the session
    s.quit()
    return HttpResponse("SOS")