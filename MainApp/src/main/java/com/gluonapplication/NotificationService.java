package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;


public class NotificationService extends NotificationData {

   public NotificationService(String _name) {
       super(_name);
       data = new DataSetNotification(name);
    }
}
