package com.laurentino.notification;

import com.laurentino.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {

    private NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .message(request.message())
                .toCustomerEmail(request.toCustomerEmail())
                .sentAt(LocalDateTime.now())
                .sender("Diego")
                .build();
        notificationRepository.save(notification);
    }
}
