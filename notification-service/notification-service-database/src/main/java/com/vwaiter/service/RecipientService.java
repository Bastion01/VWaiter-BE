package com.vwaiter.service;

import com.vwaiter.Notification;
import com.vwaiter.Recipient;
import com.vwaiter.repository.RecipientRepository;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RecipientService {
    private final RecipientRepository recipientRepository;

    public Recipient findById(String id) {
        return recipientRepository.findById(id). orElse(null);
    }

    public List<Recipient> findAll() {
        Iterable<Recipient> recipientsIterable = recipientRepository.findAll();
        List<Recipient> recipientsList = new ArrayList<>();
        recipientsIterable.iterator().forEachRemaining(recipientsList::add);
        return recipientsList;
    }

    public void save(Recipient recipient) {
        recipientRepository.save(recipient);
    }

    public void delete(String id) {
        recipientRepository.deleteById(id);
    }

    public void addNotification(String recipientId, Notification notification) {
        if (StringUtils.isNotEmpty(recipientId)) {
            Recipient recipient = findById(recipientId);
            if (recipient != null) {
                recipient.addNotification(notification);
                recipientRepository.save(recipient);
            } else {
                Recipient newRecipient = new Recipient(recipientId, List.of(notification));
                recipientRepository.save(newRecipient);
            }
        }
    }
}
