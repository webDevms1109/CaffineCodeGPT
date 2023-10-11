from django.shortcuts import render, HttpResponse

# Create your views here.
def home(request):
    return HttpResponse("Administrator")

def getTherapist(request):
    return HttpResponse("Get therapist details")

def addTherapist(request):
    return HttpResponse("Add Therapist details")