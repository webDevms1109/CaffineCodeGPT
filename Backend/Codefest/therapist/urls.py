from django.urls import path
from . import views

urlpatterns = [
    path("", views.home, name="home"),
    path("checkIn", views.checkIn, name="checkIn"),
    path("checkOut", views.checkOut, name="checkOut"),
    path("sos", views.sos, name="sos")
]
