package com.gluonapplication;
public class NotificationService extends NotificationData {

   public NotificationService(String name) {
       super(name);
       data = new DataSetNotification(name);
    }
}
