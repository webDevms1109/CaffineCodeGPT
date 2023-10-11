from django.shortcuts import render, HttpResponse

# Create your views here.
def home(request):
    return HttpResponse("Therapist")

def checkIn(request):
    return HttpResponse("Check In")

def checkOut(request):
    return HttpResponse("Check Out")

def sos(request):
    return HttpResponse("SOS")