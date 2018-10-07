package com.ahmed.elmalek.models;

public class NotificationModel {

    private String notificationBody;
    private String notificationImage;

    public NotificationModel(String notificationBody, String notificationImage) {
        this.notificationBody = notificationBody;
        this.notificationImage = notificationImage;
    }

    public String getNotificationBody() {
        return notificationBody;
    }

    public String getNotificationImage() {
        return notificationImage;
    }
}
