from django.urls import path
from . import views

urlpatterns = [
    path("<str:slug>", views.home, name="home"),
    path("getTherapist/", views.getTherapist, name="getTherapist"),
    path("addTherapist/", views.addTherapist, name="addTherapist")
]