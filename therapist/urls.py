from django.urls import path
from . import views

urlpatterns = [
    path("<str:slug>", views.home, name="home"),
    path("checkIn/<str:slug>", views.checkIn, name="checkIn"),
    path("checkOut/<str:slug>", views.checkOut, name="checkOut"),
    path("sos", views.sos, name="sos")
]
