package com.vorobev.generalservice.services.interfaces;

import com.vorobev.generalservice.entities.Order;

public interface IDynanamoDbQueueService {

    void addorder(Order order);
}
