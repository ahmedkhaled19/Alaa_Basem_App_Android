package com.ahmed.elmalek.callBacks;

import com.ahmed.elmalek.models.NotificationModel;

import java.util.List;

public interface ProfileCallBack {

    void setNotificationData(List<NotificationModel> notificationModelList);
}
